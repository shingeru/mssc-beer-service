package com.shingeru.brewery.model.events;


import com.shingeru.brewery.model.BeerDto;
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
