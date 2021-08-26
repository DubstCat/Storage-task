package com.example.storagetask

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.storagetask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

private lateinit var binding:ActivityMainBinding
private lateinit var manager: RecyclerView.LayoutManager
private lateinit var mItemViewModel:ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manager = LinearLayoutManager(this)

        refreshList()

        binding.fbAdd.apply {
            setOnClickListener {
                val intent = Intent(context, AddItemActivity::class.java)
                startActivity(intent)
            }
            setOnLongClickListener{
                mItemViewModel.nukeTable()
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_item -> {
                Toast.makeText(this, "Item selected", Toast.LENGTH_LONG).show()
                //TODO("IMPLEMENT FILTER INTENT")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun refreshList(){
        val recyclerView = binding.rvItems
        recyclerView.layoutManager = LinearLayoutManager(this)
        mItemViewModel.readAllData.observe(this, Observer {
                items -> recyclerView.adapter = ItemAdapter(items)
        })
    }

    fun openFilterFragment(){

    }

}
