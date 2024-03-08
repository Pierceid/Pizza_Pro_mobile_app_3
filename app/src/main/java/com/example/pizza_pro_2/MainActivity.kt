package com.example.pizza_pro_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.pizza_pro_2.navigation.NavGraph
import com.example.pizza_pro_2.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavGraph(navHostController = navController)
        }
    }
}

@Composable
fun PizzaCard(
    painter: Painter,
    title: String,
    cost: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(140.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Black),
        elevation = 15.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(colors = listOf(Grey, Ashen)))
        ) {
            Image(
                modifier = Modifier
                    .padding(10.dp)
                    .border(border = BorderStroke(1.dp, Black))
                    .clickable(onClick = {}),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp, 5.dp, 10.dp, 10.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1,
                    color = Red,
                    modifier = Modifier.clickable(onClick = {})
                )
                Text(
                    text = cost,
                    style = MaterialTheme.typography.h1,
                    color = Black
                )
                Box(
                    modifier = Modifier
                        .size(126.dp, 42.dp)
                        .background(
                            color = Orange,
                            shape = RoundedCornerShape(42.dp)
                        )
                        .border(
                            border = BorderStroke(1.dp, Black),
                            shape = RoundedCornerShape(42.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.clickable(onClick = {})
                        )
                        Box(
                            modifier = Modifier
                                .size(42.dp, 42.dp)
                                .background(
                                    color = Sun,
                                    shape = RoundedCornerShape(42.dp)
                                )
                                .border(
                                    border = BorderStroke(1.dp, Black),
                                    shape = RoundedCornerShape(42.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "0",
                                style = MaterialTheme.typography.h1,
                                color = Black
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.minus),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.clickable(onClick = {})
                        )
                    }
                }
            }
        }
    }
}
