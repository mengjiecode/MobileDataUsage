package com.mengjie.mobiledatausage.repository

import com.mengjie.mobiledatausage.data.MobileDataItem
import com.mengjie.mobiledatausage.data.Record
import com.mengjie.mobiledatausage.domain.MobileDataManager
import com.mengjie.mobiledatausage.service.MobileDataApi

class MobileDataRepository(private val api: MobileDataApi) {

    suspend fun getData(): MutableList<MobileDataItem>? {
        val response = api.getMobileData()
        val mobileDataList = mutableListOf<MobileDataItem>()
        val hashMap: HashMap<String, MutableList<Record>> = hashMapOf()

        // Filter out the correct years
         val filteredRecords = MobileDataManager.filterRecords(response)

        // A hash map of year with their quarters
        filteredRecords.forEach {
            val year = it.quarter.substring(0, 4)
            if (hashMap.containsKey(year)) {
                val quarterRecords = hashMap[year]
                quarterRecords?.add(it)
                hashMap[year] = quarterRecords!!
            } else {
                hashMap[year] = mutableListOf(it)
            }
        }

        // Convert to display item
        hashMap.forEach {
            mobileDataList.add(
                MobileDataItem(
                    it.key,
                    MobileDataManager.getTotalData(it.value).toString(),
                    MobileDataManager.isDecrease(it.value),
                    it.value
                )
            )
        }

        // Sort the year accordingly
        mobileDataList.sortBy {
            it.year
        }

        return mobileDataList.toMutableList()
    }
}