package com.shingeru.msscbeerservice.web.mappers;

import com.shingeru.msscbeerservice.domain.Beer;
import com.shingeru.brewery.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

//    BeerDto beerToBeerDtoWithInventory(Beer beer);

}
