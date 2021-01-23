package com.xcodel.commons.common;

import lombok.Data;

import java.util.Objects;

@Data
public class ResponseObject {
    private ResponseStatus responseStatus;
    private Objects responseData;
}
