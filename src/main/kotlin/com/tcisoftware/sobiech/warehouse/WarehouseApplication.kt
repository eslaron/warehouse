package com.tcisoftware.sobiech.warehouse

import com.tcisoftware.sobiech.warehouse.infrastructure.RowMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WarehouseApplication

fun main(args: Array<String>) {
	runApplication<WarehouseApplication>(*args)
}
