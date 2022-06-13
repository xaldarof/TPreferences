package com.example.tpreferences.core

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Temur
 * @Date: 12/06/2022
 */

interface Preferences {

    fun getString(key: String, defaultValue: String): Flow<String>

    fun getInt(key: String, defaultValue: Int): Flow<Int>

    fun getLong(key: String, defaultValue: Long): Flow<Long>

    fun getFloat(key: String, defaultValue: Float): Flow<Float>

    fun getBoolean(key: String, defaultValue: Boolean): Flow<Boolean>


    interface Editor {

        suspend fun putString(key: String, value: String?)

        suspend fun putInt(key: String, value: Int?)

        suspend fun putLong(key: String, value: Long?)

        suspend fun putFloat(key: String, value: Float?)

        suspend fun putBoolean(key: String, value: Boolean?)

        suspend fun clear(): Boolean

    }
}