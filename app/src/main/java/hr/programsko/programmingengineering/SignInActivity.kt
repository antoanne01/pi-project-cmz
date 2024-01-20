package hr.programsko.programmingengineering

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import hr.programsko.programmingengineering.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), SigningView {

    private lateinit var binding: ActivitySignInBinding
    lateinit var firebaseAuthentification: SignInFirebaseAuthentificationInterface
    lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //firebaseAuthentification = SignInFirebaseAuthentification(FirebaseAuth.getInstance())
        firebaseAuthentification = SignInFirebaseAuthentification.getInstance(FirebaseAuth.getInstance())
        navigationHandler = NavigationHandler(this)
        binding.textView.setOnClickListener {

            navigationHandler.navigateTo(Screen.SignUp)
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString().trim()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuthentification.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        navigateToWorkoutScreen()
                    }
                    else{
                        showErrorMessage("Error occurred, try again")
                    }
                }
            } else {
                showErrorMessage("Empty Fields Are not Allowed !!")
            }
        }
    }

    public override fun onStart() {
        super.onStart()

        if(firebaseAuthentification.currentUser() != null){
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