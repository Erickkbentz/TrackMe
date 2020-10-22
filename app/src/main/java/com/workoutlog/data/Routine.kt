package com.workoutlog.data

data class Routine(val name: String, val type: RoutineType, val workoutList : ArrayList<Workout>) {

 constructor(name: String, type: RoutineType) : this(name, type, when(type) {
     RoutineType.PPL -> {
         arrayListOf(
             Workout("Push"),
             Workout("Pull"),
             Workout("Legs")
         )
     }
     RoutineType.UPPER_LOWER -> {
         arrayListOf(
             Workout("Upper"),
             Workout("Lower")
         )
     }
     RoutineType.FULL_BODY -> {
         arrayListOf(
             Workout("Full Body")
         )
     }
 })
}

enum class RoutineType{
    PPL, UPPER_LOWER, FULL_BODY
}