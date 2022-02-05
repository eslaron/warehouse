package com.tcisoftware.sobiech.warehouse.repository

import com.tcisoftware.sobiech.warehouse.infrastructure.data.CsvRow
import com.tcisoftware.sobiech.warehouse.infrastructure.database.AdvertisementEntity
import com.tcisoftware.sobiech.warehouse.infrastructure.database.AdvertisementEntityMapper.toEntity
import com.tcisoftware.sobiech.warehouse.infrastructure.date.DateParser.parseDate
import com.tcisoftware.sobiech.warehouse.service.DateRange
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.time.LocalDate

interface AdvertisementRepository {

    fun save(csvRow: CsvRow): AdvertisementEntity
    fun saveAll(rows: List<CsvRow>)
    fun countAllRows(): Long
    fun getTotalClicks(dataSource: String, dateRange: DateRange): Long
}

@Component
class DefaultAdvertisementRepository(private val jpaRepository: JpaAdvertisementRepository) : AdvertisementRepository {

    override fun save(csvRow: CsvRow) = jpaRepository.save(csvRow.toEntity())

    override fun saveAll(rows: List<CsvRow>) = rows.forEach { save(it) }

    override fun countAllRows(): Long = jpaRepository.count()

    override fun getTotalClicks(dataSource: String, dateRange: DateRange) =
        jpaRepository.countByDataSourceAndDailyIsBetween(
            dataSource,
            parseDate(dateRange.startDate),
            parseDate(dateRange.endDate)
        )
}

@Repository
interface JpaAdvertisementRepository: CrudRepository<AdvertisementEntity, Long> {

    fun countByDataSourceAndDailyIsBetween(dataSource: String, startDate: LocalDate, endDate: LocalDate): Long
}
