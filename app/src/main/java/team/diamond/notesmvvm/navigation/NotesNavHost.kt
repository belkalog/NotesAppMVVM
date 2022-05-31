package team.diamond.notesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import team.diamond.notesmvvm.screens.Add
import team.diamond.notesmvvm.screens.Main
import team.diamond.notesmvvm.screens.Note
import team.diamond.notesmvvm.screens.Start

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
                composable(NavRoute.Start.route){Start(navController = navController) }
                composable(NavRoute.Main.route){ Main(navController = navController) }
                composable(NavRoute.Add.route){ Add(navController = navController) }
                composable(NavRoute.Note.route){ Note(navController = navController) }
        }
}