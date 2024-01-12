package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import hr.programsko.programmingengineering.databinding.ActivitySignUpBinding

class SignUpActivity :  AppCompatActivity(), SigningView {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuthentification: SignUpFirebaseAuthentificationInterface
    private lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuthentification = SignUpFirebaseAuthentification(FirebaseAuth.getInstance())
        navigationHandler = NavigationHandler(this)

        binding.textView.setOnClickListener {
            navigateToSignInScreen()
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    firebaseAuthentification.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            navigateToSignInScreen()
                        }
                        else{
                            showErrorMessage(it.exception.toString())
                        }
                    }
                } else {
                    showErrorMessage("Password is not matching")
                }
            } else {
                showErrorMessage("Empty Fields Are not Allowed !!")
            }
        }
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToSignInScreen(){
        navigationHandler.navigateTo(Screen.SignIn)
    }
}