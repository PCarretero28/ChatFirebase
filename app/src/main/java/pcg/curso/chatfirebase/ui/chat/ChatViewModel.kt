package pcg.curso.chatfirebase.ui.chat

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pcg.curso.chatfirebase.domain.GetMessagesUseCase
import pcg.curso.chatfirebase.domain.GetUserNameUseCase
import pcg.curso.chatfirebase.domain.SendMessageUseCase
import pcg.curso.chatfirebase.domain.model.MessageModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    private val sendMessageUseCase: SendMessageUseCase,
    private val getMessagesUseCase: GetMessagesUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    var name:String = ""

    init {
        getUserName()
        getMessages()
    }

    private fun getUserName() {
        viewModelScope.launch(Dispatchers.IO) {
            name = getUserNameUseCase()
        }
    }

    private var _messageList = MutableStateFlow<List<MessageModel>>(emptyList())
    val messageList:StateFlow<List<MessageModel>> = _messageList

    private fun getMessages() {
        viewModelScope.launch {
            getMessagesUseCase().collect {
                Log.d("Pablo prueba", "La info es $it")
                _messageList.value = it
            }
        }
    }

    fun sendMessage() {
        val msg = "Hola hola"
        sendMessageUseCase(msg)
    }

}