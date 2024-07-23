package com.portal.menuservice.models.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class MenuDto(
    var name: String,
    var subMenus: MutableSet<MenuDto> = mutableSetOf()
)
