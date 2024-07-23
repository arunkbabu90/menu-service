package com.portal.menuservice.repository

import com.portal.menuservice.models.domain.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MenuRepository : CustomMenuRepository

interface CustomMenuRepository : JpaRepository<Menu, Long> {

    @Query("SELECT COALESCE(MAX(mnu.id), 0) FROM Menu mnu")
    fun findLatestId(): Long
}