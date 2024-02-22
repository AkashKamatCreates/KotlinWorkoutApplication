package com.akashkamat.workoutapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutAdapter(private val workoutList: List<Workout>) :
    RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    inner class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseName: TextView = itemView.findViewById(R.id.exerciseName)
        val checkBoxes: List<CheckBox> = listOf(
            itemView.findViewById(R.id.checkBox1),
            itemView.findViewById(R.id.checkBox2),
            itemView.findViewById(R.id.checkBox3),
            itemView.findViewById(R.id.checkBox4),
            itemView.findViewById(R.id.checkBox5)
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.workout_item, parent, false)
        return WorkoutViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val currentWorkout = workoutList[position]
        holder.exerciseName.text = currentWorkout.name

        for (i in 0 until currentWorkout.totalSets) {
            holder.checkBoxes[i].text = "Set ${i + 1}"
        }
    }

    override fun getItemCount() = workoutList.size
}
