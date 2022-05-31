package team.diamond.notesmvvm.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import team.diamond.notesmvvm.navigation.NavRoute
import team.diamond.notesmvvm.ui.theme.NotesMVVMTheme


//  Composable  - составной
    @Composable
    fun MainScreen(navController: NavHostController) {
        Text(text = "Main screen")

        Scaffold (
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.navigate(NavRoute.Add.route)
                    }) {
                    Icon(imageVector =Icons.Filled.Add ,
                        contentDescription ="Add Icons",
                        tint = Color.White
                    )
                }
            }
        ){
            Column() {
                NoteItem(title = "Note 1", subtitle = "Subtitle for note 1",navController = navController )
                NoteItem(title = "Note 2", subtitle = "Subtitle for note 2",navController = navController )
                NoteItem(title = "Note 3", subtitle = "Subtitle for note 3",navController = navController )
                NoteItem(title = "Note 4", subtitle = "Subtitle for note 4",navController = navController )
            }
        }
    }


@Composable  //аннатация  Composable - Составной
fun NoteItem (title:String, subtitle:String, navController:NavHostController){
    //карта
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            //команда перехода на Note
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp),
            //текст то центру
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = subtitle)
        }

    }
}

//прописали постоянные изменения на макете - фунция превью
@Preview(showBackground = true)
@Composable
fun prevMainScreen(){
    NotesMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}