package com.shingeru.msscbeerservice.services.orders;

import com.shingeru.brewery.model.BeerOrderDto;
import com.shingeru.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Component
@Slf4j
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public Boolean validateOrder(BeerOrderDto beerOrderDto) {

        AtomicInteger beersNotFound = new AtomicInteger();

//        Boolean isValid = true;

        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
            beerRepository.findByUpc(beerOrderLineDto.getUpc());

            if(beerRepository.findByUpc(beerOrderLineDto.getUpc()) == null) {
                log.debug("ERROR::: missing beer with UPC: " + beerOrderLineDto.getUpc());
                beersNotFound.incrementAndGet();
            }


        });
        return beersNotFound.get() == 0;
    }



}
