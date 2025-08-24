package pcg.curso.chatfirebase.domain

import kotlinx.coroutines.flow.Flow

interface DatabaseService {

    suspend fun saveUserName(nickName: String)
    suspend fun clear()
    fun getUserName():Flow<String>

}