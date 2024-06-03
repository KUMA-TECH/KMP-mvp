package di

import api.AppApi
import kotlinx.coroutines.CoroutineScope
import store.UserDataStore

class DataRepository(
    private val api: AppApi,
    private val cartDataStore: UserDataStore,
    private val scope: CoroutineScope,
) {
//    val cartDetails: Flow<CartDetails>
//        get() = cartDataStore.cart.mapLatest {
//            val ids = it.items.map { it.id }
//            val fruitties = database.userDao().loadMapped(ids)
//            CartDetails(
//                items = it.items.mapNotNull {
//                    fruitties[it.id]?.let { fruittie ->
//                        CartItemDetails(fruittie, it.count)
//                    }
//                },
//            )
//        }

//    suspend fun addToCart(fruittie: User) {
//        cartDataStore.add(fruittie)
//    }
//
//    fun getUser(): Flow<User> {
//        return cartDataStore.user
//    }
//
//    fun getData(): Flow<List<User>> {
//        scope.launch {
//            if (database.userDao().count() < 1) {
//                refreshData()
//            }
//        }
//        return loadData()
//    }
//
//    fun loadData(): Flow<List<User>> {
//        return database.fruittieDao().getAllAsFlow()
//    }
//
//    suspend fun refreshData(){
//        val response = api.getData()
//        database.fruittieDao().insert(response.feed)
//    }

}

