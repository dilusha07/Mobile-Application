package com.dilusha.mobileapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickButton = findViewById<Button>(R.id.click_button)
        clickButton.setOnClickListener{
            val forActivity2Screen = Intent(this, MainActivity2::class.java)
            startActivity(forActivity2Screen)
        }
    }
}