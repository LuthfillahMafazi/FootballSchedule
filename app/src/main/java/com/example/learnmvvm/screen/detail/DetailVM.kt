package com.example.learnmvvm.screen.detail

import androidx.lifecycle.MutableLiveData
import com.example.learnmvvm.domain.FootballDetailDomain
import com.example.learnmvvm.helper.RxUtils
import com.example.learnmvvm.repository.FootballDetailRepository
import com.example.learnmvvm.screen.base.BaseViewModel

sealed class FootballDetailState
data class ErrorState(var msg: String?): FootballDetailState()
data class DetailDataLoaded(val footballDetailDomain: List<FootballDetailDomain>): FootballDetailState()
class DetailVM (val repo: FootballDetailRepository): BaseViewModel() {

    val detailState = MutableLiveData<FootballDetailState>()

    fun getDetailleague(idLeague: String) {
        compositeDisposable.add(
            repo.getDetailLeague(idLeague)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    detailState.value = DetailDataLoaded(result)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        detailState.value = ErrorState(error.localizedMessage)
    }

}
