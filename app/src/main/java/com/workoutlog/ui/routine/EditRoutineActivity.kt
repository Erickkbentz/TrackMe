package com.workoutlog.ui.routine

import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R
import com.workoutlog.data.Routine
import com.workoutlog.data.RoutineType
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
            val ordinal = bundle.getInt("routineTypeOrdinal")
            val routineType = RoutineType.values()[ordinal]

            editViewTextView.text = routineName
            when (routineType) {
                RoutineType.PPL -> {
                    addItemTextView.text = getString(R.string.pplAddItemTextHint)
                }
                RoutineType.UPPER_LOWER -> {
                    addItemTextView.text = getString(R.string.upperLowerItemTextHint)
                }
                RoutineType.FULL_BODY -> {
                    addItemTextView.text = getString(R.string.fullBodyItemTextHint)
                }
            }

            val routine = Routine(routineName!!, routineType)
            val adapter = WorkoutListAdapter(this,
                R.layout.workout_list_item,
                routine.workoutList
            )

            listView.adapter = adapter
        }
    }

}