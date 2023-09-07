package com.example.rolldiceapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rolldiceapplication.ui.theme.RollDiceApplicationTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private val imgRoller by viewModels<DiceRollerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RollDiceApplicationTheme {
                DiceRollerApp(imgRoller)
            }
        }
    }
}

@Composable
fun DiceRollerApp(imgRoller: DiceRollerViewModel) {
    DiceWithButtonAndImage(imgRoller)
}

@Composable
fun DiceWithButtonAndImage(imgRoller: DiceRollerViewModel,modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = imgRoller.image),
            contentDescription = "1",)

        Button(onClick = {
           val result =  Random.nextInt(1, 7)
            imgRoller.diceRoll(result)
        },
            modifier.padding(16.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White),
            enabled = true,
            shape = RoundedCornerShape(size = 16.dp),

        ) {
            Text(text = "Roll")
        }
    }

}