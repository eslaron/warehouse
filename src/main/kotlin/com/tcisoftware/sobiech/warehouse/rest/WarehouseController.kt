package com.tcisoftware.sobiech.warehouse.rest

import com.tcisoftware.sobiech.warehouse.service.DateRange
import com.tcisoftware.sobiech.warehouse.service.WarehouseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/ads")
class WarehouseController(
    private val warehouseService: WarehouseService
) {
    @GetMapping("/total-clicks")
    fun getTotalClicks(
        @RequestParam datasource: String,
        @RequestParam startDate: String,
        @RequestParam  endDate: String
    ) {
        warehouseService.getTotalClicks(datasource, DateRange(startDate, endDate))
    }

    @GetMapping("/ctr")
    fun getCTR(@RequestParam datasource: String, @RequestParam campaign: String) {
        warehouseService.getCTR(datasource, campaign)
    }

    @GetMapping("/impressions-over-time")
    fun getImpressionOverTime(@RequestParam date: String) {
        warehouseService.getImpressionsOverTime(date)
    }
}
