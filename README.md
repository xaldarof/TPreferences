# TPreferences

Open source project and library for saving key value data for android base
on [Google DataStore](https://github.com/googlecodelabs/android-datastore).


If you want to save value, you use this sample code for understanding how it works :

```
private suspend fun saveMyValue() {
    val preferences = TPreferences(this)
    preferences.putString("my_custom_key", "value")
}

```