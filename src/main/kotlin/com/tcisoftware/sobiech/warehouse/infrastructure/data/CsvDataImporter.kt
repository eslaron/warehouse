package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.tcisoftware.sobiech.warehouse.infrastructure.data.RowMapper.mapRows
import com.tcisoftware.sobiech.warehouse.repository.AdvertisementRepository
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("data.import.enabled")
private class CsvDataImporter(
    csvReader: WarehouseCSVReader,
    advertisementRepository: AdvertisementRepository
) {
    private val logger = KotlinLogging.logger {}
    private var counter = 0

    init {
        val mappedRowBatches = csvReader.readAllRows(1).mapRows().chunked(100)

        logger.info { "========================== IMPORT STARTED ===============================" }

        mappedRowBatches.forEach {
            advertisementRepository.saveAll(it)
            counter+= it.size
            logger.info { "$counter rows imported." }
        }

        logger.info { "========================== IMPORT ENDED =================================" }
        logger.info { "Total rows imported: ${advertisementRepository.countAllRows()}" }
    }
}
