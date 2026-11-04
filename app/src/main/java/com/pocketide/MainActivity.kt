
package com.pocketide

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebResourceRequest
import android.widget.*
import android.graphics.Color

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val layout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(8, 8, 8, 8)
                setBackgroundColor(Color.WHITE)
            }

            val title = TextView(this).apply {
                text = "Internet Test"
                textSize = 18f
                setTextColor(Color.BLACK)
            }

            val status = TextView(this).apply {
                text = "Ready"
                textSize = 13f
                setTextColor(Color.DKGRAY)
            }

            val button = Button(this).apply {
                text = "Test Google"
            }

            val web = WebView(this)

            web.settings.javaScriptEnabled = true

            web.webViewClient = object : WebViewClient() {
                override fun onPageFinished(
                    view: WebView?,
                    url: String?
                ) {
                    status.text = "Loaded successfully"
                }
            }

            button.setOnClickListener {
                status.text = "Connecting..."
                web.loadUrl("https://www.google.com")
            }

            layout.addView(title)
            layout.addView(status)
            layout.addView(button)

            layout.addView(
                web,
                LinearLayout.LayoutParams(
                    -1, 0, 1f
                )
            )

            setContentView(layout)

        } catch (e: Exception) {
            Toast.makeText(
                this,
                "Startup error: ${e.message}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
