package hr.programsko.programmingengineering

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivitySetWorkoutGoalBinding


class SetWorkoutGoal : AppCompatActivity() {

    private lateinit var binding: ActivitySetWorkoutGoalBinding
    private lateinit var navigationHandler: NavigationHandler
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetWorkoutGoalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationHandler = NavigationHandler(this)

        binding.btnLoseWeight.setOnClickListener {
//            val intent = Intent(this, WeightLossActivity::class.java)
//            startActivity(intent)

            navigateToWeightLossActivity()
        }
    }

    private fun navigateToWeightLossActivity() {
        navigationHandler.navigateTo(Screen.WeightLossActivity)
    }
}