package com.bignerdranch.android.courseproject.data.interactor

import com.bignerdranch.android.courseproject.data.local.EpisodesDetailsDao
import com.bignerdranch.android.courseproject.data.remote.EpisodesDetailsDataSource
import com.bignerdranch.android.courseproject.utils.performGetOperation
import javax.inject.Inject

class EpisodesDetailInteractor @Inject constructor(
    private val remoteDataSource: EpisodesDetailsDataSource,
    private val localDataSource: EpisodesDetailsDao
)
{
    fun getMultipleCharacters(ids: List<Int>) = performGetOperation(
        databaseQuery = { localDataSource.getMultipleCharacters(ids) },
        networkCall = { remoteDataSource.getMultipleCharacters(ids) },
        saveCallResult = { localDataSource.insertAll(it.results) }
    )
}