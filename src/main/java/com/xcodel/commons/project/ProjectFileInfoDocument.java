package com.xcodel.commons.project;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectFileInfoDocument {
    private Long projectInfoId;
    private ProjectFileType projectFileType;
    private String basePointId;
    private List<String> fileNames = new ArrayList<>();
    private List<String> fileLocations = new ArrayList<>();
    private String antennaHeight;
    private String antennaBrand;
    private String antennaModel;
    private String gpsCoordinatesLat;
    private String gpsCoordinatesLon;
    private String gpsCoordinatesZ;
    private String message;
}
