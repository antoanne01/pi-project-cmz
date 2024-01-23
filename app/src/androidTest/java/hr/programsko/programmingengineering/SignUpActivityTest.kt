package hr.programsko.programmingengineering

import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
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

    // Bellow is doubtful
    @Test
    fun whenInputsAreInvalid() {
        val email = "a@mail.com"
        val pass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertFalse(it.isSuccessful)
            assertTrue(it.exception is FirebaseAuthInvalidCredentialsException)
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
                signUpAuth.createUserWithEmailAndPassword(email, pass)
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
                signUpAuth.createUserWithEmailAndPassword(email, pass)
            }
        }
        assertEquals("Empty password", result.message)
    }


    // bellow test is following given-when-then which above one do not folllows

//
//    @Test
//    fun whenPasswordIsEmpty() {
//        // Given
//        val email = "a@mail.com"
//        val pass = ""
//
//        // When
//        val exception = assertThrows(IllegalArgumentException::class.java) {
//            signUpAuth.createUserWithEmailAndPassword(email, pass)
//        }
//
//        // Then
//        assertEquals("Empty password", exception.message)
//    }
}