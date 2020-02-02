package com.shingeru.msscbeerservice.events;

import com.shingeru.msscbeerservice.web.model.BeerDto;

public class BrewBeerEvent extends BeerEvent {
    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
