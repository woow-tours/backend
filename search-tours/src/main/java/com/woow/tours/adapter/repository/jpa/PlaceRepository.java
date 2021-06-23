package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.PlaceTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<PlaceTable, Long> {

    @Query(value = "select p from PlaceTable p where id in :ids")
    List<PlaceTable> findPlacesById(@Param("ids") List<Long> ids);
}
