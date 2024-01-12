package hr.programsko.programmingengineering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivityFatLossMealsBinding
import kotlin.random.Random

class FatLossMealsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFatLossMealsBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFatLossMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (day in 1..7) {
            setMeal("FatLossBreakfast", binding.btnMeal1day(day))
            setMeal("FatLossLunch", binding.btnMeal2day(day))
            setMeal("FatLossDinner", binding.btnMeal3day(day))
        }
    }

    private fun setMeal(collection: String, button: Button) {
        val specificRandomValue = (1..3).random()

        db.collection(collection)
            .whereGreaterThanOrEqualTo("Random", specificRandomValue)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val meal = document.getString("Name")

                        if (meal != null) {
                            button.text = meal
                        }
                    }
                } else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }
    }

    private fun ActivityFatLossMealsBinding.btnMeal1day(day: Int) : Button {
        return when (day) {
            1 -> btnMeal1Day1
            2 -> btnMeal1Day2
            3 -> btnMeal1Day3
            4 -> btnMeal1Day4
            5 -> btnMeal1Day5
            6 -> btnMeal1Day6
            7 -> btnMeal1Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    private fun ActivityFatLossMealsBinding.btnMeal2day(day: Int) : Button {
        return when (day) {
            1 -> btnMeal2Day1
            2 -> btnMeal2Day2
            3 -> btnMeal2Day3
            4 -> btnMeal2Day4
            5 -> btnMeal2Day5
            6 -> btnMeal2Day6
            7 -> btnMeal2Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    private fun ActivityFatLossMealsBinding.btnMeal3day(day: Int) : Button {
        return when (day) {
            1 -> btnMeal3Day1
            2 -> btnMeal3Day2
            3 -> btnMeal3Day3
            4 -> btnMeal3Day4
            5 -> btnMeal3Day5
            6 -> btnMeal3Day6
            7 -> btnMeal3Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }
}