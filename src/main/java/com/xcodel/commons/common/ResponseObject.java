package com.xcodel.commons.common;

import lombok.Data;

@Data
public class ResponseObject {
    private ResponseStatus responseStatus;
    private Object responseData;
}
