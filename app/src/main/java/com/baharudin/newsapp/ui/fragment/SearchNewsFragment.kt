package com.baharudin.newsapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.baharudin.newsapp.R
import com.baharudin.newsapp.ui.NewsActivity
import com.baharudin.newsapp.ui.NewsViewModel

class SearchNewsFragment : Fragment (R.layout.fragment_search_news) {

    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as NewsActivity).viewModel
    }
}