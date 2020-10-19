package com.workoutlog.ui.routine

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R
import com.workoutlog.data.Routine
import com.workoutlog.data.Workout

class EditRoutineActivity() :AppCompatActivity() {
    private val TAG = EditRoutineActivity::class.java.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_list_view)
        val bundle = intent.extras
        if (bundle != null) {
            val listView = findViewById<ListView>(R.id.listView)
            val editViewTextView = findViewById<TextView>(R.id.editViewTextView)
            val addItemTextView = findViewById<TextView>(R.id.addItemTextView)

            val routineName = bundle.getString("routineName")
            val routineType = bundle.getString("routineType") as String

            editViewTextView.text = routineName

            if (routineType == "PPL") {
                addItemTextView.text = getString(R.string.pplAddItemTextHint)
            }
            val routine = createStartingRoutine(routineType)
            val adapter = WorkoutListAdapter(this,
                R.layout.workout_list_item,
                routine?.workoutList as ArrayList<Workout>
            )

            listView.adapter = adapter


        }
    }


    private fun createStartingRoutine(name : String): Routine? {
        if (name == "PPL") {
            return Routine(name, arrayListOf(
                Workout("Push"),
                Workout("Pull"),
                Workout("Legs")
            ))
        }
        return null
    }

}