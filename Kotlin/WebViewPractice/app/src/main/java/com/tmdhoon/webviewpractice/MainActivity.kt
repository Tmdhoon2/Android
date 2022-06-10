package com.tmdhoon.webviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.wv)                     // webview 연결 
        myWebView.loadUrl("https://www.google.co.kr/")                 // url 불러오기 
        myWebView.webViewClient = WebViewClient()                          // 앱안에서만 WebView가 실행되게 만드는 코드 (WebViewClient 사용)
    }
}