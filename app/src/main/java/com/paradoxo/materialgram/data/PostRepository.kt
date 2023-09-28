package com.paradoxo.materialgram.data

import com.paradoxo.materialgram.domain.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface PostRepository {
    suspend fun getPosts(): Flow<List<Post>>
}

class PostRepositoryImpl @Inject constructor(
    private val postLocalDataSource: PostLocalDataSource
) : PostRepository {
    override suspend fun getPosts(): Flow<List<Post>> {
        return flowOf(postLocalDataSource.posts)
    }
}