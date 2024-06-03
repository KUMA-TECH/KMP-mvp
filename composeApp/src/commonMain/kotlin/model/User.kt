package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(val id: Long = 0,
    @SerialName("name")
    val name: String,
    @SerialName("full_name")
    val fullName: String,
)
