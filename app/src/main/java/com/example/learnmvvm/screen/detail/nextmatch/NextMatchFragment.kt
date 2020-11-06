package com.example.learnmvvm.screen.detail.nextmatch


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.learnmvvm.R
import com.example.learnmvvm.screen.detail.lastmatch.MatchAdapter
import com.orhanobut.hawk.Hawk
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 */
class NextMatchFragment : Fragment() {

    private val vm: NextMatchVm by inject()
    private val nextMatchAdapter = GroupAdapter<ViewHolder>()

    var id = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.nextMatchState.observe(this, startObserver)

        val linearLayout = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_nextmatch.apply {
            layoutManager = linearLayout
            adapter = nextMatchAdapter
        }
        id = Hawk.get("id", "")
        vm.getNextMatchLeague(id)

    }

    private val startObserver = Observer<NextMatchState>{ onState ->
        when(onState) {
            is NextMatchDataLoaded -> {
                nextMatchAdapter.clear()
                onState.nextMatchDomain.map {
                    nextMatchAdapter.add(MatchAdapter(it))
                }
            }
            is ErrorState -> {
                Toast.makeText(context, "Failed To Load", Toast.LENGTH_LONG).show()

            }
        }
    }

    override fun onResume() {
        super.onResume()
        vm.getNextMatchLeague(id)
    }

}
