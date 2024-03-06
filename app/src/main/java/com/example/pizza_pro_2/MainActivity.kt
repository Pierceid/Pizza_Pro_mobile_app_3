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
import com.example.pizza_pro_2.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pizza_Pro_2_Theme {
                val painter = painterResource(id = R.drawable.neapolitan_pizza)
                val title = "Neapolitan pizza"
                val cost = "9.50 €"

                PizzaCard(
                    painter = painter,
                    contentDescription = "",
                    title = title,
                    cost = cost
                )
            }
        }
    }
}

@Composable
fun PizzaCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    cost: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Black),
        elevation = 15.dp
    ) {
        Box(modifier = Modifier.height(140.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.horizontalGradient(colors = listOf(Grey, Ashen)))
            )
            Image(
                modifier = Modifier
                    .padding(10.dp)
                    .border(border = BorderStroke(1.dp, Black))
                    .clickable(true, onClick = { }),
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp, 5.dp, 10.dp, 10.dp)
                    .align(Alignment.TopEnd),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.clickable(true, onClick = { }),
                    text = title,
                    style = MaterialTheme.typography.h1,
                    color = Red
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
                            modifier = Modifier.clickable(true, onClick = { }),
                            painter = painterResource(id = R.drawable.plus),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
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
                            modifier = Modifier.clickable(true, onClick = { }),
                            painter = painterResource(id = R.drawable.minus),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )
                    }
                }
            }
        }
    }
}