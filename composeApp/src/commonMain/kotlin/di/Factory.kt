package di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import config.Global
import data.api.UserNetworkApi
import data.api.KtorFactory
import data.api.UserApi
import data.store.AppStore
import data.store.UserDataStore
import resolveSystemFilePath

class Factory {
    //    fun createRoomDatabase(): AppDatabase
    /**
     * create http api request
     */
    fun createApi(): UserApi {
        return UserNetworkApi(
            client = KtorFactory.create(),
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