package com.acemirr.medium_clean_architecture.di.core.module

import android.app.Application
import com.acemirr.medium_clean_architecture.CleanApplication
import com.acemirr.medium_clean_architecture.presenter.detail.view.DetailActivity
import com.acemirr.medium_clean_architecture.presenter.list.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule


@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule.MainActivity::class])
     fun mainActivityInjectior():MainActivity


    @Binds
     fun bindApplication(app:CleanApplication):Application
}