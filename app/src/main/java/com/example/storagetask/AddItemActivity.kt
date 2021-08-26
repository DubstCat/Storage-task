package com.example.storagetask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.storagetask.databinding.ActivityAddItemBinding

class AddItemActivity : Validate, AppCompatActivity() {
    private lateinit var binding:ActivityAddItemBinding
    private lateinit var mItemViewModel:ItemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mItemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        binding.btnAddItem.setOnClickListener{
            insertDataToDatabase()
            onBackPressed()
        }
    }

    private fun insertDataToDatabase(){
        if(validate(binding.etName.text.toString(),binding.etAge.text.toString(),binding.etBreed.text.toString())) {
            val item = Item(
                0,
                binding.etName.text.toString(),
                binding.etAge.text.toString(),
                binding.etBreed.text.toString()
            )
            mItemViewModel.addItem(item)
        }
    }

    override fun validate(vararg strings: String):Boolean {
        strings.forEach {
            if(it.isEmpty())return false
        }
        return true
    }
}