package hr.programsko.programmingengineering

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import hr.programsko.programmingengineering.databinding.ActivitySetWorkoutGoalBinding


class SetWorkoutGoal : AppCompatActivity() {

    private lateinit var binding: ActivitySetWorkoutGoalBinding
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetWorkoutGoalBinding.inflate(layoutInflater)


        setContentView(binding.root)

        val userId = FirebaseAuth.getInstance().currentUser!!.uid

        binding.btnLoseWeight.setOnClickListener {
            db.collection("CardioWorkout")
                .get()
                .addOnCompleteListener {task ->
                    if(task.isSuccessful){
                        for(document in task.result!!){
                            val jumpRope = db.collection("CardioWorkout").document(userId)
                            val mountainClimbers = db.collection("CardioWorkout").document(userId)
                            val jumpingJacks = db.collection("CardioWorkout").document(userId)
                            val burpees = db.collection("CardioWorkout").document(userId)
                        }
                    }
                    else{
                        Log.d("Error while fetching data", task.exception.toString())
                    }
                }

            val intent = Intent(this, WeightLossActivity::class.java)
            startActivity(intent)
        }
    }
}