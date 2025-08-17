package pcg.curso.chatfirebase.data.network.response

import pcg.curso.chatfirebase.domain.model.MessageModel
import pcg.curso.chatfirebase.domain.model.UserModel

data class MessageResponse(
    val msg: String? = null,
    val hour: String? = null,
    val date: String? = null,
    val user: UserResponse? = null
) {
    fun toDomain():MessageModel {
        return MessageModel(
            msg = msg.orEmpty(),
            hour = hour ?: "no hour",
            date = date.orEmpty(),
            user = UserModel(
                userName = user?.userName ?: "Guest",
                admin = user?.admin ?: false
            )
        )
    }
}

data class UserResponse(
    val userName: String? = null,
    val admin: Boolean? = null
)
