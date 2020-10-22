package com.workoutlog.ui.routine

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.workoutlog.R
import com.workoutlog.data.Routine
import com.workoutlog.data.RoutineType
import kotlinx.android.synthetic.main.edit_list_view.*

class CreateRoutineActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_routine_view)

        val routineNameEditText = findViewById<EditText>(R.id.routineNameEditText)
        routineNameEditText.postDelayed({
            routineNameEditText.requestFocus()
            val inputMethodManage = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManage.showSoftInput(routineNameEditText, InputMethodManager.SHOW_IMPLICIT)
        }, 100)

        routineNameEditText.onDone{routineNameEditText.clearFocus()}

        val pplButton = findViewById<Button>(R.id.pplButton)
        pplButton.setOnClickListener {
            CreateRoutineButtonOnClickListener(RoutineType.PPL, routineNameEditText, this)
                .onClick(it)
        }

        val upperLowerButton = findViewById<Button>(R.id.upperLowerButton)
        upperLowerButton.setOnClickListener {
           CreateRoutineButtonOnClickListener(RoutineType.UPPER_LOWER, routineNameEditText, this)
               .onClick(it)
        }

        val fullBodyButton = findViewById<Button>(R.id.fullBodyButton)
        fullBodyButton.setOnClickListener {
            CreateRoutineButtonOnClickListener(RoutineType.FULL_BODY, routineNameEditText, this)
                .onClick(it)
        }
    }

    private fun EditText.onDone(callback: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                callback.invoke()
                true
            }
            false
        }
    }

    private class CreateRoutineButtonOnClickListener(val routineType: RoutineType,
                                                     val routineNameEditText: EditText,
                                                     val context: Context,) : View.OnClickListener {
        override fun onClick(v: View?) {
            val routineName = routineNameEditText.text.toString()
            if (routineName.isNotEmpty() && routineName.isNotBlank()) {
                val intent = Intent(context, EditRoutineActivity::class.java)

                val b = Bundle()
                b.putString("routineName", routineName)
                b.putInt("routineTypeOrdinal", routineType.ordinal)
                intent.putExtras(b)

                context.startActivity(intent)
            }
        }
    }

}
