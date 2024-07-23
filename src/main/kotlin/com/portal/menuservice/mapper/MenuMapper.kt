package com.portal.menuservice.mapper

import com.portal.menuservice.models.domain.Menu
import com.portal.menuservice.models.dto.MenuDto
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring")
interface MenuMapper {
    companion object {
        val INSTANCE: MenuMapper = Mappers.getMapper(MenuMapper::class.java)
    }

//    @Mapping(target = "subMenus", ignore = true)
    fun toMenuDto(menu: Menu): MenuDto

//    @Mapping(target = "subMenus", ignore = true)
    fun toMenu(menuDto: MenuDto): Menu

    // Custom method to handle recursive submenus
//    fun toMenuDtoWithSubMenus(menu: Menu): MenuDto {
//        val menuDto = toMenuDto(menu)
//        menuDto.subMenus = menu.subMenus.map { toMenuDtoWithSubMenus(it) }.toSet()
//        return menuDto
//    }
//
//    // Custom method to handle recursive submenus
//    fun toMenuWithSubMenus(menuDto: MenuDto): Menu {
//        val menu = toMenu(menuDto)
//        menu.subMenus = menuDto.subMenus.map { toMenuWithSubMenus(it) }.toMutableSet()
//        return menu
//    }
}