package com.tcisoftware.sobiech.warehouse.infrastructure.data

import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal object RowMapper {

    fun List<Array<String>>.mapRows(): List<CsvRow> {
        return this.map {
            CsvRow(dataSource = it[0],
                campaign = it[1],
                daily = parseDate(it[2]),
                clicks = it[3].toInt(),
                impressions = it[4].toInt()
            )
        }
    }

    private fun parseDate(date: String): LocalDate {
        val dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy")
        return LocalDate.parse(date, dateFormat)
    }
}

data class CsvRow(
    val dataSource: String,
    val campaign: String,
    val daily: LocalDate,
    val clicks: Int,
    val impressions: Int
)