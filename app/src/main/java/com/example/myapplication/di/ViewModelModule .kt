package com.example.myapplication.di


import com.example.myapplication.presentation.main.MainViewModel
import com.example.myapplication.presentation.news.NewsFeedViewMode
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<MainViewModel> {
        MainViewModel(get(), get())
    }
    viewModel<NewsFeedViewMode> {
        NewsFeedViewMode(get())
    }
}