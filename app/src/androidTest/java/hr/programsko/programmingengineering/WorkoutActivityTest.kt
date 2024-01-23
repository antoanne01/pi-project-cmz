package hr.programsko.programmingengineering

import androidx.test.core.app.ActivityScenario
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class WorkoutActivityTest{

    private lateinit var scenario : ActivityScenario<WorkoutActivity>

    @Before
    fun setup(){
        scenario = ActivityScenario.launch(WorkoutActivity::class.java)
    }

    @Test
    fun whenInputsAreValid(){

        val weight = "90"
        val height = "190"

        scenario.onActivity { activity ->
            activity.checkInputValidation(weight, height)

            assertNotNull(activity)
        }
    }

    @Test
    fun whenWeightInputIsEmpty(){

        val weight: String? = ""
        val height = "190"


        scenario.onActivity { activity ->
            val validationTask = activity.checkInputValidation(weight, height)

            assertFalse(validationTask.isSuccessful)
            assertTrue(validationTask.exception is IllegalArgumentException)
        }
    }

    @Test
    fun whenHeightInputIsEmpty(){

        val weight = "90"
        val height : String? = ""

        scenario.onActivity {activity ->
            val validationTask = activity.checkInputValidation(weight, height)

            assertFalse(validationTask.isSuccessful)
            assertTrue(validationTask.exception is IllegalArgumentException)
        }
    }

    @Test
    fun whenHeightInputIsNull(){

        val weight = "90"
        val height : String? = null

        scenario.onActivity {activity ->
            val validationTask = activity.checkInputValidation(weight, height)

            assertFalse(validationTask.isSuccessful)
            assertTrue(validationTask.exception is IllegalArgumentException)
        }
    }

    @Test
    fun whenWeightInputIsNull(){

        val weight : String? = null
        val height = "190"

        scenario.onActivity {activity ->
            val validationTask = activity.checkInputValidation(weight, height)

            assertFalse(validationTask.isSuccessful)
            assertTrue(validationTask.exception is IllegalArgumentException)
        }
    }
}