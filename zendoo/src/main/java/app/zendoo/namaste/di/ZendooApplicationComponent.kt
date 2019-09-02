package app.zendoo.namaste.di

import android.app.Application
import app.zendoo.namaste.ZendooApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (ZendooBuilder::class),
        (AndroidInjectionModule::class)
    ]
)
interface ZendooApplicationComponent : AndroidInjector<ZendooApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ZendooApplicationComponent
    }
}
