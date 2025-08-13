package pcg.curso.chatfirebase.ui.chat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pcg.curso.chatfirebase.domain.SendMessageUseCase
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val sendMessageUseCase: SendMessageUseCase) :
    ViewModel() {

    fun sendMessage() {
        val msg = "Hola hola"
        sendMessageUseCase(msg)
    }

}