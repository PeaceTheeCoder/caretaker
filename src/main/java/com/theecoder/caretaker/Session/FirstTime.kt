package com.theecoder.anonymus.Session

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.theecoder.caretaker.welcome1

class FirstTime {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con:Context

    var PRIVATEMODE : Int = 0

    constructor(con : Context)
    {
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME, PRIVATEMODE)
        editor = pref.edit()

    }
    companion object{
        val PREF_NAME = "Login_Preference"
        val IS_LOGIN = "isLoggedin"
    }

    fun createUserSession()
    {
        editor.putBoolean(IS_LOGIN, false)
        editor.commit()
    }
    fun checkLogin(): Boolean{
        if(this.isNewuser())
        {
            return true
        }
        return false
    }

    fun isNewuser(): Boolean
    {
        return pref.getBoolean(IS_LOGIN, true)
    }
}