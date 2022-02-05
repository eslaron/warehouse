package com.tcisoftware.sobiech.warehouse.infrastructure.date

import java.time.LocalDate
import java.time.format.DateTimeFormatter

internal object DateParser {

    fun parseDate(date: String): LocalDate {
        val dateFormat = DateTimeFormatter.ofPattern("MM/dd/yy")
        return LocalDate.parse(date, dateFormat)
    }
}