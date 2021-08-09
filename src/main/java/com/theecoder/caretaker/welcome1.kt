package com.theecoder.caretaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.theecoder.anonymus.Session.FirstTime

class welcome1 : AppCompatActivity() {
    lateinit var session: FirstTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome1)
        this.supportActionBar?.hide()

        findViewById<Button>(R.id.button2).setOnClickListener{
            var intent: Intent = Intent(this, welcome2::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            session = FirstTime(this)
            session.createUserSession()
            var i: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}