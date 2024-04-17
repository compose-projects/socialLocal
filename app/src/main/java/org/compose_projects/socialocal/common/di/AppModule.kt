package org.compose_projects.socialocal.common.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.compose_projects.socialocal.core.data.SocialLocalDB
import org.compose_projects.socialocal.core.utils.DB_CONSTANTS
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun providesSocialLocalDB(@ApplicationContext app: Context) =
        Room.databaseBuilder(
            app,
            SocialLocalDB::class.java,
            DB_CONSTANTS.database_name
        ).build()

    @Provides
    @Singleton
    fun providesUsersDao(usersDB: SocialLocalDB) =
        usersDB.UsersDao()

    @Provides
    @Singleton
    fun providesAccountDao(usersDB: SocialLocalDB) =
        usersDB.AccountDao()
}