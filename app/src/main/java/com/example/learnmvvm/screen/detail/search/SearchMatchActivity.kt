package com.example.learnmvvm.screen.detail.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnmvvm.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.activity_search_match.*
import org.koin.android.ext.android.inject

class SearchMatchActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private val vm: SearchMatchVm by inject()

    private val adapterSearch = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_match)

        vm.searchState.observe(this, startObserver)

        setUpRecycle()
        searchText.setOnQueryTextListener(this)

    }

    private fun setUpRecycle() {
        rvSearch.apply {
            layoutManager = LinearLayoutManager(this@SearchMatchActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterSearch
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText?.isNotEmpty()!!) {
            adapterSearch.clear()
            val search = newText.toLowerCase()
            vm.searchEvent(search)
            adapterSearch.notifyDataSetChanged()
        } else {

        }
        return true
    }

    private val startObserver = Observer<SearchMatchState>{ onstate ->
        when(onstate) {
            is SearchDataLoaded -> {
                adapterSearch.clear()
                onstate.searchDomain.map {
                    adapterSearch.add(SearchAdapter(it))
                }
            }
            is ErrorState -> {

            }
        }
    }

}
