package hr.programsko.programmingengineering

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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
        val confirmPass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        assertNotNull(result)
    }

    @Test
    fun whenInputsAreValid(){
        val email = "ab@mail.com"
        val pass = "mail123"
        val confirmPass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertTrue(it.isSuccessful)
            assertTrue(it.isComplete)
        }
    }

    @Test
    fun whenEmailIsNotValid(){
        val email = "ab"
        val pass = "mail123"
        val confirmPass = "mail123"

        val result = signUpAuth.createUserWithEmailAndPassword(email, pass)

        result.addOnCompleteListener {
            assertFalse(it.isSuccessful)
            assertTrue(it.exception is FirebaseAuthInvalidCredentialsException)
        }
    }


    @Test
    fun testUIElementsExistence() {
        val scenario = ActivityScenario.launch(SignUpActivity::class.java)

        onView(withId(R.id.emailEt)).check(matches(isDisplayed()))
        onView(withId(R.id.passET)).check(matches(isDisplayed()))
        onView(withId(R.id.confirmPassEt)).check(matches(isDisplayed()))
        onView(withId(R.id.textView)).check(matches(isDisplayed()))
        onView(withId(R.id.button)).check(matches(isDisplayed()))

        scenario.close()
    }
    @Test
    fun testButtonClick() {
        val scenario = ActivityScenario.launch(SignUpActivity::class.java)

        onView(withId(R.id.button)).perform(click())

        scenario.close()
    }
}