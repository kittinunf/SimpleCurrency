package com.worker8.currencylayer.network

import com.squareup.moshi.Moshi
import com.worker8.currencylayer.model.Quotes
import com.worker8.currencylayer.response.UsdCurrencyResponse
import java.io.BufferedReader

class SeedCurrencyLayerLiveService(val moshi: Moshi) {
    val json: String by lazy {
        val inputStream = javaClass.classLoader.getResourceAsStream("usd_based_currencies.json")
        inputStream.bufferedReader().use(BufferedReader::readText)
    }

    fun getSeedCurrencies(): Quotes {
        val jsonAdapter = moshi.adapter(UsdCurrencyResponse::class.java)
        val response = jsonAdapter.fromJson(json)
        return response?.quotes ?: Quotes()
    }

}