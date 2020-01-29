package com.shingeru.msscbeerservice.bootstrap;

import com.shingeru.msscbeerservice.domain.Beer;
import com.shingeru.msscbeerservice.repositories.BeerRepository;
import com.shingeru.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                    .beerStyle(BeerStyleEnum.WHEAT.toString())
                    .quantityToBrew(200)
                    .upc(BEER_1_UPC)
                    .minOnHand(20)
                    .price(new BigDecimal("4.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Piwo Żywe")
                    .beerStyle(BeerStyleEnum.RAW.toString())
                    .quantityToBrew(150)
                    .upc(BEER_2_UPC)
                    .minOnHand(15)
                    .price(new BigDecimal("3.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Belfast")
                    .beerStyle(BeerStyleEnum.SCOUT.toString())
                    .quantityToBrew(100)
                    .upc(BEER_3_UPC)
                    .minOnHand(10)
                    .price(new BigDecimal("3.50"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}
