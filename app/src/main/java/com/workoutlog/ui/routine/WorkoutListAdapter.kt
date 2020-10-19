package com.workoutlog.ui.routine

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.workoutlog.R
import com.workoutlog.data.Workout


class WorkoutListAdapter(context : Context,
                         @LayoutRes val resource : Int,
                         private val array : ArrayList<Workout>)
    : ArrayAdapter<Workout>(context,  resource,  array) {

    private val TAG = WorkoutListAdapter::class.java.canonicalName


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val workoutName = getItem(position)?.name
        Log.i(TAG, "Setting TextView to:$workoutName")
        val inflater:LayoutInflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.workout_list_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.itemName)
        textView.text = workoutName

        return view
    }
}