# TPreferences library

Open source project and library for saving key value data for android base
on [Google DataStore](https://github.com/googlecodelabs/android-datastore).

If you want to save value, you can use this sample code for understanding how it works :

```
private suspend fun saveMyValue() {
    val preferences = TPreferences(this)
    preferences.putString("my_custom_key", "value")
}

```

If you want to get value, you can use this sample code for understanding how it works :

```
private suspend fun getMyValue() {
    val preferences = TPreferences(this)
    preferences.getString(key: "my_custom_key", defailtValue: "value")
}

```

To clear all (key,values) :

```
private suspend fun clearMyValues() {
    val preferences = TPreferences(this)
    preferences.getString("").collect {
        Log.d("log","Value : $it")
    }
}

```



Detailed example
```
binding.button.setOnClickListener {
    CoroutineScope(Dispatchers.Main).launch {
        preferences.putString("my_custom_key", null)
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

```

