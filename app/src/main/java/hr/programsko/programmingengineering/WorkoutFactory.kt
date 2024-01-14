package hr.programsko.programmingengineering

class WorkoutFactory {
    companion object{
        fun createWorkout(workoutType : String) : Workout?{
            return when (workoutType){
                "UpperBodyWorkout" -> WorkoutUpperBody()
                "LowerBodyWorkout" -> WorkoutLowerBody()
                "CardioWorkout" -> WorkoutCardio()
                else -> null
            }
        }
    }
}