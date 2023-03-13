package com.example.chihome

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    lateinit var webview: WebView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview = findViewById(R.id.webview)
        webviewSetUp(webview)






    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun webviewSetUp(webView: WebView) {
        webView.webViewClient = WebViewClient()


        webView.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            settings.builtInZoomControls = true
            settings.setSupportZoom(true)
            loadUrl("https://www.childhaven.ca/")


        }


    }

    fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (url.contains("stackoverflow.com")) {
            view.loadUrl(url)
        } else {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }
        return true
    }


    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
           finish()
        }
    }
}
