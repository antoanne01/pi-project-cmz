package hr.programsko.programmingengineering

import org.junit.Assert.*
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import hr.programsko.programmingengineering.WeightLossActivity
import hr.programsko.programmingengineering.databinding.ActivityWeightLossBinding
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import hr.programsko.programmingengineering.R

class WeightLossActivityTest

@RunWith(AndroidJUnit4::class)
class YourActivityTest {

    private lateinit var scenario: ActivityScenario<WeightLossActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(WeightLossActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

//    @Test
//    fun testBtnButton1Day() {
//        scenario.onActivity { activity ->
//            val binding = ActivityWeightLossBinding.bind(activity.findViewById(android.R.id.content))
//
//
//            for (day in 1..7) {
//                val button = binding.btnButton1Day(day)
//                val expectedButtonId = when (day) {
//                    1 -> R.id.button1DayOne
//                    2 -> R.id.button1DayTwo
//                    3 -> R.id.button1DayThree
//                    4 -> R.id.button1DayFour
//                    5 -> R.id.button1DayFive
//                    6 -> R.id.button1DaySix
//                    7 -> R.id.button1DaySeven
//                    else -> throw IllegalArgumentException("Invalid day: $day")
//                }
//
//                assertThat(button.id, equalTo(expectedButtonId))
//            }
//        }
//    }
}