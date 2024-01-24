package hr.programsko.programmingengineering

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.TaskCompletionSource
import com.google.android.gms.tasks.Tasks
import hr.programsko.programmingengineering.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity(), WorkoutView {
    companion object {
        private var instance: WorkoutActivity? = null

        fun getInstance(context: Context): WorkoutActivity {
            if (instance == null) {
                instance = WorkoutActivity()
            }
            return instance!!
        }
    }

    private lateinit var binding: ActivityWorkoutBinding
    private lateinit var navigationHandler: NavigationHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationHandler = NavigationHandler(this)

        binding.btnContinue.setOnClickListener {

            val weight: String? = binding.txtEditText.text.toString()
            val height: String? = binding.txtEditTextHeight.text.toString()

            //checkInputValidation(weight, height)


            val validationTask = checkInputValidation(weight, height)
            validationTask.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startSetWorkoutScreen()
                } else {
                    showErrorMessage(task.exception?.message ?: "Unexpected error")
                }
            }
        }

    }

    fun checkInputValidation(weight: String?, height: String?) : Task<Void>{

        val completionSource = TaskCompletionSource<Void>()

        if (weight != null && height != null && weight.isNotEmpty() && height.isNotEmpty()) {
            completionSource.setResult(null)
        } else {
            completionSource.setException(IllegalArgumentException("Both weight and height fields must be filled."))
        }

        return completionSource.task

    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startSetWorkoutScreen() {
        navigationHandler.navigateTo(Screen.SetWorkoutGoal)
    }
}