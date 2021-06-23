package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.CityTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityTable, Long> {

}
