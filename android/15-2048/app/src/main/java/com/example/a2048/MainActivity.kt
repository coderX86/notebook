package com.example.a2048

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

const val URL = "https://hec9527.github.io/2048/src/"
//const val URL = "http://192.168.1.16:5500/src/index.html"
//const val URL = "http://192.168.1.16:5500/"

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView


    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//        window.statusBarColor = activity
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        webView = findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.settings.minimumFontSize = 1
        webView.settings.minimumLogicalFontSize = 1
        webView.webViewClient = MyWebClient()
        webView.webChromeClient = WebChromeClient()
        webView.loadUrl(URL)
    }
}


class MyWebClient : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        view?.loadUrl(request?.url.toString())
        return false
    }
}


