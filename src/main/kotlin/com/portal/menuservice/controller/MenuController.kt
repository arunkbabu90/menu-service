package com.portal.menuservice.controller

import com.portal.menuservice.models.domain.Menu
import com.portal.menuservice.models.dto.MenuDto
import com.portal.menuservice.models.dto.SimpleResponse
import com.portal.menuservice.service.MenuService
import com.portal.menuservice.utils.toDto
import com.portal.menuservice.utils.toMenu
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/menu")
class MenuControllerImpl(private val menuService: MenuService): MenuController {

    @GetMapping("/nav")
    override fun getNavigationMenu(): ResponseEntity<Any> {
        val menu: List<Menu> = menuService.getNavigationMenu()
        return ResponseEntity(menu, HttpStatus.OK)
    }

    @PostMapping
    override fun createNavigationMenu(@RequestBody body: MenuDto): ResponseEntity<Any> {
        val menuEntity = body.toMenu()
        val savedMenu = menuService.createNavigationMenu(menuEntity)
        val savedMenuDto = savedMenu.toDto()

        val response = SimpleResponse(
            message = "Menu Created",
            isSuccess = true,
            result = savedMenuDto
        )

        return ResponseEntity(response, HttpStatus.CREATED)
    }
}

interface MenuController {
    fun getNavigationMenu(): ResponseEntity<Any> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    fun createNavigationMenu(body: MenuDto): ResponseEntity<Any> = ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
}