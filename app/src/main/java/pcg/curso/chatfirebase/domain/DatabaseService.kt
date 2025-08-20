package pcg.curso.chatfirebase.domain

interface DatabaseService {

    suspend fun saveUserName(nickName: String)

}