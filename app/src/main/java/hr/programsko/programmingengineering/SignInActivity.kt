package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import hr.programsko.programmingengineering.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), SigningView {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        navigationHandler = NavigationHandler(this)
        binding.textView.setOnClickListener {
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)

            navigationHandler.navigateTo(Screen.SignUp)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
//                        val intent = Intent(this, WorkoutActivity::class.java)
//                        startActivity(intent)
                        navigateToWorkoutScreen()
                    } else {
                        showErrorMessage(it.exception.toString())
                        //Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                showErrorMessage("Empty Fields Are not Allowed !!")
                //Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
//            val intent = Intent(this, WorkoutActivity::class.java)
//            startActivity(intent)

            navigationHandler.navigateTo(Screen.Workout)
        }
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToWorkoutScreen(){
        navigationHandler.navigateTo(Screen.Workout)
    }
}