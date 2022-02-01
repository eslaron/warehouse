package com.tcisoftware.sobiech.warehouse.service

import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
interface WarehouseService {
    fun getTotalClicks(datasource: String, dateRange: DateRange): Long
    fun getCTR(datasource: String, campaign: String): Int
    fun getImpressionsOverTime(date: String): Int
}
data class DateRange(val startDate: String, val endDate: String)

@Service
class DefaultWarehouseService : WarehouseService {

    override fun getTotalClicks(datasource: String, dateRange: DateRange): Long {
        TODO("Not yet implemented")
    }

    override fun getCTR(datasource: String, campaign: String): Int {
        TODO("Not yet implemented")
    }

    override fun getImpressionsOverTime(date: String): Int {
        TODO("Not yet implemented")
    }
}