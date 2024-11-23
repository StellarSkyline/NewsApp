/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.components

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

@Composable
@Preview
fun LoadWebView(url:String = "",modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context -> WebView(context) },
        update = { webView -> webView.loadUrl(url) }
    )
}