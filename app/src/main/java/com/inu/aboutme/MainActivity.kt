package com.inu.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.inu.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var binding : ActivityMainBinding

    var myName: MyName = MyName("손인수")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(binding.root)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    fun addNickname(view: View) {
        Log.d("클릭", "bv")
        binding.apply {
        //    nicknameText.text = nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}