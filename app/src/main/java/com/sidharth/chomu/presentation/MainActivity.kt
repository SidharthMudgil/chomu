package com.sidharth.chomu.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sidharth.chomu.R
import com.sidharth.chomu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val activityMainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)
    }
}