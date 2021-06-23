package com.woow.tours.adapter.repository.jpa.entity;

import lombok.Builder;
import lombok.Getter;

import java.sql.Blob;

@Getter
@Builder
public class TourPhoto {

    private String id;

    private String name;

    private Blob photo;
}
