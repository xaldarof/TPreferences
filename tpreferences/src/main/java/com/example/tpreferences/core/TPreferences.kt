package com.example.tpreferences.core

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type


/**
 * @Author: Temur
 * @Date: 12/06/2022
 */

class TPreferences(private val context: Context) : Preferences, Preferences.Editor {

    override fun getString(key: String, value: String): String {
        return get(key, value)
    }

    override fun getInt(key: String, value: Int): Int {
        return get(key, value)
    }

    override fun getLong(key: String, value: Long): Long {
        return get(key, value)
    }

    override fun getFloat(key: String, value: Float): Float {
        return get(key, value)
    }

    override fun getBoolean(key: String, value: Boolean): Boolean {
        return get(key, value)
    }

    override fun putString(key: String, value: String) {
        val map = hashMapOf<String, String>()
        map[key] = value
        write(map)
    }

    override fun putInt(key: String, value: Int) {
        val map = hashMapOf<String, String>()
        map[key] = value.toString()
        write(map)
    }

    override fun putLong(key: String, value: Long) {
        val map = hashMapOf<String, String>()
        map[key] = value.toString()
        write(map)
    }

    override fun putFloat(key: String, value: Float) {
        val map = hashMapOf<String, String>()
        map[key] = value.toString()
        write(map)
    }

    override fun putBoolean(key: String, value: Boolean) {
        val map = hashMapOf<String, String>()
        map[key] = value.toString()
        write(map)
    }

    override fun remove(key: String) {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    private fun write(data: Map<String, String>) {
        val file = File(context.filesDir, "cache.txt")
        if (file.exists()) {
            val json = Gson().toJson(read())
            val type: Type = object : TypeToken<Map<String, String>>() {}.type

            val gson = GsonBuilder()
                .create()
            val empJoiningDateMap: Map<String, String> = gson.fromJson(json, type)

            empJoiningDateMap.toMutableMap().putAll(data)

            file.writeText(Gson().toJson(empJoiningDateMap))
        }

        file.writeText(Gson().toJson(data))

    }

    private fun read(): String {
        return File(context.filesDir, "cache.txt").readText()
    }

    private fun <T> get(key: String, value: T): T {
        val data = Gson().fromJson<Map<String, T>>(read(), Map::class.java)
        return data[key] ?: value
    }

}