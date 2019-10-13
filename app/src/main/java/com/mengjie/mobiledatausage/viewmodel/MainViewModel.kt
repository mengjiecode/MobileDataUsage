package com.mengjie.mobiledatausage.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.mengjie.mobiledatausage.data.repository.MobileDataRepository
import com.mengjie.mobiledatausage.data.service.RetrofitService
import kotlinx.coroutines.Dispatchers

class MainViewModel(app: Application) : AndroidViewModel(app) {

    private val repo: MobileDataRepository = MobileDataRepository(RetrofitService.mobileDataApi)
    val liveData = liveData(Dispatchers.IO) {
        val data = repo.getData()
        emit(data)
    }

}