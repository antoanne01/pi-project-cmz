package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivitySetWorkoutGoalBinding
import hr.programsko.programmingengineering.databinding.ActivityWeightLossBinding

class WeightLossActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeightLossBinding
    private lateinit var navigationHandler: NavigationHandler
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeightLossBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigationHandler = NavigationHandler(this)

        for (day in 1..7) {
            setWorkout("UpperBodyWorkout", binding.btnButton1Day(day))
            setWorkout("LowerBodyWorkout", binding.btnButton2Day(day))
            setWorkout("CardioWorkout", binding.btnButton3Day(day))
        }
        /*
        // Cardio Workout bellow
        // Day 1
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
        // Day 2
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

        // Lower Body Workout bellow
        // Day 3
        db.collection("LowerBodyWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Legs")
                        val workoutSecond = document.getString("Squats")
                        val workoutThird = document.getString("DeadLift")


                        if(workoutFirst != null){
                            binding.button1DayThree.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DayThree.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DayThree.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // Hands Workout bellow
        // Day 4
        db.collection("HandsWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Biceps")
                        val workoutSecond = document.getString("Triceps")
                        val workoutThird = document.getString("Press")


                        if(workoutFirst != null){
                            binding.button1DayFour.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DayFour.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DayFour.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }


        // Cardio Workout bellow
        // Day 5
        db.collection("CardioWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Burp")
                        val workoutSecond = document.getString("Jacks")
                        val workoutThird = document.getString("Climbing")


                        if(workoutFirst != null){
                            binding.button1DayFive.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DayFive.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DayFive.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // Lower Body Workout bellow
        // Day 6
        db.collection("LowerBodyWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Legs")
                        val workoutSecond = document.getString("Squats")
                        val workoutThird = document.getString("Deadlift")


                        if(workoutFirst != null){
                            binding.button1DaySix.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DaySix.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DaySix.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }


        // Cardio Workout bellow
        // Day 7
        db.collection("CardioWorkout")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        // Access the data from each document
                        val workoutFirst = document.getString("Jump")
                        val workoutSecond = document.getString("Climbing")
                        val workoutThird = document.getString("Jacks")


                        if(workoutFirst != null){
                            binding.button1DaySeven.text = workoutFirst
                        }
                        else if(workoutSecond != null){
                            binding.button2DaySeven.text = workoutSecond
                        }
                        else if(workoutThird != null){
                            binding.button3DaySeven.text = workoutThird
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

            */



        binding.buttonMealDay1.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay2.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay3.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay4.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay5.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay6.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay7.setOnClickListener { startDailyMealsActivity() }




    }

    private fun setWorkout(collection: String, button: Button) {
        val specificRandomValue = (1..3).random()

        db.collection(collection)
            .whereGreaterThanOrEqualTo("Random", specificRandomValue)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        var workout = document.getString("Name")

                        if (workout != null) {
                            button.text = workout
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }
    }

    private fun ActivityWeightLossBinding.btnButton1Day(day: Int): Button {
        return when (day) {
            1 -> button1DayOne
            2 -> button1DayTwo
            3 -> button1DayThree
            4 -> button1DayFour
            5 -> button1DayFive
            6 -> button1DaySix
            7 -> button1DaySeven
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    private fun ActivityWeightLossBinding.btnButton2Day(day: Int): Button {
        return when (day) {
            1 -> button2DayOne
            2 -> button2DayTwo
            3 -> button2DayThree
            4 -> button2DayFour
            5 -> button2DayFive
            6 -> button2DaySix
            7 -> button2DaySeven
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    private fun ActivityWeightLossBinding.btnButton3Day(day: Int): Button {
        return when (day) {
            1 -> button3DayOne
            2 -> button3DayTwo
            3 -> button3DayThree
            4 -> button3DayFour
            5 -> button3DayFive
            6 -> button3DaySix
            7 -> button3DaySeven
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    private fun startDailyMealsActivity() {
        navigationHandler.navigateTo(Screen.FatLossMealsActivity)
    }
}
