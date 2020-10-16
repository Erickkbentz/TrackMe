package com.workoutlog.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R
import com.workoutlog.ui.routine.CreateRoutineActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createRoutineButton = findViewById<Button>(R.id.createRoutineButton) as Button
        createRoutineButton.setOnClickListener {
            val intent = Intent(this, CreateRoutineActivity::class.java)
            startActivity(intent)
        }
    }


}