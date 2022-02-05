package com.tcisoftware.sobiech.warehouse.service

import com.tcisoftware.sobiech.warehouse.repository.AdvertisementRepository
import org.springframework.stereotype.Service

interface WarehouseService {
    fun getTotalClicks(datasource: String, dateRange: DateRange): Long
    fun getCTR(datasource: String, campaign: String): Int
    fun getImpressionsOverTime(date: String): Int
}

data class DateRange(val startDate: String, val endDate: String)

@Service
class DefaultWarehouseService(private val repository: AdvertisementRepository) : WarehouseService {

    override fun getTotalClicks(datasource: String, dateRange: DateRange) =
        repository.getTotalClicks(datasource, dateRange)

    override fun getCTR(datasource: String, campaign: String): Int =
        repository.getCTR(datasource, campaign)

    override fun getImpressionsOverTime(date: String): Int =
        repository.getImpressionsOverTime(date)
}
