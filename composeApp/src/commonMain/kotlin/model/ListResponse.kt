package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListResponse<T>(
    @SerialName("feed")
    val feed: List<T>,
    @SerialName("totalPages")
    val totalPages: Int,
    @SerialName("currentPage")
    val currentPage: Int,
)
