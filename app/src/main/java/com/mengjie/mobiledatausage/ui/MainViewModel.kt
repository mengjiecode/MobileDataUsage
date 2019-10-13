package com.mengjie.mobiledatausage.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.mengjie.mobiledatausage.data.MobileDataRepository
import com.mengjie.mobiledatausage.service.RetrofitService
import kotlinx.coroutines.Dispatchers

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val repo: MobileDataRepository = MobileDataRepository(RetrofitService.mobileDataApi)
    val liveData = liveData(Dispatchers.IO) {
        val data = repo.getData()
        emit(data)
    }

}