package team.diamond.notesmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import team.diamond.notesmvvm.navigation.NotesNavHost
import team.diamond.notesmvvm.ui.theme.NotesMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesMVVMTheme {
                Scaffold(
                    topBar = {
                        TopAppBar (
                            title = {
                                Text(text = "Notes App")
                            },
                            backgroundColor = androidx.compose.ui.graphics.Color.Blue,
                            contentColor = androidx.compose.ui.graphics.Color.White,
                            elevation = 12.dp
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ){
                            NotesNavHost()
                        }
                    }


                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesMVVMTheme {

    }
}