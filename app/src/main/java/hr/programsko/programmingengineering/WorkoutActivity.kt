package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hr.programsko.programmingengineering.databinding.ActivitySignUpBinding
import hr.programsko.programmingengineering.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val weight = binding.txtEditText.text.toString()
            val height = binding.txtEditTextHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                val intent = Intent(this, SetWorkoutGoal::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Both weight and height fields must be filled in.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}