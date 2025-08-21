package pcg.curso.chatfirebase.data.database

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pcg.curso.chatfirebase.domain.DatabaseService
import javax.inject.Inject

class DatabaseServiceImpl @Inject constructor(private val context: Context) : DatabaseService {

    companion object{
        private val USER_NAME = stringPreferencesKey("username")
    }

    private val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore(
        name = "user"
    )

    override suspend fun saveUserName(nickname: String) {
        context.userPreferenceDataStore.edit { preferences ->
            preferences[USER_NAME] = nickname
        }
    }

    override fun getUserName(): Flow<String> =
        context.userPreferenceDataStore.data.map { preferences -> preferences[USER_NAME] ?: ""
    }

}