package com.portal.menuservice.service

import com.portal.menuservice.repository.CustomMenuRepository
import org.springframework.stereotype.Service

@Service
class MenuService(private val menuRepository: CustomMenuRepository)