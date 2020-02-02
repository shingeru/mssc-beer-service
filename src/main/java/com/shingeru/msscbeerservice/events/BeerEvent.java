package com.shingeru.msscbeerservice.events;


import com.shingeru.msscbeerservice.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 1195947108340475202L;

    private final BeerDto beerDto;
}
