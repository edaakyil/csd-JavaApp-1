package com.edaakyil.earthquake.lib.data.repository.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
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

