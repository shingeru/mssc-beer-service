package com.shingeru.msscbeerservice.services.orders;

import com.shingeru.brewery.model.events.ValidateBeerOrderRequest;
import com.shingeru.brewery.model.events.ValidateBeerOrderResponse;
import com.shingeru.msscbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class BeerOrderValidationListener {

//    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;
    private final BeerOrderValidator beerOrderValidator;


    @Transactional
    @JmsListener(destination = JmsConfig.VALIDATE_ORDER)
    public void listen(ValidateBeerOrderRequest validateBeerOrderRequest) {
//        BeerOrderDto beerOrderDto = validateBeerOrderRequest.getBeerOrderDto();

//        ValidateBeerOrderResponse validateBeerOrderResponse = new ValidateBeerOrderResponse();
//        validateBeerOrderResponse.setOrderId(beerOrderDto.getId());
////        validateBeerOrderResponse.setIsValid(true);
//        validateBeerOrderResponse.setIsValid(beerOrderValidator.validateOrder(beerOrderDto));

//        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
//            Beer beer = beerRepository.getOne(UUID.fromString(beerOrderLineDto.getUpc()));
//
//
//            if(beer == null) {
//                log.debug("ERROR::: missing beer with UPC: " + beerOrderLineDto.getUpc());
//                validateBeerOrderResponse.setIsValid(false);
//            }
//
//
//        });

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE,
            ValidateBeerOrderResponse
                .builder()
                .orderId(validateBeerOrderRequest.getBeerOrderDto().getId())
                .isValid(beerOrderValidator.validateOrder(validateBeerOrderRequest.getBeerOrderDto()))
                .build()
                );
    }

}
