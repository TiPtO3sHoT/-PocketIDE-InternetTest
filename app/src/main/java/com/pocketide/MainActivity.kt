
package com.pocketide

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.widget.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
            setBackgroundColor(Color.WHITE)
        }

        val title = TextView(this).apply {
            text = "INTERNET TEST"
            textSize = 22f
            setTextColor(Color.BLACK)
        }

        val result = TextView(this).apply {
            text = "APP STARTED SUCCESSFULLY!"
            textSize = 17f
            setTextColor(Color.GREEN)
        }

        layout.addView(title)
        layout.addView(result)

        setContentView(layout)
    }
}
