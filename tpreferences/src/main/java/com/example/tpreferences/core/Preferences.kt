package com.example.tpreferences.core

import android.content.SharedPreferences
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Temur
 * @Date: 12/06/2022
 */

interface Preferences {

    fun getString(key: String, value: String): Flow<String>

    fun getInt(key: String, value: Int): Flow<Int>

    fun getLong(key: String, value: Long): Flow<Long>

    fun getFloat(key: String, value: Float): Flow<Float>

    fun getBoolean(key: String, value: Boolean): Flow<Boolean>


    interface Editor {

        suspend fun putString(key: String, value: String?)

        suspend fun putInt(key: String, value: Int?)

        suspend fun putLong(key: String, value: Long?)

        suspend fun putFloat(key: String, value: Float?)

        suspend fun putBoolean(key: String, value: Boolean?)

        suspend fun clear(): Boolean

    }
}