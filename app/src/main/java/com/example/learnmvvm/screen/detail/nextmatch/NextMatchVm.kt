package com.example.learnmvvm.screen.detail.nextmatch

import androidx.lifecycle.MutableLiveData
import com.example.learnmvvm.domain.LastMatchDomain
import com.example.learnmvvm.helper.RxUtils
import com.example.learnmvvm.repository.NextMatchRepository
import com.example.learnmvvm.screen.base.BaseViewModel

sealed class NextMatchState
data class ErrorState(var msg: String?) : NextMatchState()
data class NextMatchDataLoaded(val nextMatchDomain: List<LastMatchDomain>): NextMatchState()
class NextMatchVm (val repo: NextMatchRepository) : BaseViewModel() {

    val nextMatchState = MutableLiveData<NextMatchState>()

    fun getNextMatchLeague(idLeague: String) {
        compositeDisposable.add(
            repo.getNextMatchLeague(idLeague)
                .compose(RxUtils.applySingleAsync())
                .subscribe({result ->
                    nextMatchState.value = NextMatchDataLoaded(result)
                }, this::onError)
        )
    }

    override fun onError(error: Throwable) {
        nextMatchState.value = ErrorState(error.localizedMessage)

    }

}