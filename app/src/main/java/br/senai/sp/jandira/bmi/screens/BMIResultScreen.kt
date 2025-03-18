package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun BMIResultScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF8BC34A),
                        Color(0xBE4CAF50)
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),

            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = stringResource(R.string.result_text),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(18.dp, 65.dp, 0.dp, 40.dp)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(750.dp),
                shape = RoundedCornerShape(32.dp, 32.dp)
            ) {

                Column(
                    modifier = Modifier
                        .padding(22.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Card(
                            shape = CircleShape,
                            modifier = Modifier
                                .size(120.dp),
                            border = BorderStroke(
                                7.dp,
                                color = Color(0xFFFF9800)
                            )

                        ) {

                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = "30,6",
                                    fontSize = 40.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Text(
                            text = stringResource(R.string.bmi_class),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,

                        )

                        Card (
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            colors = CardDefaults.cardColors(Color(0x19070707)),
                        ) {

                            Row (
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Column (
                                    modifier = Modifier
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.age),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = "50",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                VerticalDivider(
                                    thickness = 1.dp,
                                    color = Color.Gray
                                )

                                Column (
                                    modifier = Modifier
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.weight),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = "97 Kg",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                VerticalDivider(
                                    thickness = 1.dp,
                                    color = Color.Gray
                                )

                                Column (
                                    modifier = Modifier
                                        .weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = stringResource(R.string.height),
                                        fontSize = 22.sp
                                    )
                                    Text(
                                        text = "178 cm",
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }

                    Column (
                        modifier = Modifier
                            .weight(1f)
                    ) {

                    }

                    Column (
                        modifier = Modifier
                            .weight(1f)
                    ) {

                        HorizontalDivider(
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(bottom = 26.dp)
                        )

                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .padding(0.dp, 7.dp, 0.dp, 0.dp)
                                .fillMaxWidth()
                                .height(52.dp)
                        ) {

                            Text(
                                text = stringResource(R.string.new_calculation),
                                fontSize = 26.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen()
}