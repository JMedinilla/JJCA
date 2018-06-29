package ncatz.jvmed.jjca.utils

import android.content.Context

class Preferences {
    companion object {
        val BOOKS_MODE = "SHARED_PREFERENCES_BOOKS_MODE"
        val sharedName = "PreferencesName"

        fun getBooksMode(context: Context): Boolean {
            val prefs = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)
            return prefs.getBoolean(BOOKS_MODE, false)
        }

        fun setBooksMode(context: Context, value: Boolean) {
            val prefs = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE).edit()
            prefs.putBoolean(BOOKS_MODE, value)
            prefs.apply()
        }
    }
}