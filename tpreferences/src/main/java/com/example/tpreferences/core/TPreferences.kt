package com.example.tpreferences.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


/**
 * @Author: Temur
 * @Date: 12/06/2022
 */

class TPreferences(context: Context) : Preferences, Preferences.Editor {

    companion object {
        const val PATH = "data_store"
    }

    private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore(
        PATH)

    private val cache = context.dataStore

    override fun getString(key: String, value: String): Flow<String> {
        val prefKey = stringPreferencesKey(key)

        return cache.data.map { it[prefKey] ?: value }
    }

    override fun getInt(key: String, value: Int): Flow<Int> {
        val prefKey = intPreferencesKey(key)

        return cache.data.map { it[prefKey] ?: value }
    }

    override fun getLong(key: String, value: Long): Flow<Long> {
        val prefKey = longPreferencesKey(key)

        return cache.data.map { it[prefKey] ?: value }
    }

    override fun getFloat(key: String, value: Float): Flow<Float> {
        val prefKey = floatPreferencesKey(key)

        return cache.data.map { it[prefKey] ?: value }
    }

    override fun getBoolean(key: String, value: Boolean): Flow<Boolean> {
        val prefKey = booleanPreferencesKey(key)

        return cache.data.map { it[prefKey] ?: value }
    }

    override suspend fun putString(key: String, value: String?) {
        val prefKey = stringPreferencesKey(key)

        cache.edit { data ->
            if (value != null) {
                data[prefKey] = value
            } else {
                data.remove(prefKey)
            }
        }
    }

    override suspend fun putInt(key: String, value: Int?) {
        val prefKey = intPreferencesKey(key)

        cache.edit { data ->
            if (value != null) {
                data[prefKey] = value
            } else {
                data.remove(prefKey)
            }
        }
    }

    override suspend fun putLong(key: String, value: Long?) {
        val prefKey = longPreferencesKey(key)

        cache.edit { data ->
            if (value != null) {
                data[prefKey] = value
            } else {
                data.remove(prefKey)
            }
        }
    }

    override suspend fun putFloat(key: String, value: Float?) {
        val prefKey = floatPreferencesKey(key)

        cache.edit { data ->
            if (value != null) {
                data[prefKey] = value
            } else {
                data.remove(prefKey)
            }
        }
    }

    override suspend fun putBoolean(key: String, value: Boolean?) {
        val prefKey = booleanPreferencesKey(key)

        cache.edit { data ->
            if (value != null) {
                data[prefKey] = value
            } else {
                data.remove(prefKey)
            }
        }
    }


    override suspend fun clear(): Boolean {
        return try {
            cache.edit { it.clear() }
            true
        } catch (e: Throwable) {
            false
        }
    }
}