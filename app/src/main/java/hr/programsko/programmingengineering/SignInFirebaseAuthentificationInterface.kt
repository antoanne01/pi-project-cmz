package hr.programsko.programmingengineering

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser

interface SignInFirebaseAuthentificationInterface {
    fun signInWithEmailAndPassword(email: String, pass: String): Task<AuthResult>
    fun currentUser(): FirebaseUser?
}