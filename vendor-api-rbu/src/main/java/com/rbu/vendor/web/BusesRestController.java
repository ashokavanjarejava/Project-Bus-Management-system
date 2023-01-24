package com.rbu.vendor.web;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

import com.rbu.vendor.beans.BusesDto;
import com.rbu.vendor.services.BusesService;


@RestController
@RequestMapping(value = "/api/buses", produces = MediaType.APPLICATION_JSON_VALUE)
public class BusesRestController {

    private final BusesService busesService;

    public BusesRestController(final BusesService busesService) {
        this.busesService = busesService;
    }

    @GetMapping
    public ResponseEntity<List<BusesDto>> getAllBUSESs() {
        return ResponseEntity.ok(busesService.findAll());
    }

    @GetMapping("/{busid}")
    public ResponseEntity<BusesDto> getBUSES(@PathVariable final Long busid) {
        return ResponseEntity.ok(busesService.get(busid));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createBUSES(@RequestBody @Valid final BusesDto BusesDto) {
        return new ResponseEntity<>(busesService.create(BusesDto), HttpStatus.CREATED);
    }

    @PutMapping("/{busid}")
    public ResponseEntity<Void> updateBUSES(@PathVariable final Long busid,
            @RequestBody @Valid final BusesDto BusesDto) {
        busesService.update(busid, BusesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{busid}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteBUSES(@PathVariable final Long busid) {
        busesService.delete(busid);
        return ResponseEntity.noContent().build();
    }

}
