package com.acemirr.medium_clean_architecture.di.core.module

import androidx.lifecycle.ViewModelProvider
import com.acemirr.medium_clean_architecture.presenter.base.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class DaggerViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}