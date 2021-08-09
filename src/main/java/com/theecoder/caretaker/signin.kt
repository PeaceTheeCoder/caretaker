package com.theecoder.caretaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.theecoder.anonymus.Session.FirstTime

class signin : AppCompatActivity() {
    lateinit var session: FirstTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        this.supportActionBar?.hide()
        session = FirstTime(this)

        findViewById<Button>(R.id.button).setOnClickListener {
            session.createUserSession()
            var i: Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }
        findViewById<TextView>(R.id.textView).setOnClickListener {
            var i: Intent = Intent(applicationContext, welcome3::class.java)
            startActivity(i)
            finish()
        }
    }
}