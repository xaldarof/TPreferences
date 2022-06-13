package com.example.tpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tpreferences.core.TPreferences
import com.example.tpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val preferences = TPreferences(this)

            preferences.putString("name", "Temur")
            preferences.putInt("age", 17)

        }catch (e:Exception) {
            Log.d("res","ERROR ${e.message}")
        }
    }
}