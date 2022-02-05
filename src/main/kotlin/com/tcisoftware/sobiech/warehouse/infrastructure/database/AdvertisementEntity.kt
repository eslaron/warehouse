package com.tcisoftware.sobiech.warehouse.infrastructure.database

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name="ADVERTISEMENT")
class AdvertisementEntity {

    @Id
    @GeneratedValue
    var id: Long = 0
    lateinit var dataSource: String
    lateinit var campaign: String
    lateinit var daily: LocalDate
    var clicks: Int = 0
    var impressions: Int = 0
}
