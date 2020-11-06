package com.example.learnmvvm.screen.detail.search

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.learnmvvm.domain.SearchDomain
import com.example.learnmvvm.helper.RxUtils
import com.example.learnmvvm.repository.SearchRepository
import com.example.learnmvvm.screen.base.BaseViewModel

sealed class SearchMatchState
data class ErrorState(val msg: String?) : SearchMatchState()
data class SearchDataLoaded(val searchDomain: List<SearchDomain>) : SearchMatchState()
class SearchMatchVm (val repo : SearchRepository) : BaseViewModel() {

    val searchState = MutableLiveData<SearchMatchState>()

    fun searchEvent(event : String) {
        compositeDisposable.add(
            repo.getSearchMatch(event)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    searchState.value = SearchDataLoaded(result)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        searchState.value = ErrorState(error.localizedMessage)
    }

}