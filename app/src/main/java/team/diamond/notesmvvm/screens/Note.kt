package team.diamond.notesmvvm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import team.diamond.notesmvvm.ui.theme.NotesMVVMTheme

//  Composable  - составной
@Composable
fun NoteScreen(navController: NavHostController) {
   // Text(text = "Note Screen")
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Card(
                    //modifier = модификатор
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Title",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(top =32.dp)
                        )
                        Text(
                            text = "Subtitle",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier.padding(top =16.dp)
                        )
                    }
                }
        }
    }
}
//прописали постоянные изменения на макете - фунция превью
@Preview(showBackground = true)
@Composable
fun prevNoteScreen(){
    NotesMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}