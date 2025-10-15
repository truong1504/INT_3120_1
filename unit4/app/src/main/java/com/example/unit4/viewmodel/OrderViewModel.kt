package com.example.unit4.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unit4.data.MenuItem

class OrderViewModel : ViewModel() {
    var entree: MenuItem? = null
    var side: MenuItem? = null
    var accompaniment: MenuItem? = null

    fun setEntree(item: MenuItem) {
        entree = item
    }

    fun setSide(item: MenuItem) {
        side = item
    }

    fun setAccompaniment(item: MenuItem) {
        accompaniment = item
    }

    fun getOrderTotal(): Double {
        val total = (entree?.price ?: 0.0) +
                (side?.price ?: 0.0) +
                (accompaniment?.price ?: 0.0)
        return String.format("%.2f", total).toDouble()
    }

    fun resetOrder() {
        entree = null
        side = null
        accompaniment = null
    }
}
