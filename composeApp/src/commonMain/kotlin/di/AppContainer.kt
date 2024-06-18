package di

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * 容器注入
 */
object AppContainer {
    private val factory: Factory by lazy { Factory() }

    val dataRepo: DataRepository by lazy {
        DataRepository(
            api = factory.createApi(),
            userStore = factory.createUserDataStore(),
            scope = CoroutineScope(Dispatchers.Default + SupervisorJob()),
        )
    }
}
