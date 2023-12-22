package hr.programsko.programmingengineering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        // breakfast - day 1

        val specificRandomValueDayOne = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayOne)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day1.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 1

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayOne)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day1.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 1

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayOne)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day1.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 2

        val specificRandomValueDayTwo = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayTwo)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day2.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 2

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayTwo)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day2.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 2

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayTwo)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day2.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 3

        val specificRandomValueDayThree = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayThree)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day3.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 3

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayThree)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day3.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 3

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayThree)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day3.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 4

        val specificRandomValueDayFour = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFour)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day4.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 4

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFour)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day4.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 4

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFour)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day4.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 5

        val specificRandomValueDayFive = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFive)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day5.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 5

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFive)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day5.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 5

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDayFive)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day5.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 6

        val specificRandomValueDaySix = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySix)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day6.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 6

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySix)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day6.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 6

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySix)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day6.text = dinner
                        }
                    }
                }
            }

        // breakfast - day 7

        val specificRandomValueDaySeven = (1..3).random()

        db.collection("FatLossBreakfast")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySeven)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val breakfast = document.getString("Name")

                        if (breakfast != null) {
                            binding.btnMeal1Day7.text = breakfast
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // lunch - day 7

        db.collection("FatLossLunch")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySeven)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val lunch = document.getString("Name")

                        if (lunch != null) {
                            binding.btnMeal2Day7.text = lunch
                        }
                    }
                }
                else {
                    Log.d("Error while fetching data", task.exception.toString())
                }
            }

        // dinner - day 7

        db.collection("FatLossDinner")
            .whereGreaterThanOrEqualTo("Random", specificRandomValueDaySeven)
            .orderBy("Random")
            .limit(1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        val dinner = document.getString("Name")

                        if (dinner != null) {
                            binding.btnMeal3Day7.text = dinner
                        }
                    }
                }
            }
    }

}