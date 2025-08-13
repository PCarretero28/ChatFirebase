package pcg.curso.chatfirebase.domain

import pcg.curso.chatfirebase.data.network.FirebaseChatService
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(private val firebaseChatService: FirebaseChatService) {

    operator fun invoke(msg:String){
        firebaseChatService.sendMsgToFirebase(msg)
    }

}