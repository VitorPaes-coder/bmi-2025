package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculator
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.isFilled
import br.senai.sp.jandira.bmi.utils.numberFormat
import java.util.Locale

@Composable
fun BMIResultScreen(navController: NavHostController?) {

    val context = LocalContext.current
    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val age= sharedUserFile.getInt(
        "user_age",
        0
    )
    val weight= sharedUserFile.getInt(
        "user_weight",
        0
    )
    val height= sharedUserFile.getInt(
        "user_height",
        0
    ).toDouble()

    val bmiResult = bmiCalculator(weight, height)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF8BC34A),
                        Color(0xBE13A618)
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
                shape = RoundedCornerShape(32.dp, 32.dp),
                colors = CardDefaults.cardColors(Color.White)
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
                                color = bmiResult.color
                            ),
                            colors = CardDefaults.cardColors(Color.White)

                        ) {

                            Column (
                                modifier = Modifier
                                    .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        "%.1f",
                                        bmiResult.bmi.second
                                    ),
                                    fontSize = 40.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        Text(
                            text = bmiResult.bmi.first,
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
                                    .fillMaxWidth()
                                    .height(60.dp),
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
                                        text = "$age y",
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
                                        text = "$weight Kg",
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
                                        text = String.format(
                                            Locale.getDefault(),
                                            "%.2f",
                                            height.div(100)
                                        ),
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }

                    BmiLevel(
                        markColor = colorResource(R.color.light_blue),
                        text1 = stringResource(R.string.under_weight_table),
                        text2 = "< ${numberFormat(18.5)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.UNDERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_green),
                        text1 = stringResource(R.string.normal_weight_table),
                        text2 = "${numberFormat(18.6)} - ${numberFormat(24.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.NORMAL)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.yellow),
                        text1 = stringResource(R.string.over_weight_table),
                        text2 = "${numberFormat(25.0)} - ${numberFormat(29.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OVERWEIGHT)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.light_orange),
                        text1 = stringResource(R.string.obesity1_table),
                        text2 = "${numberFormat(30.0)} - ${numberFormat(34.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY1)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.dark_orange),
                        text1 = stringResource(R.string.obesity2_table),
                        text2 = "${numberFormat(35.0)} - ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY2)
                    )
                    BmiLevel(
                        markColor = colorResource(R.color.red),
                        text1 = stringResource(R.string.obesity3_table),
                        text2 = "> ${numberFormat(39.9)}",
                        isFilled = isFilled(bmiResult.bmiStatus, BmiStatus.OBESITY3)
                    )

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

@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}