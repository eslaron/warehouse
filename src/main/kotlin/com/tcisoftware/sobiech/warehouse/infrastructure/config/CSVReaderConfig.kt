package com.tcisoftware.sobiech.warehouse.infrastructure.config

import com.opencsv.CSVParser
import com.opencsv.CSVParserBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CSVReaderConfig {

    @Bean
    fun csvParser(): CSVParser = CSVParserBuilder()
        .withSeparator(',')
        .withIgnoreQuotations(true)
        .build()
}
