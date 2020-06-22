package com.baharudin.newsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.baharudin.newsapp.R
import com.baharudin.newsapp.adapters.NewsAdapter
import com.baharudin.newsapp.ui.NewsActivity
import com.baharudin.newsapp.ui.NewsViewModel
import com.baharudin.newsapp.util.Resource
import kotlinx.android.synthetic.main.fragment_breakingnews.*

class BreakingNewsFragment : Fragment(R.layout.fragment_breakingnews) {
    lateinit var viewModel : NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    val TAG = "BreakingNewsFragment"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel

        setupRecycleView()

        viewModel.breakingNews.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Succes -> {
                    hideProgress()
                    response.data?.let { newsResponse ->
                        newsAdapter.differ.submitList(newsResponse.articles)
                    }
                }
                is Resource.Error -> {
                    hideProgress()
                    response.massage?.let { massage ->
                        Log.e(TAG,"An occued : $massage")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }

            }
        })
    }

    private fun hideProgress(){
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar(){
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun setupRecycleView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}