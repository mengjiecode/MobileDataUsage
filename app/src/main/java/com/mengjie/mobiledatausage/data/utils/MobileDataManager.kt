package com.mengjie.mobiledatausage.data.utils

import com.mengjie.mobiledatausage.data.model.MobileData
import com.mengjie.mobiledatausage.data.model.Record

object MobileDataManager {

    fun filterRecords(response: MobileData): List<Record> {
        return response.result.records.filter {
            it.quarter.substring(0, 4).toInt() >= 2008
        }.filter {
            it.quarter.substring(0, 4).toInt() <= 2018
        }
    }

    fun getTotalData(list: List<Record>) : Double {
        var total = 0.0
        list.forEach { recordItem ->
            total += recordItem.volumeOfMobileData.toDouble()
        }
        return total
    }

    fun isDecrease(list: List<Record>) : Boolean {
        var previousData = 0.0
        var isDecrease = false
        list.forEach { recordItem ->
            if (recordItem.volumeOfMobileData.toDouble() < previousData) {
                isDecrease = true
            }
            previousData = recordItem.volumeOfMobileData.toDouble()
        }
        return isDecrease
    }
}