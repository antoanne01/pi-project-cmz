package hr.programsko.programmingengineering

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface SignUpFirebaseAuthentificationInterface {

    fun createUserWithEmailAndPassword(email : String, pass : String): Task<AuthResult>
}