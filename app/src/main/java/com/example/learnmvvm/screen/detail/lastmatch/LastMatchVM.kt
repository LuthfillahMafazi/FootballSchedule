package com.example.learnmvvm.screen.detail.lastmatch

import androidx.lifecycle.MutableLiveData
import com.example.learnmvvm.domain.LastMatchDomain
import com.example.learnmvvm.helper.RxUtils
import com.example.learnmvvm.repository.LastMatchRepository
import com.example.learnmvvm.screen.base.BaseViewModel

sealed class LastMatchState
data class ErrorState(var msg: String?): LastMatchState()
data class LastMatchDataLoaded(val lastMatchDomain: List<LastMatchDomain>): LastMatchState()
class LastMatchVM (val repo: LastMatchRepository): BaseViewModel() {

    val lastMatchState = MutableLiveData<LastMatchState>()

    fun getLastMatchLeague(idLeague: String) {
        compositeDisposable.add(
            repo.getLastMatchLeague(idLeague)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    lastMatchState.value = LastMatchDataLoaded(result)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        lastMatchState.value = ErrorState(error.localizedMessage)
    }

}