package com.acemirr.medium_clean_architecture.di.core.module

import com.acemirr.medium_clean_architecture.data.datasource.list.ListDataSource
import com.acemirr.medium_clean_architecture.data.datasource.list.ListLocalDataSource
import com.acemirr.medium_clean_architecture.data.datasource.list.ListRemoteDataSource
import com.acemirr.medium_clean_architecture.data.repository.ListRepositoryImpl
import com.acemirr.medium_clean_architecture.data.source.local.dao.ListDao
import com.acemirr.medium_clean_architecture.data.source.network.ApiServiceImpl
import com.acemirr.medium_clean_architecture.domain.repository.ListRepository
import com.acemirr.medium_clean_architecture.domain.usecase.ListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApiServiceImpl(): ApiServiceImpl {
        return ApiServiceImpl()
    }

    @Provides
    @Singleton
    fun provideListRepository(remote: ListDataSource.Remote, local: ListDataSource.Local): ListRepository {
        return ListRepositoryImpl(local, remote)
    }

    @Provides
    @Singleton
    fun provideListLocalDataSource(dao: ListDao): ListDataSource.Local {
        return ListLocalDataSource(dao)
    }

    @Provides
    @Singleton
    fun provideListRemoteDataSource(api: ApiServiceImpl): ListDataSource.Remote {
        return ListRemoteDataSource(api)
    }

    @Provides
    fun provideGetListUseCase(repository: ListRepository): ListUseCase {
        return ListUseCase(repository)
    }
}