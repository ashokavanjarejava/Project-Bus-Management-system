package com.rbu.vendor.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rbu.vendor.beans.BusVendor;
import com.rbu.vendor.beans.BusVendorDto;
import com.rbu.vendor.repositories.BusVendorRepository;
import com.rbu.vendor.utils.WebUtils;


@Service
public class BusVendorService {

    private final BusVendorRepository busVendorRepository;

    public BusVendorService(final BusVendorRepository busVendorRepository) {
        this.busVendorRepository = busVendorRepository;
    }

    public List<BusVendorDto> findAll() {
        return busVendorRepository.findAll(Sort.by("vendorid"))
                .stream()
                .map(bUSVENDOR -> mapToDTO(bUSVENDOR, new BusVendorDto()))
                .collect(Collectors.toList());
    }

    public BusVendorDto get(final Long vendorid) {
        return busVendorRepository.findById(vendorid)
                .map(bUSVENDOR -> mapToDTO(bUSVENDOR, new BusVendorDto()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final BusVendorDto bUSVENDORDTO) {
        final BusVendor bUSVENDOR = new BusVendor();
        mapToEntity(bUSVENDORDTO, bUSVENDOR);
        return busVendorRepository.save(bUSVENDOR).getVendorid();
    }

    public void update(final Long vendorid, final BusVendorDto bUSVENDORDTO) {
        final BusVendor bUSVENDOR = busVendorRepository.findById(vendorid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(bUSVENDORDTO, bUSVENDOR);
        busVendorRepository.save(bUSVENDOR);
    }

    public void delete(final Long vendorid) {
        busVendorRepository.deleteById(vendorid);
    }

    private BusVendorDto mapToDTO(final BusVendor bUSVENDOR, final BusVendorDto bUSVENDORDTO) {
        bUSVENDORDTO.setVendorid(bUSVENDOR.getVendorid());
        bUSVENDORDTO.setVendorname(bUSVENDOR.getVendorname());
        bUSVENDORDTO.setDescription(bUSVENDOR.getDescription());
        bUSVENDORDTO.setState(bUSVENDOR.getState());
        bUSVENDORDTO.setCiti(bUSVENDOR.getCiti());
        bUSVENDORDTO.setPan(bUSVENDOR.getPan());
        bUSVENDORDTO.setGst(bUSVENDOR.getGst());
        bUSVENDORDTO.setBusinessname(bUSVENDOR.getBusinessname());
        return bUSVENDORDTO;
    }

    private BusVendor mapToEntity(final BusVendorDto bUSVENDORDTO, final BusVendor bUSVENDOR) {
        bUSVENDOR.setVendorname(bUSVENDORDTO.getVendorname());
        bUSVENDOR.setDescription(bUSVENDORDTO.getDescription());
        bUSVENDOR.setState(bUSVENDORDTO.getState());
        bUSVENDOR.setCiti(bUSVENDORDTO.getCiti());
        bUSVENDOR.setPan(bUSVENDORDTO.getPan());
        bUSVENDOR.setGst(bUSVENDORDTO.getGst());
        bUSVENDOR.setBusinessname(bUSVENDORDTO.getBusinessname());
        return bUSVENDOR;
    }

    @Transactional
    public String getReferencedWarning(final Long vendorid) {
        final BusVendor bUSVENDOR = busVendorRepository.findById(vendorid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!bUSVENDOR.getVendoridfkBUSESs().isEmpty()) {
            return WebUtils.getMessage("bUSVENDOR.bUSES.oneToMany.referenced", bUSVENDOR.getVendoridfkBUSESs().iterator().next().getBusid());
        }
        return null;
    }

}
