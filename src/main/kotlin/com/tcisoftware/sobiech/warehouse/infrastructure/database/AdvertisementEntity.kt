package com.tcisoftware.sobiech.warehouse.infrastructure.database

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="ADVERTISEMENT")
class AdvertisementEntity {

    @Id
    private var id: UUID = UUID.randomUUID()
    lateinit var dataSource: String
    lateinit var campaign: String
    lateinit var daily: LocalDate
    var clicks: Int = 0
    var impressions: Int = 0
}
