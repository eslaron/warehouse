package com.tcisoftware.sobiech.warehouse.infrastructure

import org.springframework.stereotype.Component
import java.time.LocalDate

interface RowMapper {

    fun mapRows(): List<Row>
}

@Component
class DefaultRowMapper(val warehouseCSVReader: WarehouseCSVReader): RowMapper {

    override fun mapRows(): List<Row> {
        val rows = warehouseCSVReader.readAllRows()
        return rows.map { Row(it[0], it[1], null, null) }
    }

}

data class Row(
    val dataSource: String,
    val campaign: String,
    val date: LocalDate?,
    val dailyClicks: Long?
)
