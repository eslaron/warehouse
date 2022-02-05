package com.tcisoftware.sobiech.warehouse.infrastructure.data

import com.opencsv.CSVParser
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.InputStreamReader
import java.nio.charset.Charset

interface WarehouseCSVReader {

    fun readAllRows(skipRows: Int): List<Array<String>>
}

@Component
class DefaultCSVReader(
    private val parser: CSVParser,
    @Value("\${data.import.file.path}") private val filePath: String
) : WarehouseCSVReader {

    override fun readAllRows(skipRows: Int): List<Array<String>> {
        val stream = this.javaClass.getResource(filePath)!!.openStream()
        val reader = InputStreamReader(stream, Charset.forName("UTF-8"))
        return readAllLines(reader, skipRows).readAll()
    }

    private fun readAllLines(reader: InputStreamReader, skipRows: Int) : CSVReader =
         CSVReaderBuilder(reader)
        .withSkipLines(skipRows)
        .withCSVParser(parser)
        .build()
}
