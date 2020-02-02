package com.shingeru.msscbeerservice.events;


import com.shingeru.msscbeerservice.web.model.BeerDto;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 1195947108340475202L;

    private BeerDto beerDto;
}
