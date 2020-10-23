package com.workoutlog.data

import java.lang.Exception

class Constants {
    companion object{
        @JvmStatic val ALL_PUSH_EXCERCISES = arrayListOf<String>(
            "Bench Press",
            "Incline Bench Press",
            "Dumbbell Pause Bench Press",
            "Incline Dumbbell Press",
            "Standing Dumbbell Press",
            "Seated Dumbbell Press",
            "Standing Military Press",
            "Side Lateral Raise",
            "Skull Crusher",
            "Cable Fly",
            "Dips",
            "Shrugs",
            "Tricep Push Down"
        )


        @JvmStatic val ALL_PULL_EXCERCISES = arrayListOf<String>(
            "Assisted Pull Ups",
            "Bent Over Row",
            "Lat Pull Down",
            "Seated Cable Row",
            "Lat Push Down",
            "Hammer Curl",
            "Face Pull",
            "Curl"
        )

        @JvmStatic val ALL_LEG_EXCERCISES = arrayListOf<String>(
            "Squat",
            "Front Squat",
            "Bulgarian Split Squat",
            "Deadlift",
            "Romanian Deadlift",
            "Hip Thrust",
            "Leg Curl",
            "Leg Extension",
            "Calf Raise"
        )

        @JvmStatic val PRESET_PUSH_DAY = arrayListOf<Exercise>(
            Exercise("Bench Press"),
            Exercise("Standing Dumbbell Press"),
            Exercise("Incline Dumbbell Press"),
            Exercise("Side Lateral Raise"),
            Exercise("Skull Crusher"),
            Exercise("Cable Fly"),
            Exercise("Dips"),
            Exercise("Shrugs")
        )

        @JvmStatic val PRESET_PULL_DAY = arrayListOf<Exercise>(
            Exercise("Assisted Pull Ups"),
            Exercise("Bent Over Row"),
            Exercise("Lat Pull Down"),
            Exercise("Seated Cable Row"),
            Exercise("Lat Push Down"),
            Exercise("Hammer Curl"),
            Exercise("Face Pull"),
            Exercise("Curl")
        )

        @JvmStatic val PRESET_LEG_DAY = arrayListOf<Exercise>(
            Exercise("Squat"),
            Exercise("Romanian Deadlift"),
            Exercise("Bulgarian Split Squat"),
            Exercise("Leg Curl"),
            Exercise("Leg Extension"),
            Exercise("Calf Raise")
        )

        @JvmStatic val PRESET_UPPER_DAY = arrayListOf<Exercise>(
            Exercise("Bench Press"),
            Exercise("Bent Over Row"),
            Exercise("Standing Military Press"),
            Exercise("Lat Pull Down"),
            Exercise("Side Lateral Raise"),
            Exercise("Curl "),
            Exercise("Seated Cable Row")
        )

        @JvmStatic val PRESET_LOWER_DAY = arrayListOf<Exercise>(
            Exercise("Squat"),
            Exercise("Deadlift"),
            Exercise("Hip Thrust"),
            Exercise("Leg Curl"),
            Exercise("Leg Extension"),
            Exercise("Calf Raise")
        )

        @JvmStatic val PRESET_FULL_BODY_DAY = arrayListOf<Exercise>(
            Exercise("Squat"),
            Exercise("Bent Over Row"),
            Exercise("Bench Press"),
            Exercise("Leg Curl"),
            Exercise("Tricep Push Down"),
            Exercise("Curl"),
            Exercise("Side Lateral Raise")
        )
    }
}
