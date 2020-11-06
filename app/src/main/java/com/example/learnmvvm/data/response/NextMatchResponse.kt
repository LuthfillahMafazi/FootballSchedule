package com.example.learnmvvm.data.response

import com.example.learnmvvm.data.model.LastMatchModel

data class NextMatchResponse(
    val events: List<LastMatchModel>
)