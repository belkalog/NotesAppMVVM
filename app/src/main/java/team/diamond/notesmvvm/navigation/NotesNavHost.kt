package team.diamond.notesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import team.diamond.notesmvvm.screens.*

// создали класс с ссылками грубо говоря  начало
sealed class NavRoute(val route: String){//запечатаный class
        object Start: NavRoute("start_screen")
        object Main: NavRoute("main_screen")
        object Add: NavRoute("add_screen")
        object Note: NavRoute("note_screen")
}
// создали класс с ссылками грубо говоря  конец





@Composable
fun NotesNavHost (){
        val navController = rememberNavController()
        //  navController - контроллер навигации
        // startDestination - начать пункт назначения     composable - компонуемый
        NavHost(navController = navController, startDestination = NavRoute.Start.route) {
                composable(NavRoute.Start.route){StartScreen(navController = navController) }
                composable(NavRoute.Main.route){ MainScreen(navController = navController) }
                composable(NavRoute.Add.route){ AddScreen(navController = navController) }
                composable(NavRoute.Note.route){ NoteScreen(navController = navController) }
        }
}