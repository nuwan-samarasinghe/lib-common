package com.xcodel.commons.common;

import lombok.Data;

@Data
public class ResponseStatus {
    private Integer resultCode;
    private String resultDescription;
}
