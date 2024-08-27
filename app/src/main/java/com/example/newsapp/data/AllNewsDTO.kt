package com.example.newsapp.data

data class Meta(val found: Int = 0,
                val limit: Int = 0,
                val page: Int = 0,
                val returned: Int = 0)


data class DataItem(val snippet: String = "",
                    val keywords: String = "",
                    val imageUrl: String? = "",
                    val description: String = "",
                    val language: String = "",
                    val source: String = "",
                    val categories: List<String>?,
                    val title: String = "",
                    val publishedAt: String = "",
                    val uuid: String = "",
                    val url: String = "",
                    val relevanceScore: Nothing? = null)


data class AllNewsResponse(val data: List<DataItem>?,
                           val meta: Meta)


