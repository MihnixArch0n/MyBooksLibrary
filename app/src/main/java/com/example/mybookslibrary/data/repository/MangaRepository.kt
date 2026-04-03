package com.example.mybookslibrary.data.repository

import com.example.mybookslibrary.data.remote.MangaDexApi
import com.example.mybookslibrary.data.remote.models.toDomainModel
import com.example.mybookslibrary.domain.model.MangaModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MangaRepository(
    private val api: MangaDexApi
) {
    fun getDiscoverManga(limit: Int = 20, offset: Int = 0): Flow<Result<List<MangaModel>>> = flow {
        val result = runCatching {
            api.getMangaList(
                limit = limit,
                offset = offset,
                includes = listOf("cover_art")
            ).data.map { it.toDomainModel() }
        }
        emit(result)
    }
}

