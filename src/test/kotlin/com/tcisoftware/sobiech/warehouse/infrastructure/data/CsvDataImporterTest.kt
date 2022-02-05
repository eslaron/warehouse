package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.tcisoftware.sobiech.warehouse.repository.AdvertisementRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CsvDataImporterTest {

    private val csvReader = mockk<WarehouseCSVReader>()
    private val advertisementRepository = mockk<AdvertisementRepository>()

    @Test
    fun `Should import CSV data`() {
        // given
        every { csvReader.readAllRows(any()) } returns List(2000) {
            arrayOf(
                "Google Ads",
                "Adventmarkt Touristik",
                "01/15/19",
                "50",
                "200"
            )
        }
        every { advertisementRepository.saveAll(any()) } returns Unit

        // when
        CsvDataImporter(csvReader, advertisementRepository)

        // then
        verify(exactly = 20) {
            advertisementRepository.saveAll(withArg {
                assertThat(it.size).isEqualTo(100)
                assertThat(it[0]).isInstanceOf(CsvRow::class.java)
            })
        }
    }
}
