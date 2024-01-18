package hr.programsko.programmingengineering

import com.google.firebase.auth.FirebaseAuth
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SignInActivityTest{

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var signInAuth : SignInFirebaseAuthentification

    @Before
    fun setup(){
        firebaseAuth = FirebaseAuth.getInstance()
        signInAuth = SignInFirebaseAuthentification.getInstance(firebaseAuth)
    }

    @Test
    fun whenInputAreNotNull(){
        val email = "a@mail.com"
        val pass = "mail123"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        assertNotNull(result)
    }

    @Test
    fun whenInputsAreValid() {
        val email = "a@mail.com"
        val pass = "mail123"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertTrue(it.isComplete)
            assertTrue(it.isSuccessful)
        }
    }

    @Test
    fun whenInputsAreInvalid() {
        val email = "mail"
        val pass = "invalid_password"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertTrue(it.isComplete)
            assertFalse(it.isSuccessful)
        }
    }
}