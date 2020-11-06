package com.example.learnmvvm.screen.detail.detailmatch

import androidx.lifecycle.MutableLiveData
import com.example.learnmvvm.domain.DetailMatchDomain
import com.example.learnmvvm.domain.TeamDomain
import com.example.learnmvvm.helper.RxUtils
import com.example.learnmvvm.repository.DetailMatchRepository
import com.example.learnmvvm.screen.base.BaseViewModel

sealed class DetailMatchState
data class ErrorState(val msg: String?) : DetailMatchState()
data class DetailMatchDataLoaded(val detailMatchDomain: List<DetailMatchDomain>) : DetailMatchState()
data class LogoHomeLoaded(val teamDomain: List<TeamDomain>) : DetailMatchState()
data class LogoAwayLoaded(val teamDomain: List<TeamDomain>) : DetailMatchState()
class DetailMatchVM (val repo: DetailMatchRepository): BaseViewModel() {

    val detailMatchState = MutableLiveData<DetailMatchState>()

    fun getDetailMatchLeague(idEvent: String) {
        compositeDisposable.add(
            repo.getDetailMatchLeague(idEvent)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    detailMatchState.value = DetailMatchDataLoaded(result)
                }, this::onError)
        )
    }

    fun getLogoHome(id: String) {
        compositeDisposable.add(
            repo.getLogoHome(id)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    detailMatchState.value = LogoHomeLoaded(result)
                }, this::onError)
        )
    }

    fun getLogoAway(id: String) {
        compositeDisposable.add(
            repo.getLogoAway(id)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    detailMatchState.value = LogoAwayLoaded(result)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        detailMatchState.value = ErrorState(error.localizedMessage)

    }

}