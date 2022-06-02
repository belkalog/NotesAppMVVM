package team.diamond.notesmvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import team.diamond.notesmvvm.MainViewModel
import team.diamond.notesmvvm.MainViewModelFactory
import team.diamond.notesmvvm.navigation.NavRoute
import team.diamond.notesmvvm.ui.theme.NotesMVVMTheme
import team.diamond.notesmvvm.utils.TYPE_FIREBASE
import team.diamond.notesmvvm.utils.TYPE_ROOM

//  Composable  - составной
@Composable
fun StartScreen(navController: NavHostController) {

    val contex = LocalContext.current
    val  mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(contex.applicationContext as Application))

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "What will we use?")

            Button(
                onClick = {
                    mViewModel.iniDatabase(TYPE_ROOM)   // подрубаем базу ROOM
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Room database")
            }


            Button(
                    onClick = {
                        mViewModel.iniDatabase(TYPE_FIREBASE)    // подрубаем базу FIREBASE
                        navController.navigate(route = NavRoute.Main.route)
                    },
            modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)
            ) {
            Text(text = "Firebase database")
        }
        }
        }
}


@Preview(showBackground = true)
@Composable
fun prevStartScreen(){
    NotesMVVMTheme {
        StartScreen(navController = rememberNavController())
        
    }
}