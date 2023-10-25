package com.example.mealzeapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel : MealsViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val rv: RecyclerView =findViewById<RecyclerView>(R.id.recycleview)
        val layout=LinearLayoutManager(this)
        rv.layoutManager=layout
        viewModel.getMeals()

        val mealsAdapter=MealsAdapter()
        lifecycleScope.launch {
            viewModel.categories.collect{
                mealsAdapter.submitList(it?.categories)
                rv.adapter=mealsAdapter
            }
        }
    }
}