package com.shingeru.brewery.model.events;

import com.shingeru.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeerOrderEvent implements Serializable {

    static final long serialVersionUID = 1195947108340475202L;

    private BeerOrderDto beerOrderDto;
}
