# TPreferences

Open source project and library for saving key value data for android base
on [Google DataStore](https://github.com/googlecodelabs/android-datastore).

```
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