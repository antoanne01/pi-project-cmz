package hr.programsko.programmingengineering

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class SignUpFirebaseAuthentification(private val firebaseAuth : FirebaseAuth)
    : SignUpFirebaseAuthentificationInterface{

    companion object {
        private var instance: SignUpFirebaseAuthentification? = null

        fun getInstance(firebaseAuth: FirebaseAuth): SignUpFirebaseAuthentification {
            if (instance == null) {
                instance = SignUpFirebaseAuthentification(firebaseAuth)
            }
            return instance!!
        }
    }
    override fun createUserWithEmailAndPassword(
        email: String,
        pass: String
    ): Task<AuthResult>
    {
        return firebaseAuth.createUserWithEmailAndPassword(email, pass)
    }
}