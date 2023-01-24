package com.rbu.vendor.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rbu.vendor.beans.Buses;
import com.rbu.vendor.beans.BusesDto;
import com.rbu.vendor.beans.BusType;
import com.rbu.vendor.beans.BusVendor;
import com.rbu.vendor.repositories.BusTypeRepository;
import com.rbu.vendor.repositories.BusVendorRepository;
import com.rbu.vendor.repositories.BusesRepository;

@Service
public class BusesService {

	private final BusesRepository busesRepository;
	private final BusTypeRepository busTypeRepository;
	private final BusVendorRepository busVendorRepository;

	public BusesService(final BusesRepository bUSESRepository, final BusTypeRepository bUSTYPERepository,
			final BusVendorRepository bUSVENDORRepository) {
		this.busesRepository = bUSESRepository;
		this.busTypeRepository = bUSTYPERepository;
		this.busVendorRepository = bUSVENDORRepository;
	}

	public List<BusesDto> findAll() {
		return busesRepository.findAll(Sort.by("busid")).stream().map(buses -> mapToDTO(buses, new BusesDto()))
				.collect(Collectors.toList());
	}

	public BusesDto get(final Long busid) {
		return busesRepository.findById(busid).map(buses -> mapToDTO(buses, new BusesDto()))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Long create(final BusesDto bUSESDTO) {
		final Buses buses = new Buses();
		mapToEntity(bUSESDTO, buses);
		return busesRepository.save(buses).getBusid();
	}

	public void update(final Long busid, final BusesDto bUSESDTO) {
		final Buses bUSES = busesRepository.findById(busid)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		mapToEntity(bUSESDTO, bUSES);
		busesRepository.save(bUSES);
	}

	public void delete(final Long busid) {
		busesRepository.deleteById(busid);
	}

	private BusesDto mapToDTO(final Buses bUSES, final BusesDto bUSESDTO) {
		bUSESDTO.setBusid(bUSES.getBusid());
		bUSESDTO.setBusname(bUSES.getBusname());
		bUSESDTO.setSeatcapacity(bUSES.getSeatcapacity());
		bUSESDTO.setSleeperud(bUSES.getSleeperud());
		bUSESDTO.setSleeperld(bUSES.getSleeperld());
		bUSESDTO.setBusdescription(bUSES.getBusdescription());
		bUSESDTO.setBustypeid(bUSES.getBustypeid() == null ? null : bUSES.getBustypeid().getBustypeid());
		bUSESDTO.setVendoridfk(bUSES.getVendoridfk() == null ? null : bUSES.getVendoridfk().getVendorid());
		return bUSESDTO;
	}

	private Buses mapToEntity(final BusesDto bUSESDTO, final Buses bUSES) {
		bUSES.setBusname(bUSESDTO.getBusname());
		bUSES.setSeatcapacity(bUSESDTO.getSeatcapacity());
		bUSES.setSleeperud(bUSESDTO.getSleeperud());
		bUSES.setSleeperld(bUSESDTO.getSleeperld());
		bUSES.setBusdescription(bUSESDTO.getBusdescription());
		final BusType bustypeid = bUSESDTO.getBustypeid() == null ? null
				: busTypeRepository.findById(bUSESDTO.getBustypeid())
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "bustypeid not found"));
		bUSES.setBustypeid(bustypeid);
		final BusVendor vendoridfk = bUSESDTO.getVendoridfk() == null ? null
				: busVendorRepository.findById(bUSESDTO.getVendoridfk())
						.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "vendoridfk not found"));
		bUSES.setVendoridfk(vendoridfk);
		return bUSES;
	}

}
