package ncatz.jvmed.jjca.utils

class Preferences {
    companion object {
        private const val sharedName = "PreferencesName"
        private const val BOOKS_MODE = "SHARED_PREFERENCES_BOOKS_MODE"

        /*
        fun getBooksMode(context: Context): Boolean {
            val prefs = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE)
            return prefs.getBoolean(BOOKS_MODE, false)
        }

        fun setBooksMode(context: Context, value: Boolean) {
            val prefs = context.getSharedPreferences(sharedName, Context.MODE_PRIVATE).edit()
            prefs.putBoolean(BOOKS_MODE, value)
            prefs.apply()
        }
        */
    }
}