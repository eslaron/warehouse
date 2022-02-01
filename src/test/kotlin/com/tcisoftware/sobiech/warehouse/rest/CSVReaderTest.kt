package com.tcisoftware.sobiech.warehouse.rest

import com.opencsv.CSVParser
import com.tcisoftware.sobiech.warehouse.infrastructure.DefaultCSVReader
import com.tcisoftware.sobiech.warehouse.infrastructure.config.CSVReaderConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ContextConfiguration(classes = [CSVReaderConfig::class])
@ExtendWith(SpringExtension::class)
class CSVReaderTest(
    @Autowired val csvParser: CSVParser
) {

    private val warehouseCSVReader = DefaultCSVReader(csvParser, "/csv/test_data.csv")

    @Test
    fun `Should read all rows from CSV file`() {
        // given
        // when
        val result = warehouseCSVReader.readAllRows()

        // then
    }
}
