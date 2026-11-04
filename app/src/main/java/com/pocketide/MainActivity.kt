package com.pocketide

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.*
import android.graphics.Color

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(12, 12, 12, 12)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = "Pocket IDE Internet Test"
            textSize = 20f
            setTextColor(Color.BLACK)
        }

        val status = TextView(this).apply {
            text = "Ready to test"
            textSize = 14f
            setTextColor(Color.DKGRAY)
        }

        val button = Button(this).apply {
            text = "Test Google"
        }

        val web = WebView(this).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }

        button.setOnClickListener {
            status.text = "Loading Google..."
            web.loadUrl("https://www.google.com")
        }

        web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {
                status.text = "Page loaded: $url"
            }

            override fun onReceivedError(
                view: WebView?,
                request: android.webkit.WebResourceRequest?,
                error: android.webkit.WebResourceError?
            ) {
                status.text = "Internet test failed"
            }
        }

        layout.addView(title)
        layout.addView(status)
        layout.addView(button)
        layout.addView(
            web,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        setContentView(layout)
    }
}
