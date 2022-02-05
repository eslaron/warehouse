package com.tcisoftware.sobiech.warehouse.infrastructure.database

import com.tcisoftware.sobiech.warehouse.infrastructure.data.CsvRow

internal object AdvertisementEntityMapper {

    fun CsvRow.toEntity(): AdvertisementEntity {
        val entity =  AdvertisementEntity()

        entity.dataSource = this.dataSource
        entity.campaign = this.campaign
        entity.daily = this.daily
        entity.clicks = this.clicks
        entity.impressions = this.impressions

        return entity
    }
}