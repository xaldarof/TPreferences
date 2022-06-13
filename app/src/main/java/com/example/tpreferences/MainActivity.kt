package com.example.tpreferences

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tpreferences.core.TPreferences
import com.example.tpreferences.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val preferences = TPreferences(this)

        binding.tv.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {

                preferences.putString("username", null)
            }
        }

        try {

            CoroutineScope(Dispatchers.Main).launch {
                launch {
                    preferences.putString("username", "Temur")
                }

                launch {
                    preferences.getString("username", "Temurbek").collectLatest {
                        binding.tv.text = it
                    }
                }
            }

        } catch (e: Exception) {
            Log.d("res", "ERROR ${e.message}")
        }
    }
}