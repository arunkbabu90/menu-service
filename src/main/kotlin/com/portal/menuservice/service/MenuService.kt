package com.portal.menuservice.service

import com.portal.menuservice.models.domain.Menu
import com.portal.menuservice.repository.CustomMenuRepository
import org.springframework.stereotype.Service

@Service
class MenuServiceImpl(private val menuRepository: CustomMenuRepository) : MenuService {
    override fun getNavigationMenu(): List<Menu> {
        return menuRepository.findAll()
    }

    override fun createNavigationMenu(menu: Menu): Menu {
//        val savableMenu = assignIdToMenu(menu)
        return menuRepository.save(menu)
    }

    private fun assignIdToMenu(menu: Menu): Menu {
        val latestMenuId = menuRepository.findLatestId()
        var newMenuId = latestMenuId + 1

        menu.id = newMenuId

        menu.subMenus.forEachIndexed { index, subMenu ->
            subMenu.id = ++newMenuId
            subMenu.subMenus = subMenu.subMenus
        }

//        menu.subMenus.forEach {
//            it.id = ++newMenuId
//            it.subMenus = it.subMenus
//        }

        return menu
    }
}

interface MenuService {
    fun getNavigationMenu() = listOf<Menu>()
    fun createNavigationMenu(menu: Menu): Menu = Menu()
}