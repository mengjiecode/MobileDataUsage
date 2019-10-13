package com.mengjie.mobiledatausage.domain

import com.mengjie.mobiledatausage.data.Record
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.koin.test.KoinTest

class MobileDataManagerTest : KoinTest {

    @Test
    fun getTotalData() {
        val list = listOf(
            Record("1.00001", "2018-Q1", 55),
            Record("1.00010", "2018-Q2", 56),
            Record("1.00100", "2018-Q3", 57),
            Record("1.01000", "2018-Q3", 58)
        )
        val totalData = MobileDataManager.getTotalData(list)
        assertEquals(totalData, 4.01111)
    }

    @Test
    fun isDecrease() {
        val list = listOf(
            Record("1.10000", "2018-Q1", 55),
            Record("1.00010", "2018-Q2", 56),
            Record("1.00100", "2018-Q3", 57),
            Record("1.01000", "2018-Q3", 58)
        )
        val isDecrease = MobileDataManager.isDecrease(list)
        assertEquals(isDecrease, true)
    }
}