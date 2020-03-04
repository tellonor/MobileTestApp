package com.example.testapp

import android.net.http.SslError
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {
    private lateinit var myWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        WebView.setWebContentsDebuggingEnabled(true)

        myWebView = findViewById<View>(R.id.webView) as WebView

        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.loadWithOverviewMode = true
        myWebView.settings.useWideViewPort = true
        myWebView.settings.domStorageEnabled = true


        myWebView.webViewClient = object: WebViewClient() {
            override
            fun onReceivedSslError(view: WebView?, handler:SslErrorHandler?, error:SslError?){handler?.proceed()}
        }


        myWebView!!.loadUrl("https://www.google.no")
    }
}
