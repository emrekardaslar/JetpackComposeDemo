package emre.workspace.jetpackcomposedemo.managers

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import emre.workspace.jetpackcomposedemo.R

class RemoteConfigManager {

    private val remoteConfig = Firebase.remoteConfig

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 0 // Fetch instantly for testing
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        //remoteConfig.setDefaultsAsync(mapOf("background_color" to "#FFFFFF"))
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
        fetchAndActivate()
    }

    fun fetchAndActivate() {
        remoteConfig.fetchAndActivate()
    }

    fun getString(key: String): String {
        return remoteConfig.getString(key)
    }
}
