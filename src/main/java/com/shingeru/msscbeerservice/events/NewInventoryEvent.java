package com.shingeru.msscbeerservice.events;

import com.shingeru.msscbeerservice.web.model.BeerDto;

public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
