package com.theecoder.caretaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.theecoder.anonymus.Session.FirstTime

class MainActivity : AppCompatActivity() {
    var QUESTION_NUMBER: Int = 0
    var questions: ArrayList<String> = ArrayList()
    lateinit var session : FirstTime
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        session = FirstTime(this)


        if(!session.isNewuser()){
            setTheme(R.style.splash_theme)
            setContentView(R.layout.activity_main)
            this.supportActionBar?.hide()

            val sheet = findViewById<FrameLayout>(R.id.sheet)
            bottom_sheet(sheet)
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.done).visibility = GONE
            questions.add("What is the emergency?")
            questions.add("age group of a patient(Child, teenager, adult or old age)?")
            questions.add("How long since the situation started?")
            questions.add("any additional information?")

            next_question(QUESTION_NUMBER)

            findViewById<ImageButton>(R.id.imageButton).setOnClickListener{
                val txt = findViewById<EditText>(R.id.editTextTextPersonName2)
                if(!txt.text.isEmpty())
                {
                    if (QUESTION_NUMBER <4) {
                        next_question(QUESTION_NUMBER)
                    }else
                    {
                        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.done).visibility = VISIBLE
                        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.qanda).visibility = GONE
                        QUESTION_NUMBER =0
                    }
                }
            }
            findViewById<ImageButton>(R.id.imageButton3).setOnClickListener{
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.done).visibility = GONE
                findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.qanda).visibility = VISIBLE
                next_question(0)
            }
            findViewById<ImageView>(R.id.imageView6).setOnClickListener{
                session.logoutUser()
                var intent: Intent = Intent(this, welcome1::class.java)
                startActivity(intent)
                finish()
            }

        }else
        {
            var intent: Intent = Intent(this, welcome1::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun bottom_sheet(sheet : FrameLayout)
    {
        BottomSheetBehavior.from(sheet).apply{
           peekHeight =300
           this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
    fun next_question(index: Int)
    {
        if (index < questions.size) {
            val q = findViewById<TextView>(R.id.textView15)
            val n = findViewById<TextView>(R.id.textView14)
            val t = findViewById<EditText>(R.id.editTextTextPersonName2)
            q.setText(questions[index])
            n.setText("${(index + 1).toString()} of 4")
            t.setText("")
            QUESTION_NUMBER += 1
        }else
        {
            QUESTION_NUMBER =0
        }
    }
}