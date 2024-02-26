package com.akashkamat.workoutapplication

data class Workout(val name: String, val totalSets: Int) {
    val checkedStates = BooleanArray(totalSets)
}
