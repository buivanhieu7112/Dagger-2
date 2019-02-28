package com.example.dagger2.utils.di.component

import android.app.Application
import com.example.dagger2.MyApplication
import com.example.dagger2.utils.di.module.ActivityBuildersModule
import com.example.dagger2.utils.di.module.AppModule
import com.example.dagger2.utils.di.module.NetWorkModule
import com.example.dagger2.utils.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        NetWorkModule::class,
        ViewModelModule::class]
)
interface AppComponent : AndroidInjector<MyApplication> {  // cầu nối cung cấp module cho application
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
