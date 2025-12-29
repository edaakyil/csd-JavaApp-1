package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class RegionInfo {
    public long id;
    @EqualsAndHashCode.Include
    public double east;
    @EqualsAndHashCode.Include
    public double west;
    @EqualsAndHashCode.Include
    public double north;
    @EqualsAndHashCode.Include
    public double south;
    public LocalDateTime queryDateTime;
}

