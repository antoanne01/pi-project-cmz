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
import kotlin.random.Random

class WeightLossActivity : AppCompatActivity(){

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

        binding.buttonMealDay1.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay2.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay3.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay4.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay5.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay6.setOnClickListener { startDailyMealsActivity() }

        binding.buttonMealDay7.setOnClickListener { startDailyMealsActivity() }
    }

    private fun setWorkout(collection: String, button: Button) {
//        val specificRandomValue = (1..3).random()
//
//        db.collection(collection)
//            .whereGreaterThanOrEqualTo("Random", specificRandomValue)
//            .orderBy("Random")
//            .limit(1)
//            .get()
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    for (document in task.result!!) {
//                        var workout = document.getString("Name")
//
//                        if (workout != null) {
//                            button.text = workout
//                        }
//                    }
//                } else {
//                    Log.d("Error while fetching data", task.exception.toString())
//                }
//            }

        val specificRandomValue = (1..3).random()
        val workout = WorkoutFactory.createWorkout(collection)

        db.collection(collection)
            .whereGreaterThanOrEqualTo("Random", specificRandomValue)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener {task ->
                if(task.isSuccessful){
                    for(document in task.result!!){
                        val workoutName = workout?.getWorkoutName()
                        if(workoutName != null){
                            button.text = workoutName
                        }
                    }
                }
                else{
                    Toast.makeText(this, "Error while fetching data", Toast.LENGTH_SHORT).show()
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
