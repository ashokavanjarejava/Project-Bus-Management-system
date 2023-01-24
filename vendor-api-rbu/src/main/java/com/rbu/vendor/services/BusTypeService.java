package com.rbu.vendor.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.rbu.vendor.beans.BusType;
import com.rbu.vendor.beans.BusTypeDto;
import com.rbu.vendor.repositories.BusTypeRepository;
import com.rbu.vendor.utils.WebUtils;


@Service
public class BusTypeService {

    private final BusTypeRepository busTypeRepository;

    public BusTypeService(final BusTypeRepository busTypeRepository) {
        this.busTypeRepository = busTypeRepository;
    }

    public List<BusTypeDto> findAll() {
        return busTypeRepository.findAll(Sort.by("bustypeid"))
                .stream()
                .map(bUSTYPE -> mapToDTO(bUSTYPE, new BusTypeDto()))
                .collect(Collectors.toList());
    }

    public BusTypeDto get(final Long bustypeid) {
        return busTypeRepository.findById(bustypeid)
                .map(bUSTYPE -> mapToDTO(bUSTYPE, new BusTypeDto()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final BusTypeDto bUSTYPEDTO) {
        final BusType bUSTYPE = new BusType();
        mapToEntity(bUSTYPEDTO, bUSTYPE);
        return busTypeRepository.save(bUSTYPE).getBustypeid();
    }

    public void update(final Long bustypeid, final BusTypeDto bUSTYPEDTO) {
        final BusType bUSTYPE = busTypeRepository.findById(bustypeid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(bUSTYPEDTO, bUSTYPE);
        busTypeRepository.save(bUSTYPE);
    }

    public void delete(final Long bustypeid) {
        busTypeRepository.deleteById(bustypeid);
    }

    private BusTypeDto mapToDTO(final BusType bUSTYPE, final BusTypeDto bUSTYPEDTO) {
        bUSTYPEDTO.setBustypeid(bUSTYPE.getBustypeid());
        bUSTYPEDTO.setBustype(bUSTYPE.getBustype());
        bUSTYPEDTO.setDescription(bUSTYPE.getDescription());
        bUSTYPEDTO.setIsactive(bUSTYPE.getIsactive());
        return bUSTYPEDTO;
    }

    private BusType mapToEntity(final BusTypeDto bUSTYPEDTO, final BusType bUSTYPE) {
        bUSTYPE.setBustype(bUSTYPEDTO.getBustype());
        bUSTYPE.setDescription(bUSTYPEDTO.getDescription());
        bUSTYPE.setIsactive(bUSTYPEDTO.getIsactive());
        return bUSTYPE;
    }

    @Transactional
    public String getReferencedWarning(final Long bustypeid) {
        final BusType bUSTYPE = busTypeRepository.findById(bustypeid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!bUSTYPE.getBustypeidBUSESs().isEmpty()) {
            return WebUtils.getMessage("bUSTYPE.bUSES.oneToMany.referenced", bUSTYPE.getBustypeidBUSESs().iterator().next().getBusid());
        }
        return null;
    }

}
