package com.example.unit4.model

import androidx.annotation.DrawableRes

/**
 * Lớp mô tả một món tráng miệng (dessert)
 * @param imageId  hình ảnh đại diện (drawable)
 * @param price     giá của món
 * @param startProductionAmount  số lượng tối thiểu để món này bắt đầu xuất hiện
 */
data class Dessert(
    @DrawableRes val imageId: Int,
    val price: Int,
    val startProductionAmount: Int
)
