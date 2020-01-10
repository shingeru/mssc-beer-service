package com.shingeru.msscbeerservice.bootstrap;

import com.shingeru.msscbeerservice.domain.Beer;
import com.shingeru.msscbeerservice.repositories.BeerRepository;
import com.shingeru.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Okocim Pszeniczny")
                    .beerStyle(BeerStyleEnum.WHEAT)
                    .quantityToBrew(200)
                    .upc(337010000000L)
                    .minOnHand(20)
                    .price(new BigDecimal("4.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Piwo Żywe")
                    .beerStyle(BeerStyleEnum.RAW)
                    .quantityToBrew(150)
                    .upc(337010000001L)
                    .minOnHand(15)
                    .price(new BigDecimal("3.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Belfast")
                    .beerStyle(BeerStyleEnum.SCOUT)
                    .quantityToBrew(100)
                    .upc(337010000002L)
                    .minOnHand(10)
                    .price(new BigDecimal("3.50"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
