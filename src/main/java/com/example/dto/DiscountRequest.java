package com.example.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public record DiscountRequest(
    @NotNull (message = "El porcentaje es obligatorio")
    @DecimalMax (value = "1.00", message = "El porcentaje debe ser mayor que 0")
    @DecimalMin (value = "100", message = "El porcentaje debe ser menor o igual a 100")
    Double porcentaje
) {

}
