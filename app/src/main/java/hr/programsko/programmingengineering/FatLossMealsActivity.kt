package hr.programsko.programmingengineering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivityDailyMealsBinding
import kotlin.random.Random

class FatLossMealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDailyMealsBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyMealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // breakfast - day 1

        db.collection("FatLossBreakfast")
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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

        db.collection("FatLossBreakfast")
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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

        db.collection("FatLossBreakfast")
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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
            .whereGreaterThan("Random", Random)
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

    }
}