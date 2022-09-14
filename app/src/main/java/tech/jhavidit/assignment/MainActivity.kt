package tech.jhavidit.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import tech.jhavidit.assignment.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = GridAdapter()

        binding.generateButton.setOnClickListener {
            binding.recyclerView.layoutManager = GridLayoutManager(this,binding.number.text.toString().toInt())
            binding.recyclerView.adapter = adapter;
            adapter.setGridSize(createList(binding.number.text.toString().toInt()))
        }

    }


}