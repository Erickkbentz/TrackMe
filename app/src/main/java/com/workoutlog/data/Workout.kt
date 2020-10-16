package com.workoutlog.data

data class Workout(
        var name : String,
        var exerciseList : ArrayList<Exercise>,
) {
    constructor() : this("", ArrayList<Exercise>())
}
