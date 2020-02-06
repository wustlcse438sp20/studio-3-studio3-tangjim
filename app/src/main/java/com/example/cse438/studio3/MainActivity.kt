package com.example.cse438.studio3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cse438_rest_studio.Adapter.BreweryListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var breweryList: ArrayList<Brewery> = ArrayList<Brewery>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set recycler view
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = BreweryListAdapter(breweryList as ArrayList<Brewery>)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //get the ViewModel
        val viewModel = ViewModelProviders.of(this).get(BreweryViewModel::class.java)

        //TODO #10: Set up observer code for the LiveData object from the View Model

        //TODO #11: Connect the button so that it performs the search when it is clicked
        viewModel.getCategories()

        search_button.setOnClickListener {
            val input: String = search_box.text.toString()
            viewModel!!.getQuestionsBySearch(categoryList[categorySpinner.selectedItemPosition].id.toString(), input)
        }
    }
}
