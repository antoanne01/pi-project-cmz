package hr.programsko.programmingengineering

sealed class Screen(val route : String){
    object SignIn : Screen("sign_in_screen")
    object SignUp : Screen("sign_up_screen")
    object Workout : Screen("workout_screen")
}