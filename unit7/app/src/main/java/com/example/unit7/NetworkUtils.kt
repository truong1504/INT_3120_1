package com.example.unit7_internetconnection

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object NetworkUtils {
    fun fetchData(urlString: String): String {
        return try {
            val url = URL(urlString)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connectTimeout = 5000
            connection.readTimeout = 5000

            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            val result = reader.readText()
            reader.close()
            result
        } catch (e: Exception) {
            "Lỗi: ${e.message}"
        }
    }
}
