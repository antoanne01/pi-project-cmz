package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hr.programsko.programmingengineering.databinding.ActivitySignUpBinding
import hr.programsko.programmingengineering.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity(), WorkoutView {

    private lateinit var binding: ActivityWorkoutBinding
    private lateinit var navigationHandler: NavigationHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationHandler = NavigationHandler(this)

        binding.btnContinue.setOnClickListener {
            val weight = binding.txtEditText.text.toString()
            val height = binding.txtEditTextHeight.text.toString()

            if (weight.isNotEmpty() && height.isNotEmpty()) {
                startSetWorkoutScreen()
            } else {
                showErrorMessage("Both weight and height fields must be filled.")
            }
        }

    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startSetWorkoutScreen() {
        navigationHandler.navigateTo(Screen.SetWorkoutGoal)
    }
}