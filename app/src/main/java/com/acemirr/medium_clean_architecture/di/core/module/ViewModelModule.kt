package com.acemirr.medium_clean_architecture.di.core.module

import androidx.lifecycle.ViewModel
import com.acemirr.medium_clean_architecture.di.key.ViewModelKey
import com.acemirr.medium_clean_architecture.presenter.list.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Module
    abstract inner class MainActivity {
        @Binds
        @IntoMap
        @ViewModelKey(MainActivityViewModel::class)
        abstract fun bindMainActivityViewModel(vm: MainActivityViewModel): ViewModel
    }

}