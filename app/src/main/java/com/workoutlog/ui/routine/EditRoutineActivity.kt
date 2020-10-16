package com.workoutlog.ui.routine

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R

class EditRoutineActivity() :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_list_view)

        val editViewTextView = findViewById<TextView>(R.id.editViewTextView)
        val bundle = intent.extras
        if (bundle != null) {
            editViewTextView.text = bundle.getString("routineName")
        }

    }
}