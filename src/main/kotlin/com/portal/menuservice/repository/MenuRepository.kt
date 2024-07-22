package com.portal.menuservice.repository

import com.portal.menuservice.models.domain.MenuItem
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository : CustomMenuRepository
interface CustomMenuRepository : JpaRepository<MenuItem, Long>