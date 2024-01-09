package hr.programsko.programmingengineering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import hr.programsko.programmingengineering.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), SigningView {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var navigationHandler: NavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        navigationHandler = NavigationHandler(this)

        binding.textView.setOnClickListener {
//            val intent = Intent(this, SignInActivity::class.java)
//            startActivity(intent)
            navigateToSignInScreen()
        }

        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
//                            val intent = Intent(this, SignInActivity::class.java)
//                            startActivity(intent)
                            navigateToSignInScreen()
                        } else {
                            showErrorMessage(it.exception.toString())
                            //Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    showErrorMessage("Password is not matching")
                    //Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            } else {
                showErrorMessage("Empty Fields Are not Allowed !!")
                //Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
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