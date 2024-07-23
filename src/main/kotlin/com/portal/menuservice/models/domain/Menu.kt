package com.portal.menuservice.models.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "menus")
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    var parent: Menu? = null,

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL])
    @JsonManagedReference
    var subMenus: MutableSet<Menu> = mutableSetOf()
)
