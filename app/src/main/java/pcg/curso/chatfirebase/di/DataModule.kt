package pcg.curso.chatfirebase.di

import android.content.Context
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pcg.curso.chatfirebase.data.database.DatabaseServiceImpl
import pcg.curso.chatfirebase.data.network.FirebaseChatService
import pcg.curso.chatfirebase.domain.DatabaseService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideDatabaseReference() = Firebase.database.reference


    @Singleton
    @Provides
    fun provideFirebaseService(reference: DatabaseReference) = FirebaseChatService(reference)

    @Singleton
    @Provides
    fun provideDatastoreService(@ApplicationContext context: Context) : DatabaseService{
        return DatabaseServiceImpl(context)
    }


}