package org.compose_projects.socialocal.common.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.compose_projects.socialocal.common.data.SocialLocalDB
import org.compose_projects.socialocal.common.data.repository.NetworkRepository
import org.compose_projects.socialocal.common.data.repository.NetworkRepositoryImp
import org.compose_projects.socialocal.common.utils.DB_CONSTANTS
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun providesNetworkRepository(): NetworkRepository =
        NetworkRepositoryImp()
}