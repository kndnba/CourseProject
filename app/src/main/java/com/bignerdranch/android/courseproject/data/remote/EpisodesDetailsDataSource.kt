package com.bignerdranch.android.courseproject.data.remote

import javax.inject.Inject

class EpisodesDetailsDataSource @Inject constructor(
    private val episodesService: ApiService
): BaseDataSource() {
    suspend fun getMultipleCharacters(ids: List<Int>) = getResult { episodesService.getMultipleCharacters(ids) }
}