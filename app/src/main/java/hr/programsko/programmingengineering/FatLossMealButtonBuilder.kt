package hr.programsko.programmingengineering

import android.widget.Button
import hr.programsko.programmingengineering.databinding.ActivityFatLossMealsBinding

class FatLossMealButtonBuilder(private val binding: ActivityFatLossMealsBinding) {
/*
    fun buildBreakfastButton(day: Int): Button {
        return when (day) {
            1 -> binding.btnMeal1Day1
            2 -> binding.btnMeal1Day2
            3 -> binding.btnMeal1Day3
            4 -> binding.btnMeal1Day4
            5 -> binding.btnMeal1Day5
            6 -> binding.btnMeal1Day6
            7 -> binding.btnMeal1Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    fun buildLunchButton(day: Int): Button {
        return when (day) {
            1 -> binding.btnMeal2Day1
            2 -> binding.btnMeal2Day2
            3 -> binding.btnMeal2Day3
            4 -> binding.btnMeal2Day4
            5 -> binding.btnMeal2Day5
            6 -> binding.btnMeal2Day6
            7 -> binding.btnMeal2Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }

    fun buildDinnerButton(day: Int): Button {
        return when (day) {
            1 -> binding.btnMeal3Day1
            2 -> binding.btnMeal3Day2
            3 -> binding.btnMeal3Day3
            4 -> binding.btnMeal3Day4
            5 -> binding.btnMeal3Day5
            6 -> binding.btnMeal3Day6
            7 -> binding.btnMeal3Day7
            else -> throw IllegalArgumentException("Invalid day: $day")
        }
    }
    */

    private val buttonMap = mutableMapOf<Pair<Int, Int>, Button>()

    init{
        initializeButtonMap()
    }

    private fun initializeButtonMap() {
        for(day in 1..7) {
            buttonMap[Pair(1, day)] = getButtonForMeal(1, day)
            buttonMap[Pair(2, day)] = getButtonForMeal(2, day)
            buttonMap[Pair(3, day)] = getButtonForMeal(3, day)
        }
    }

    private fun getButtonForMeal(meal: Int, day: Int) : Button {
        return when (meal) {
            1 -> when (day) {
                1 -> binding.btnMeal1Day1
                2 -> binding.btnMeal1Day2
                3 -> binding.btnMeal1Day3
                4 -> binding.btnMeal1Day4
                5 -> binding.btnMeal1Day5
                6 -> binding.btnMeal1Day6
                7 -> binding.btnMeal1Day7
                else -> throw IllegalArgumentException("Invalid day: $day")
            }
            2 -> when (day) {
                1 -> binding.btnMeal3Day1
                2 -> binding.btnMeal3Day2
                3 -> binding.btnMeal3Day3
                4 -> binding.btnMeal3Day4
                5 -> binding.btnMeal3Day5
                6 -> binding.btnMeal3Day6
                7 -> binding.btnMeal3Day7
                else -> throw IllegalArgumentException("Invalid day: $day")
            }
            3 -> when (day) {
                1 -> binding.btnMeal3Day1
                2 -> binding.btnMeal3Day2
                3 -> binding.btnMeal3Day3
                4 -> binding.btnMeal3Day4
                5 -> binding.btnMeal3Day5
                6 -> binding.btnMeal3Day6
                7 -> binding.btnMeal3Day7
                else -> throw IllegalArgumentException("Invalid day: $day")
            }
            else -> throw IllegalArgumentException("Invalid meal: $meal")
        }
    }

    fun build(meal: Int, day: Int): Button {
        return buttonMap[Pair(meal, day)] ?: throw IllegalArgumentException("Invalid meal or day: meal=$meal, day=$day")
    }
}

