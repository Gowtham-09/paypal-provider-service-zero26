package com.hulkhiretech.payments.pojo;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating a PayPal order.")
public class CreateOrderReq {

    @Schema(
        description = "URL to which the customer will be redirected after successfully completing the payment.",
        example = "http://merchantwebsite.com/returnUrl",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String returnUrl;

    @Schema(
        description = "URL to which the customer will be redirected if they cancel the payment.",
        example = "http://merchantwebsite.com/cancelUrl",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String cancelUrl;

    @Schema(
        description = "Three-letter ISO 4217 currency code representing the payment currency.",
        example = "USD",
        defaultValue = "USD",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private String currencyCode;

    @Schema(
        description = "Total payment amount to be charged to the customer. Must be a positive monetary value.",
        example = "100.00",
        minimum = "0.01",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    private BigDecimal amount;
}
