package com.example.domain.useCase

import com.example.domain.repo.MealsRepo

class GetMeals(private val maelsRepo: MealsRepo) {
   suspend operator fun   invoke()=maelsRepo.getMealsFromRemote()
}