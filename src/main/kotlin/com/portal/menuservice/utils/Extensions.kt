package com.portal.menuservice.utils

import com.portal.menuservice.mapper.MenuMapper
import com.portal.menuservice.models.domain.Menu
import com.portal.menuservice.models.dto.MenuDto

fun Menu.toDto() = MenuMapper.INSTANCE.toMenuDto(this)
fun MenuDto.toMenu() = MenuMapper.INSTANCE.toMenu(this)

//fun Menu.toDto(): MenuDto {
//    return MenuDto(
//        name = this.name,
//        subMenus = this.subMenus.map { it.toDto() }.toMutableSet()
//    )
//}
//
//fun MenuDto.toMenu(): Menu {
//    return Menu(
//        name = this.name,
//        subMenus = this.subMenus.map { it.toMenu() }.toMutableSet()
//    )
//}
