package com.workoutlog.ui.routine

import android.annotation.SuppressLint
import android.content.Context
import android.transition.Visibility
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.workoutlog.R
import com.workoutlog.data.Workout


class WorkoutListAdapter(context : Context,
                         @LayoutRes val resource : Int,
                         private val array : ArrayList<Workout>)
    : ArrayAdapter<Workout>(context,  resource,  array) {

    private val TAG = WorkoutListAdapter::class.java.canonicalName


    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val workoutName = getItem(position)?.name
        Log.i(TAG, "Setting TextView to:$workoutName")
        val inflater:LayoutInflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.workout_list_item, parent, false)
        val itemNameTextView = view.findViewById<TextView>(R.id.itemName)
        itemNameTextView.text = workoutName

        val itemBoxLayout = view.findViewById<ConstraintLayout>(R.id.itemBox)
        val deleteButton = view.findViewById<Button>(R.id.deleteItemButton)
        val editHintTextView = view.findViewById<TextView>(R.id.editHint)
        val editItemButton = view.findViewById<Button>(R.id.editItemButton)

        itemBoxLayout.setOnLongClickListener {
            editHintTextView.isVisible = !editHintTextView.isVisible
            editItemButton.isVisible = !editItemButton.isVisible
            deleteButton.isVisible = !deleteButton.isVisible
            deleteButton.isClickable = !deleteButton.isClickable

            if(deleteButton.isClickable) {
                deleteButton.setOnClickListener {
                    Log.i(TAG, array.toString())
                    array.remove(getItem(position))
                    Log.i(TAG, array.toString())
                    this.notifyDataSetChanged()
                }
            }

            true
        }



        return view
    }
}



