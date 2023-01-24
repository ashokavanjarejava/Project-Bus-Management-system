package com.rbu.vendor.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbu.vendor.beans.BusTypeDto;
import com.rbu.vendor.services.BusTypeService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping(value = "/api/busTypes", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusTypeRestController {

    private final BusTypeService busTypeService;

    public BusTypeRestController(final BusTypeService busTypeService) {
        this.busTypeService = busTypeService;
    }

    @GetMapping
    public ResponseEntity<List<BusTypeDto>> getAllBUSTYPEs() {
        return ResponseEntity.ok(busTypeService.findAll());
    }

    @GetMapping("/{bustypeid}")
    public ResponseEntity<BusTypeDto> getBUSTYPE(@PathVariable final Long bustypeid) {
        return ResponseEntity.ok(busTypeService.get(bustypeid));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createBUSTYPE(@RequestBody @Valid final BusTypeDto BusTypeDto) {
        return new ResponseEntity<>(busTypeService.create(BusTypeDto), HttpStatus.CREATED);
    }

    @PutMapping("/{bustypeid}")
    public ResponseEntity<Void> updateBUSTYPE(@PathVariable final Long bustypeid,
            @RequestBody @Valid final BusTypeDto BusTypeDto) {
        busTypeService.update(bustypeid, BusTypeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{bustypeid}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteBUSTYPE(@PathVariable final Long bustypeid) {
        busTypeService.delete(bustypeid);
        return ResponseEntity.noContent().build();
    }

}
