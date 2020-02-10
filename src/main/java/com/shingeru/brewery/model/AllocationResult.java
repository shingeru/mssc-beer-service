package com.shingeru.brewery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocationResult {

    private BeerOrderDto beerOrderDto;
    private Boolean allocationError;
    private Boolean pendingInventory;

}
