package pcg.curso.chatfirebase.data.network

import com.google.firebase.database.DatabaseReference
import pcg.curso.chatfirebase.data.network.dto.MessageDto
import javax.inject.Inject

class FirebaseChatService @Inject constructor(private val reference: DatabaseReference) {

    companion object{
        private const val PATH = "messages"
    }

    fun sendMsgToFirebase(messageDto: MessageDto) {
        val newMsg = reference.child(PATH).push()
        newMsg.setValue(messageDto)

    }

}