/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.data

data class PhotosResponse(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>
)

data class Photo(
    val alt: String = "",
    val avg_color: String = "",
    val height: Int = 0,
    val id: Int = 0,
    val liked: Boolean = false,
    val photographer: String = "",
    val photographer_id: Int = 0,
    val photographer_url: String = "",
    val src: Src = Src(),
    val url: String = "",
    val width: Int = 0
)

data class Src(
    val landscape: String = "",
    val large: String = "",
    val large2x: String = "",
    val medium: String = "",
    val original: String = "",
    val portrait: String = "",
    val small: String = "",
    val tiny: String = ""
)