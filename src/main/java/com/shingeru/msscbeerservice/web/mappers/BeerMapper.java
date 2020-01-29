package com.shingeru.msscbeerservice.web.mappers;

import com.shingeru.msscbeerservice.domain.Beer;
import com.shingeru.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
