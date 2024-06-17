package data.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import model.User
import kotlin.coroutines.cancellation.CancellationException

interface UserApi {
    suspend fun getUserBy(userName: String): User
}

class UserNetworkApi(private val client: HttpClient, private val apiUrl: String) : UserApi {

    override suspend fun getUserBy(userName: String): User {
        val url = apiUrl + "api/$userName"
        return try {
//            client.get(url).body()
            client.post(url) {

            }.body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            User.empty()
        }
    }
}
