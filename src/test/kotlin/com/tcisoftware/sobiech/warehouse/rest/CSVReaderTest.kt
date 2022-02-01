package com.tcisoftware.sobiech.warehouse.rest

import org.junit.jupiter.api.Test

class CSVReaderTest {

    private val csvReader = DefaultCSVReader()

    @Test
    fun `Should read 1 row from CSV file`() {
        // given

        // when
        val result = csvReader.readRow("/csv/test_data.csv")

        // then
    }
}
