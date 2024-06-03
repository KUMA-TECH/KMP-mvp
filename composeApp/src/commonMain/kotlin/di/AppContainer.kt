package di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

object AppContainer {
    private val factory: Factory by lazy { Factory() }

    val dataRepository: DataRepository by lazy {
        DataRepository(
            api = factory.createApi(),
            cartDataStore = factory.createUserDataStore(),
            scope = CoroutineScope(Dispatchers.Default + SupervisorJob()),
        )
    }
}
