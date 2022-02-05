package com.tcisoftware.sobiech.warehouse.service

import com.tcisoftware.sobiech.warehouse.repository.AdvertisementRepository
import org.springframework.stereotype.Service

interface WarehouseService {
    fun getTotalClicks(dataSource: String, dateRange: DateRange): Long
    fun getCTR(dataSource: String, campaign: String): Double
    fun getImpressionsOverTime(date: String): Int
}

data class DateRange(val startDate: String, val endDate: String)

@Service
class DefaultWarehouseService(private val repository: AdvertisementRepository) : WarehouseService {

    override fun getTotalClicks(dataSource: String, dateRange: DateRange) =
        repository.getTotalClicks(dataSource, dateRange)

    override fun getCTR(dataSource: String, campaign: String) =
        with (repository.getAdsByDataSourceAndCampaign(dataSource, campaign)) {
            sumOf { it.clicks }.toDouble() / sumOf { it.impressions }.toDouble()
        }

    override fun getImpressionsOverTime(date: String): Int =
        repository.getAdsByDaily(date).sumOf { it.impressions }
}
