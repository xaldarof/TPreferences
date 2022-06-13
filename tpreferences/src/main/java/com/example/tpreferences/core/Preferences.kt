package com.example.tpreferences.core

import android.content.SharedPreferences

/**
 * @Author: Temur
 * @Date: 12/06/2022
 */

interface Preferences {

    fun getString(key: String, value: String): String

    fun getInt(key: String, value: Int): Int

    fun getLong(key: String, value: Long): Long

    fun getFloat(key: String, value: Float): Float

    fun getBoolean(key: String, value: Boolean): Boolean


    interface Editor {

        fun putString(key: String, value: String)

        fun putInt(key: String, value: Int)

        fun putLong(key: String, value: Long)

        fun putFloat(key: String, value: Float)

        fun putBoolean(key: String, value: Boolean)

        fun remove(key: String)

        fun clear()

    }
}