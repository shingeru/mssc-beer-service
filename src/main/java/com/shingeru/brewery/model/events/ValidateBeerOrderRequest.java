package com.shingeru.brewery.model.events;

import com.shingeru.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateBeerOrderRequest {

    BeerOrderDto beerOrderDto;

}
