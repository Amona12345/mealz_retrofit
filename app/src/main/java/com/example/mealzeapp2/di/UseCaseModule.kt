package com.example.mealzeapp2.di

import com.example.domain.repo.MealsRepo
import com.example.domain.useCase.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideUseCase(mealsRepo: MealsRepo): GetMeals {
        return GetMeals(mealsRepo)
    }
}