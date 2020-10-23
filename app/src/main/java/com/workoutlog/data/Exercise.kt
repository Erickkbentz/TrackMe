package com.workoutlog.data

data class Exercise (
        val name : String,
        var sets : Int,
        var reps : Int,
        var weightForSet: HashMap<Int, Int>,
        var oneRepMax : Int
) {
   constructor(name: String) : this(name, 0, 0, HashMap<Int, Int>(), 0)
}