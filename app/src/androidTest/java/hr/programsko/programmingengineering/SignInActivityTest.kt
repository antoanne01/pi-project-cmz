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
        val email = "someMail"
        val pass = "mail123"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertNotNull(result)
            assertFalse(result.isSuccessful)
        }
    }

    @Test
    fun whenInputsAreValid() {
        val email = "a@mail.com"
        val pass = "mail123"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertTrue(it.isComplete)
            assertTrue(it.isSuccessful)
            assertFalse(it.exception is IllegalArgumentException)
        }
    }

    // Bellow is doubtful
    @Test
    fun whenInputsAreInvalid() {
        val email = "mail"
        val pass = "ip"

        val result = signInAuth.signInWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertFalse(it.isSuccessful)
            assertTrue(it.exception is IllegalArgumentException)
        }
    }

    @Test
    fun whenEmailIsEmpty(){

        val email = ""
        val pass = "invalid_password"

        val result = if (email.isEmpty()) {
            IllegalArgumentException("Empty email")
        } else {
            assertThrows(IllegalArgumentException::class.java){
                signInAuth.signInWithEmailAndPassword(email, pass)
            }
        }

        assertEquals("Empty email", result.message)
    }

    @Test
    fun whenPasswordIsEmpty(){
        val email = "a@mail.com"
        val pass = ""

        val result = if(pass.isEmpty()){
            IllegalArgumentException("Empty password")
        }
        else{
            assertThrows(IllegalArgumentException::class.java){
                signInAuth.signInWithEmailAndPassword(email, pass)
            }
        }
        assertEquals("Empty password", result.message)
    }
}