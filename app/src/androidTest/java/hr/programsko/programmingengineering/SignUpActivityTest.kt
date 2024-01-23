package hr.programsko.programmingengineering

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SignUpActivityTest{
    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var signUpAuth : SignUpFirebaseAuthentification

    @Before
    fun setup(){
        firebaseAuth = FirebaseAuth.getInstance()
        signUpAuth = SignUpFirebaseAuthentification.getInstance(firebaseAuth)
    }

    @Test
    fun whenInputsAreNotNull(){
        val email = "ab@mail.com"
        val pass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        assertNotNull(result)
    }

    @Test
    fun whenInputsAreValid(){
        val email = "ab@mail.com"
        val pass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertTrue(it.isSuccessful)
        }
    }

    @Test
    fun whenEmailIsNotValid(){
        val email = "ab"
        val pass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            //assertFalse(it.isSuccessful)
            assertFalse(it.exception is FirebaseAuthInvalidCredentialsException)
        }
    }
}