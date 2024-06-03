package di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import api.AppApi
import api.AppNetworkApi
import config.Global
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import resolveSystemFilePath
import store.AppStore
import store.UserDataStore

class Factory {
    //    fun createRoomDatabase(): AppDatabase
    /**
     * create http api request
     */
    fun createApi(): AppApi {
        return AppNetworkApi(
            client = HttpClient {
                install(ContentNegotiation) {
                    json(json, contentType = ContentType.Any)
                }
            },
            apiUrl = Global.API_URL,
        )
    }

    /**
     * custom data store
     */
    fun createUserDataStore(): UserDataStore {
        return UserDataStore { resolveSystemFilePath("user.json") }
    }

    /**
     * App key-value storage
     */
    fun createAppStore(): DataStore<Preferences> {
        return AppStore.get()
    }

}

val json = Json { ignoreUnknownKeys = true }
