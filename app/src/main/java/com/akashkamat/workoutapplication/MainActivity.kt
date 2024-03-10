package com.akashkamat.workoutapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Calendar
import android.os.Handler

private const val MONDAY = Calendar.MONDAY
private const val TUESDAY = Calendar.TUESDAY
private const val WEDNESDAY = Calendar.WEDNESDAY
private const val THURSDAY = Calendar.THURSDAY
private const val FRIDAY = Calendar.FRIDAY
private const val SATURDAY = Calendar.SATURDAY
private const val SUNDAY = Calendar.SUNDAY

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkoutAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Moved after super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val workoutList = getWorkoutListForToday()
        adapter = WorkoutAdapter(workoutList)
        recyclerView.adapter = adapter

        val textView: TextView = findViewById(R.id.exerciseName)
        val dayOfWeek = getCurrentDayOfWeek().toString()
        textView.text = "$dayOfWeek:"



    }

    private fun getWorkoutListForToday(): List<Workout> {
        val currentDay = getCurrentDayOfWeek()
        return when (currentDay) {
            "Monday" -> mondayWorkout()
            "Tuesday" -> tuesdayWorkout()
            "Wednesday" -> wednesdayWorkout()
            "Thursday" -> thursdayWorkout()
            "Friday" -> fridayWorkout()
            "Saturday" -> saturdayWorkout()
            "Sunday" -> emptyList()
            else -> emptyList() // Handle default case
        }
    }


    private fun getCurrentDayOfWeek(): String {
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return when (dayOfWeek) {
            Calendar.MONDAY -> "Monday"
            Calendar.TUESDAY -> "Tuesday"
            Calendar.WEDNESDAY -> "Wednesday"
            Calendar.THURSDAY -> "Thursday"
            Calendar.FRIDAY -> "Friday"
            Calendar.SATURDAY -> "Saturday"
            Calendar.SUNDAY -> "Sunday"
            else -> throw IllegalArgumentException("Invalid day of week")
        }
    }

    private fun mondayWorkout(): List<Workout> {
        return listOf(
            Workout("Abs", 5),
            Workout("Flat Bench Press", 5),
            Workout("Inclined Bench Press", 3),
            Workout("Declined Bench Press", 4),
            Workout("Pectoral Fly", 5),
            Workout("Tricep Pushdown", 2)
        )
    }

    private fun tuesdayWorkout(): List<Workout> {
        return listOf(
            Workout("Lat Pulldown", 4),
            Workout("Row", 4),
            Workout("Bicep", 5),
            Workout("Shrugs", 3)
        )
    }

    private fun wednesdayWorkout(): List<Workout> {
        return listOf(
            Workout("Squats", 2),
            Workout("Abduction", 4),
            Workout("Adduction", 4),
            Workout("Leg Extension (Quads)", 5),
            Workout("Leg Curl (HamStrings)", 5),
            Workout("Calf Raises", 3),
            Workout("Shoulder Lateral Raise", 3)
        )
    }

    private fun thursdayWorkout(): List<Workout> {
        return mondayWorkout() // Same as Monday
    }

    private fun fridayWorkout(): List<Workout> {
        return tuesdayWorkout() // Same as Tuesday
    }

    private fun saturdayWorkout(): List<Workout> {
        return wednesdayWorkout() // Same as Wednesday
    }
}
