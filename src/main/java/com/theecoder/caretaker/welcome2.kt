package com.theecoder.caretaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.theecoder.anonymus.Session.FirstTime

class welcome2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome2)
        this.supportActionBar?.hide()

        findViewById<Button>(R.id.button22).setOnClickListener{
            var intent: Intent = Intent(this, welcome3::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            var i: Intent = Intent(applicationContext, welcome3::class.java)
            startActivity(i)
            finish()
        }
    }
}