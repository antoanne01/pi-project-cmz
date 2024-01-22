package hr.programsko.programmingengineering

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
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
    fun whenWeightInputIsNotValid(){

        val weight = ""
        val height = "190"

        scenario.onActivity {activity ->
            activity.checkInputValidation(weight, height)

            assertNotNull(activity)
        }
    }
}