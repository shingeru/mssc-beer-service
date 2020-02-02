package com.shingeru.msscbeerservice.services.brewing;

import com.shingeru.msscbeerservice.config.JmsConfig;
import com.shingeru.msscbeerservice.domain.Beer;
import com.shingeru.msscbeerservice.events.BrewBeerEvent;
import com.shingeru.msscbeerservice.events.NewInventoryEvent;
import com.shingeru.msscbeerservice.repositories.BeerRepository;
import com.shingeru.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;


    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event) {
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());

        beerDto.setQuantityOnHand(beer.getQuantityToBrew()); // a bit simplify...

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);

        log.debug("Brewing beer "+ beer.getMinOnHand() + " :  QOH: " + beerDto.getQuantityOnHand() + ".... done");

        jmsTemplate.convertAndSend(JmsConfig.BREWING_INVENTORY_QUEUE, newInventoryEvent);
    }
}
