package com.yohanes.sharep_10891

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var editTextName: EditText? = null
    var editTextEmail: EditText? = null
    lateinit var textViewName: TextView
    lateinit var textViewEmail: TextView
    private val myPreference = "myPref"
    private val name = "nameKey"
    private val email = "emailKey"
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        editTextEmail = findViewById(R.id.etEmail)
        editTextName = findViewById(R.id.etName)
        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)
        if (sharedPreferences!!.contains(name)){
            editTextName?.setText(sharedPreferences!!.getString(name, ""))
        }
        if (sharedPreferences!!.contains(email)){
            editTextEmail?.setText(sharedPreferences!!.getString(email, ""))
        }

    }

    fun readData(view: View) {
        textViewEmail = findViewById(R.id.textViewEmail)
        textViewName = findViewById(R.id.textViewName)
        var strName: String = editTextName?.text.toString().trim()
        val strEmail: String = editTextEmail?.text.toString().trim()
        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)
        if (sharedPreferences!!.contains(name)){
            textViewName.text = strName
        }
        if (sharedPreferences!!.contains(email)){
            textViewEmail.text = strEmail
        }
        Toast.makeText(baseContext, "Data retrieved", Toast.LENGTH_SHORT).show()
    }

    fun saveData(view: View){
        val strName: String = editTextName?.text.toString().trim()
        val strEmail: String = editTextEmail?.text.toString().trim()
        val editor: SharedPreferences.Editor = sharedPreferences!!.edit()
            editor.putString(name, strName)
            editor.putString(email, strEmail)
            editor.apply()
            Toast.makeText(baseContext, "Saved", Toast.LENGTH_SHORT).show()
    }

    fun clearData(view: View){
        editTextName!!.text.clear()
        editTextEmail!!.text.clear()
        textViewName.text = ""
        textViewEmail.text = ""
        Toast.makeText(baseContext, "Cleared data", Toast.LENGTH_SHORT).show()
    }

}