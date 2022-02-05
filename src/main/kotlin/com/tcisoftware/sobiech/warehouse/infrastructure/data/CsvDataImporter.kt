package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.tcisoftware.sobiech.warehouse.infrastructure.data.RowMapper.mapRows
import com.tcisoftware.sobiech.warehouse.repository.AdvertisementRepository
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.stereotype.Component

@Component
@ConditionalOnProperty("data.import.enabled")
private class CsvDataImporter(
    csvReader: WarehouseCSVReader,
    advertisementRepository: AdvertisementRepository
) {
    init {
        val mappedRows = csvReader.readAllRows(1).mapRows()
        advertisementRepository.saveAll(mappedRows)
    }
}
