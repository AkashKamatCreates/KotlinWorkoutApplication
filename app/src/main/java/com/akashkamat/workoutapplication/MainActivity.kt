package com.akashkamat.workoutapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Moved after super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Enable light status bar icons
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val workoutList = createWorkoutList()
        adapter = WorkoutAdapter(workoutList)
        recyclerView.adapter = adapter
    }

    private fun createWorkoutList(): List<Workout> {
        val workoutList = mutableListOf<Workout>()


        workoutList.add(Workout("Squats", 2))
        workoutList.add(Workout("Abduction", 4))
        workoutList.add(Workout("Adduction", 4))
        workoutList.add(Workout("Leg Extension (Quads)", 5))
        workoutList.add(Workout("Leg Curl (HamStrings)", 5))
        workoutList.add(Workout("Calf Raises", 3))
        workoutList.add(Workout("Shoulder Lateral Raise", 3))
        workoutList.add(Workout("Shrugs", 3))

        return workoutList
    }
}