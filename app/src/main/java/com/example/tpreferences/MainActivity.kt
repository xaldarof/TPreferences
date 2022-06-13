package com.example.tpreferences

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tpreferences.core.TPreferences
import com.example.tpreferences.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val preferences = TPreferences(this)

        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                preferences.putString("username", null)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            launch {
                preferences.putString("my_custom_key", "value")
            }

            launch {
                preferences.getString("my_custom_key", "your_default_value").collectLatest {
                    binding.button.text = it
                }
            }
        }
    }
}