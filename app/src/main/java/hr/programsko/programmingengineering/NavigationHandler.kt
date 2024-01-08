package hr.programsko.programmingengineering

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class NavigationHandler(private val context: Context) {

    fun navigateTo(screen: Screen){
        when (screen) {
            is Screen.SignUp -> startActivity(SignUpActivity::class.java)
            is Screen.Workout -> startActivity(WorkoutActivity::class.java)
            is Screen.SignIn -> startActivity(SignInActivity::class.java)
            is Screen.SetWorkoutGoal -> startActivity(SetWorkoutGoal::class.java)
            is Screen.WeightLossActivity -> startActivity(WeightLossActivity::class.java)
        }
    }

    private fun startActivity(destination: Class<*>) {
        context.startActivity(Intent(context, destination))
    }
}