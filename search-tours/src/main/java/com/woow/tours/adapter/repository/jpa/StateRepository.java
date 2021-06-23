package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.StateTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StateRepository extends JpaRepository<StateTable, Long> {

    Optional<StateTable> findByCode(@Param("code") Long code);

    @Query("select s from StateTable s join fetch s.cities c where s.id = :id")
    Optional<StateTable> getState(@Param("id") Long id);
}
