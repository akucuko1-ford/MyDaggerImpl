package com.ford.mydaggerimpl

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Qualifier

@Component(modules = [AndroidInjectionModule::class, ContributorsModule::class,
    DummyApplicationModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance myApplication: MyApplication): ApplicationComponent
    }
}

@Module
abstract class ContributorsModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}

@Module
object DummyApplicationModule {

    @Provides
    fun providesDummyModel(): Model = Model("This model created in Application Module")

    @Provides
    fun providesString(): String = "DummyApplicationModule String"
}