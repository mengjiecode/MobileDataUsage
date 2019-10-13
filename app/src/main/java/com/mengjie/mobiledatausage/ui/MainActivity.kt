package com.mengjie.mobiledatausage.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mengjie.mobiledatausage.R
import com.mengjie.mobiledatausage.data.MobileDataItem
import com.mengjie.mobiledatausage.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        viewModel.liveData.observe(this, Observer {
            updateAdapter(it ?: listOf())
        })
    }

    private fun updateAdapter(list: List<MobileDataItem>) {
        recycler.adapter = RecyclerAdapter(this, list)
    }
}