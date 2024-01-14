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

        val mealButtonBuilder = FatLossMealButtonBuilder(binding)

        for (day in 1..7) {
            val breakfastButton = mealButtonBuilder.buildBreakfastButton(day)
            setMeal("FatLossBreakfast", breakfastButton)

            val lunchButton = mealButtonBuilder.buildLunchButton(day)
            setMeal("FatLossLunch", lunchButton)

            val dinnerButton = mealButtonBuilder.buildDinnerButton(day)
            setMeal("FatLossDinner", dinnerButton)
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
}