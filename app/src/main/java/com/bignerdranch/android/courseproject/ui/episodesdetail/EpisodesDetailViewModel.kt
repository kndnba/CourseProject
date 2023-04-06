package com.bignerdranch.android.courseproject.ui.episodesdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.bignerdranch.android.courseproject.data.entities.Character
import com.bignerdranch.android.courseproject.data.entities.CharacterList
import com.bignerdranch.android.courseproject.data.entities.Episodes
import com.bignerdranch.android.courseproject.data.interactor.EpisodesDetailInteractor
import com.bignerdranch.android.courseproject.data.interactor.EpisodesInteractor
import com.bignerdranch.android.courseproject.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesDetailViewModel @Inject constructor(
    private val interactor: EpisodesDetailInteractor,
    private val episodesInteractor: EpisodesInteractor
) : ViewModel() {

    private val _ids = MutableLiveData<List<Int>>()
    private val _id = MutableLiveData<Int>()

    private val _episode = _id.switchMap { id ->
        episodesInteractor.getEpisode(id)
    }

    private val _characters = _ids.switchMap {
        interactor.getMultipleCharacters(it)
    }

    fun parseMultipleCharacters() {
        val characters = episode.value?.data?.characters
        val ids = arrayListOf<Int>()
        if (characters != null) {
            for (character in characters.characters) {
                val id = character.filter { it.isDigit() }
                ids.add(id.toInt())
                setIds(ids)
            }
        }
    }

    val characters: LiveData<Resource<CharacterList>> = _characters

    val episode: LiveData<Resource<Episodes>> = _episode

    fun start(id: Int) {
        _id.value = id
    }

    fun setIds(ids: List<Int>) {
        _ids.value = ids
    }
}