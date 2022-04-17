package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    companion object{
        const val AREA = "Titulo"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val areaId = intent?.extras?.getString(AREA).toString().uppercase()
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LibrosAdapter(areaId)
        title = "Libros cuya area es" + " " + areaId
    }
}