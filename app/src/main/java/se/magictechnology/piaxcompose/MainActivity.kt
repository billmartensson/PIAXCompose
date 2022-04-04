package se.magictechnology.piaxcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.magictechnology.piaxcompose.ui.theme.PIAXComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PIAXComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AllTheApp()
                }
            }
        }
    }
}

@Composable
fun AllTheApp()
{
    var number by remember { mutableStateOf(0)}

    var names = mutableListOf<String>()
    names.add("Arne")
    names.add("Bengt")
    names.add("Caesar")
    names.add("David")


    Column {
        Greeting(name = "Hej") {
            number = number + 1
        }
        Text(number.toString())

        LazyColumn(modifier = Modifier.padding(all = 20.dp)) {
            items(names) { currentname ->
                NameRow(name = currentname)
            }
        }

    }

}

@Composable
fun NameRow(name : String)
{
    Text(name, modifier = Modifier.background(MaterialTheme.colors.secondary))
}

@Composable
fun Greeting(name: String, dostuff: () -> Unit) {

    var sometext by remember { mutableStateOf("Banan") }

    Column {
        Text(text = "Hello $name!")
        Text(sometext, modifier = Modifier.clickable {
            sometext = "Apelsin"
        })

        Row(modifier = Modifier
            .padding(all = 10.dp)
            .background(MaterialTheme.colors.secondary)
            .height(50.dp)) {
            Text("A", modifier = Modifier.weight(1f))
            Text("B", modifier = Modifier.weight(9f))
        }

        Button(onClick = {
            sometext = "Kiwi"
            dostuff()
        }) {
            Text("Tryck här!")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PIAXComposeTheme {
        AllTheApp()
    }
}