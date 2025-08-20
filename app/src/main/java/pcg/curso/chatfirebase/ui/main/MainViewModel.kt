package pcg.curso.chatfirebase.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pcg.curso.chatfirebase.domain.SaveUserNameUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val saveUserName: SaveUserNameUseCase) : ViewModel() {

    fun saveNickName(nickName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            saveUserName(nickName)
        }

    }


}