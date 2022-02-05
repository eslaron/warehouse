package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.opencsv.CSVParser
import com.tcisoftware.sobiech.warehouse.infrastructure.config.CSVReaderConfig
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [CSVReaderConfig::class])
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CSVReaderIntegrationTest(
    csvParser: CSVParser
) {

    private val warehouseCSVReader = DefaultCSVReader(csvParser, "/csv/data.csv")

    @Test
    fun `Should read all rows from CSV file`() {
        // given
        // when
        val result = warehouseCSVReader.readAllRows(0)

        // then
    }
}
