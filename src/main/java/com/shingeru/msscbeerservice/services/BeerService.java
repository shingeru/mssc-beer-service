package com.shingeru.msscbeerservice.services;

import com.shingeru.brewery.model.BeerDto;
import com.shingeru.brewery.model.BeerPageList;
import com.shingeru.brewery.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPageList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc, Boolean showInventoryOnHand);
}
