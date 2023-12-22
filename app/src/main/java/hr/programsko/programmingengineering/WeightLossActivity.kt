package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivitySetWorkoutGoalBinding
import hr.programsko.programmingengineering.databinding.ActivityWeightLossBinding

class WeightLossActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightLossBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightLossBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cardio Workout bellow
        db.collection("CardioWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Jump")
                        val workoutSecond = document.getString("Climbing")
                        val workoutThird = document.getString("Jacks")
                        //val workoutFourth = document.getString("Burp")


                        if(workoutFirst != null){
                            binding.button1.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }


        // Upper Body Workout bellow
        db.collection("UpperBodyWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Dumbel")
                        val workoutSecond = document.getString("Bench")
                        val workoutThird = document.getString("Dip")


                        if(workoutFirst != null){
                            binding.button1DayTwo.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DayTwo.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DayTwo.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }
    }
}