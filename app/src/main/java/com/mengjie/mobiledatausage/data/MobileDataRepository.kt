package com.mengjie.mobiledatausage.data

import com.mengjie.mobiledatausage.service.MobileDataApi

class MobileDataRepository(private val api: MobileDataApi) {
    suspend fun getData(): MutableList<MobileDataItem>? {
        val movieResponse = api.getMobileData()

        val hashMap: HashMap<String, MutableList<Record>> = hashMapOf()

        // Filter out the correct years
        val filteredRecords = movieResponse.result.records.filter {
            it.quarter.substring(0, 4).toInt() >= 2008
        }.filter {
            it.quarter.substring(0, 4).toInt() <= 2018
        }

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

        val mobileDataList = mutableListOf<MobileDataItem>()

        // Convert to display item
        hashMap.forEach {
            var total = 0.0
            var maxVolumeOfMobileData = 0.0
            var isDecrease = false
            it.value.forEach { recordItem ->
                total += recordItem.volumeOfMobileData.toDouble()
                if (recordItem.volumeOfMobileData.toDouble() < maxVolumeOfMobileData) {
                    isDecrease = true
                }
                maxVolumeOfMobileData = recordItem.volumeOfMobileData.toDouble()
            }
            mobileDataList.add(MobileDataItem(it.key, total.toString(), isDecrease, it.value))
        }

        // Sort the year accordingly
        mobileDataList.sortBy {
            it.year
        }

        return mobileDataList.toMutableList()
    }
}