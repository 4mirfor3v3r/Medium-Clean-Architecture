package com.acemirr.medium_clean_architecture.presenter.list.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.acemirr.medium_clean_architecture.R
import com.acemirr.medium_clean_architecture.data.model.NewsModel
import com.acemirr.medium_clean_architecture.databinding.ActivityMainBinding
import com.acemirr.medium_clean_architecture.external.Constant
import com.acemirr.medium_clean_architecture.presenter.base.BaseActivity
import com.acemirr.medium_clean_architecture.presenter.detail.view.DetailActivity
import com.acemirr.medium_clean_architecture.presenter.list.adapter.MainRvAction
import com.acemirr.medium_clean_architecture.presenter.list.adapter.MainRvAdapter
import com.acemirr.medium_clean_architecture.presenter.list.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {
    private val adapter = MainRvAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun createViewModel(): MainActivityViewModel {
        return ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    override fun createBinding(): ActivityMainBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()

    }


    private fun observeViewModel() {
        viewModel.startPaging()
        viewModel.list?.observe(this, Observer {
            Log.e("ACTIVITY RESULT", "$it")
            adapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        binding.rvMain.adapter = adapter

        adapter.setActionListener(object : MainRvAction {
            override fun onItemClick(data: NewsModel) {
                onItemClicked(data)
            }
        })
    }

    fun onItemClicked(data: NewsModel) {
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(Constant.EXTRA_DATA, data)
        startActivity(i)
    }
}
