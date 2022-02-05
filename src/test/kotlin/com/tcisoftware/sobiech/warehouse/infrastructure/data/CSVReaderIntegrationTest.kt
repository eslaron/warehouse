package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.opencsv.CSVParser
import com.tcisoftware.sobiech.warehouse.infrastructure.config.CSVReaderConfig
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
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
    fun `Should read all rows from CSV file except for 1st row - column names`() {
        // when
        val result = warehouseCSVReader.readAllRows(1)

        // then
        with(SoftAssertions()) {
            Assertions.assertThat(result[0][0].lowercase()).isNotEqualTo("datasource")
            Assertions.assertThat(result.size).isEqualTo(23198)
            assertAll()
        }
    }
}
