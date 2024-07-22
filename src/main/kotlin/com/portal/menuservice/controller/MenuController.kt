package com.portal.menuservice.controller

import com.portal.menuservice.service.MenuService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/menu")
class MenuControllerImpl(private val menuService: MenuService): MenuController {

    @GetMapping
    override fun getNavigationMenu(): ResponseEntity<Any> {
        return super.getNavigationMenu()
    }
}

interface MenuController {
    fun getNavigationMenu(): ResponseEntity<Any> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
}