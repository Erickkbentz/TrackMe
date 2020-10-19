package com.workoutlog.ui.routine

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R

class CreateRoutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_routine_view)
        val routineNameEditText = findViewById<EditText>(R.id.routineNameEditText)


        val pplButton = findViewById<Button>(R.id.pplButton)
        pplButton.setOnClickListener {
            val routineName = routineNameEditText.text.toString()

            if (routineName.isNotEmpty() && routineName.isNotBlank()) {
                val intent = Intent(this, EditRoutineActivity()::class.java)

                val b = Bundle()
                b.putString("routineName", routineName)
                b.putString("routineType", "PPL")
                intent.putExtras(b)

                startActivity(intent)
            }
        }
    }

}