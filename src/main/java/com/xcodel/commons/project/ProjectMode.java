package com.xcodel.commons.project;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProjectMode {

    GRID("grid"),
    LAT("lat");

    private String name;

}
