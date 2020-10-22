package com.workoutlog.ui.routine

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.workoutlog.R
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

    private fun EditText.onDone(callback: () -> Unit) {
        setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                callback.invoke()
                true
            }
            false
        }
    }

}