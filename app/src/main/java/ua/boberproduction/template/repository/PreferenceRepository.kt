package ua.boberproduction.template.repository

import android.app.Application
import androidx.preference.PreferenceManager

/**
 * Locally stored application preferences.
 */
interface PreferenceRepository {
}

class AppPreferenceRepository(
    app: Application
) : PreferenceRepository {
    private val prefs = PreferenceManager.getDefaultSharedPreferences(app)

    companion object {
    }
}