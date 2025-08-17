package pcg.curso.chatfirebase.domain

import pcg.curso.chatfirebase.data.network.FirebaseChatService
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {

    operator fun invoke() = firebaseChatService.getMessages()

}