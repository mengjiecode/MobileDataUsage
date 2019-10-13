package com.mengjie.mobiledatausage.service

import com.mengjie.mobiledatausage.data.MobileData
import retrofit2.http.GET

interface MobileDataApi {
    @GET("datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f&limit=60")
    suspend fun getMobileData(): MobileData
}