package com.rbu.vendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbu.vendor.beans.Buses;

public interface BusesRepository extends JpaRepository<Buses, Long>{

}
