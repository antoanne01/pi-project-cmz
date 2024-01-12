package hr.programsko.programmingengineering

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignInFirebaseAuthentification(private val firebaseAuth: FirebaseAuth)
    : SignInFirebaseAuthentificationInterface{

    override fun signInWithEmailAndPassword(email: String, pass: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, pass)
    }

    override fun currentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}