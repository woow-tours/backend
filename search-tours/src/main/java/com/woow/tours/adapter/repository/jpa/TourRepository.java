package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.TourTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends JpaRepository<TourTable, Long> {

    Optional<TourTable> findByCode(@Param("code") Long code);

    @Query(value = "select distinct t from TourTable t join t.places tp where tp.id in :ids")
    Page<TourTable> findByPLacesId(@Param("ids") List<Long> ids, Pageable pageable);
}
