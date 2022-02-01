package com.tcisoftware.sobiech.warehouse.rest

interface CSVReader {

    fun readRow(path: String)
}

class DefaultCSVReader : CSVReader {

    override fun readRow(path: String) {
        TODO("Not yet implemented")
    }

}