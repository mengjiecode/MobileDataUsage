package com.mengjie.mobiledatausage

import androidx.multidex.MultiDexApplication
import com.mengjie.mobiledatausage.ui.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        setup()
    }

    private fun setup() {
        if (GlobalContext.getOrNull() == null) {
            val viewModelModule = module {
                viewModel {
                    MainViewModel(get())
                }
            }

            startKoin {
                androidContext(this@App)
                modules(viewModelModule)
            }
        }
    }
}