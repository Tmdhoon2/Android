package com.tmdhoon.webviewpractice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.wv)                     // webview 연결
        myWebView.settings.javaScriptEnabled = true
        myWebView.addJavascriptInterface(WebAppInterface(this), "Android")


        myWebView.loadUrl("https://mine.page/")                        // url 불러오기
        myWebView.webViewClient = WebViewClient()                          // 앱안에서만 WebView가 실행되게 만드는 코드 (WebViewClient 사용)
    }

    class WebAppInterface(private val mContext: Context){
        @JavascriptInterface
        fun showToast(toast: String){
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
        }
    }
}

