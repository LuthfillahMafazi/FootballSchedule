package com.example.learnmvvm.di

import com.example.learnmvvm.BuildConfig
import com.example.learnmvvm.data.mapper.*
import com.example.learnmvvm.data.service.GlobalInterceptor
import com.example.learnmvvm.data.service.GlobalService
import com.example.learnmvvm.repository.*
import com.example.learnmvvm.screen.detail.DetailVM
import com.example.learnmvvm.screen.detail.detailmatch.DetailMatchVM
import com.example.learnmvvm.screen.detail.lastmatch.LastMatchVM
import com.example.learnmvvm.screen.detail.nextmatch.NextMatchVm
import com.example.learnmvvm.screen.detail.search.SearchMatchVm
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



val appModule = module {

    single { GlobalInterceptor() }
    single { createOkHttpClient(get()) }
    single { createWebService<GlobalService>(get(), BuildConfig.URL_API) }

}

val dataModule = module {

    //repository
    single { FootballDetailRepositoryImpl(get(),get()) as FootballDetailRepository }
    single { LastMatchRepositoryImpl(get(), get()) as LastMatchRepository }
    single { NextMatchRepositoryImpl(get(), get()) as NextMatchRepository }
    single { DetailMatchRepositoryImpl(get(), get(), get()) as DetailMatchRepository }
    single { SearchRepositoryImpl(get(), get()) as SearchRepository }

    //mapper
    single { FootballDetailMapper() }
    single { LastMatchMapper() }
    single { TeamMapper() }
    single { DetailMatchMapper() }
    single { SearchMapper() }

    //viewmodel
    viewModel { DetailVM(get()) }
    viewModel { LastMatchVM(get()) }
    viewModel { NextMatchVm(get()) }
    viewModel { DetailMatchVM(get()) }
    viewModel { SearchMatchVm(get()) }
}

fun createOkHttpClient(interceptor: GlobalInterceptor): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val timeout = 60L
    return OkHttpClient.Builder()
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(interceptor)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val gson = GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create()
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}

val myAppModule = listOf(appModule, dataModule)
