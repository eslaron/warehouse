package com.tcisoftware.sobiech.warehouse.repository

import com.tcisoftware.sobiech.warehouse.infrastructure.data.CsvRow
import com.tcisoftware.sobiech.warehouse.infrastructure.database.AdvertisementEntity
import com.tcisoftware.sobiech.warehouse.infrastructure.database.AdvertisementEntityMapper.toEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.*

interface AdvertisementRepository {

    fun save(row: CsvRow)
    fun saveAll(rows: List<CsvRow>)
    fun countAllRows(): Long
}

@Component
class DefaultAdvertisementRepository(private val jpaRepository: JpaAdvertisementRepository) : AdvertisementRepository {

    override fun save(csvRow: CsvRow) {
        jpaRepository.save(csvRow.toEntity())
    }

    override fun saveAll(rows: List<CsvRow>) {
        rows.forEach { save(it) }
    }

    override fun countAllRows(): Long = jpaRepository.count()
}

@Repository
interface JpaAdvertisementRepository: CrudRepository<AdvertisementEntity, Long>
