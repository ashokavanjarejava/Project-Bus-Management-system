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

import com.rbu.vendor.beans.BusVendorDto;
import com.rbu.vendor.services.BusVendorService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping(value = "/api/busvendors", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusVendorRestController {

    private final BusVendorService busVendorService;

    public BusVendorRestController(final BusVendorService busVendorService) {
        this.busVendorService = busVendorService;
    }

    @GetMapping
    public ResponseEntity<List<BusVendorDto>> getAllBUSVENDORs() {
        return ResponseEntity.ok(busVendorService.findAll());
    }

    @GetMapping("/{vendorid}")
    public ResponseEntity<BusVendorDto> getBUSVENDOR(@PathVariable final Long vendorid) {
        return ResponseEntity.ok(busVendorService.get(vendorid));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createBUSVENDOR(
            @RequestBody @Valid final BusVendorDto BusVendorDto) {
        return new ResponseEntity<>(busVendorService.create(BusVendorDto), HttpStatus.CREATED);
    }

    @PutMapping("/{vendorid}")
    public ResponseEntity<Void> updateBUSVENDOR(@PathVariable final Long vendorid,
            @RequestBody @Valid final BusVendorDto BusVendorDto) {
        busVendorService.update(vendorid, BusVendorDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{vendorid}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteBUSVENDOR(@PathVariable final Long vendorid) {
        busVendorService.delete(vendorid);
        return ResponseEntity.noContent().build();
    }

}
