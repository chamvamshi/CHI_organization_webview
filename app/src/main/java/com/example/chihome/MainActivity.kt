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
import java.util.*

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
        webView.webViewClient = object: WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                return true
                }
              return true
            }
        }


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




    override fun onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack()
        } else {
           finish()
        }
    }



}
