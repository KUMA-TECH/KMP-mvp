package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import model.ListResponse
import model.User
import kotlin.coroutines.cancellation.CancellationException

interface AppApi {
    suspend fun getData(pageNumber: Int = 0): ListResponse<User>
}

class AppNetworkApi(private val client: HttpClient, private val apiUrl: String) : AppApi {

    override suspend fun getData(pageNumber: Int): ListResponse<User> {
        val url = apiUrl + "api/$pageNumber"
        return try {
            client.get(url).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            ListResponse(emptyList(), 0, 0)
        }
    }
}
