package com.example.mealzeapp2.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImp
import com.example.domain.repo.MealsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun privideRepo(apiServices: ApiService): MealsRepo {
        return MealsRepoImp(apiServices)
    }
}