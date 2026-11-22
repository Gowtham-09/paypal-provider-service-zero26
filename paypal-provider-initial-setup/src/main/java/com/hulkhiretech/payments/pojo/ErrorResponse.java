package com.hulkhiretech.payments.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Simple error response returned to API clients when an exception occurs.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private  String errorCode;
    private  String errorMessage;
    
}
