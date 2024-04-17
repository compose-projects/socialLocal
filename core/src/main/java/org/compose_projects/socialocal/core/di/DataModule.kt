package org.compose_projects.socialocal.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.compose_projects.socialocal.core.data.repository.NetworkRepository
import org.compose_projects.socialocal.core.data.repository.NetworkRepositoryImp
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun providesNetworkRepository(): NetworkRepository =
        NetworkRepositoryImp()
}