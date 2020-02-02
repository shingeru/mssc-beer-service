package com.shingeru.msscbeerservice.web.controller;

import com.shingeru.msscbeerservice.services.BeerService;
import com.shingeru.msscbeerservice.web.model.BeerDto;
import com.shingeru.msscbeerservice.web.model.BeerPageList;
import com.shingeru.msscbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    public static final Integer DEFAULT_PAGE_NUMBER = 0;
    public static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerService beerService;

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<BeerPageList> listBeers(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                                  @RequestParam(value = "pageSize", required = false) Integer pageSize,
                                                  @RequestParam(value = "beerName", required = false) String beerName,
                                                  @RequestParam(value = "beerStyle", required = false) BeerStyleEnum beerStyle,
                                                  @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {

        if (showInventoryOnHand == null)
            showInventoryOnHand = false;

        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 0) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        BeerPageList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);

        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable("beerId") UUID beerId,
                                               @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null)
            showInventoryOnHand = false;
        //todo impl
//        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
        return new ResponseEntity<>(beerService.getById(beerId, showInventoryOnHand), HttpStatus.OK);
    }

    @GetMapping("/beerUpc/{upc}")
    public ResponseEntity<BeerDto> getBeerByUpd(@NotNull @PathVariable("upc") String upc, @RequestParam(value = "showInventoryOnHand", required = false) Boolean showInventoryOnHand) {
        if (showInventoryOnHand == null)
            showInventoryOnHand = false;

        return new ResponseEntity<>(beerService.getByUpc(upc, showInventoryOnHand), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto) {

//        return new ResponseEntity(HttpStatus.CREATED);
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@NotNull @PathVariable("beerId") UUID beerId, @Validated @RequestBody BeerDto beerDto) {

        //todo impl
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);

    }
}
