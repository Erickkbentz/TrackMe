package com.workoutlog.data

data class Routine (
    val name: String,
    val type: RoutineType,
    val workoutList : ArrayList<Workout>
) {
 constructor(name: String, type: RoutineType) : this(name, type, when(type) {
     RoutineType.PPL -> {
         arrayListOf(
             Workout("Push", Constants.PRESET_PUSH_DAY),
             Workout("Pull", Constants.PRESET_PULL_DAY),
             Workout("Legs", Constants.PRESET_LEG_DAY)
         )
     }
     RoutineType.UPPER_LOWER -> {
         arrayListOf(
             Workout("Upper", Constants.PRESET_UPPER_DAY),
             Workout("Lower", Constants.PRESET_LOWER_DAY)
         )
     }
     RoutineType.FULL_BODY -> {
         arrayListOf(
             Workout("Full Body", Constants.PRESET_FULL_BODY_DAY)
         )
     }
 })
}

enum class RoutineType{
    PPL, UPPER_LOWER, FULL_BODY
}