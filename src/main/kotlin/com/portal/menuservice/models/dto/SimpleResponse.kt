package com.portal.menuservice.models.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class SimpleResponse(
    val message: String,
    val isSuccess: Boolean,
    val result: Any
)
