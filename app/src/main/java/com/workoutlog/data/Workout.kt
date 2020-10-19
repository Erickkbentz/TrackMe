package com.workoutlog.data

data class Workout(
        val name : String,
        val exerciseList : ArrayList<Exercise>,
) {
    constructor(name: String) : this(name, ArrayList<Exercise>())
}
