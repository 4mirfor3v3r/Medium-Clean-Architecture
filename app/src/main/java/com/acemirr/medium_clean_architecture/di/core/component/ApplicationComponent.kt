package com.acemirr.medium_clean_architecture.di.core.component

import com.acemirr.medium_clean_architecture.CleanApplication
import com.acemirr.medium_clean_architecture.di.core.module.ActivityModule
import com.acemirr.medium_clean_architecture.di.core.module.AppModule
import com.acemirr.medium_clean_architecture.di.core.module.DataModule
import com.acemirr.medium_clean_architecture.di.core.module.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        DatabaseModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: CleanApplication):Builder
        fun build(): ApplicationComponent
    }

    override fun inject(instance: DaggerApplication?)

    fun inject(application: CleanApplication)
}