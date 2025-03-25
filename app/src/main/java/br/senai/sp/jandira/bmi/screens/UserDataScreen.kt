package br.senai.sp.jandira.bmi.screens


import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(navController: NavHostController?) {

    val ageState = remember {
        mutableStateOf(value = "")
    }

    val weightState = remember {
        mutableStateOf(value = "")
    }

    val heightState = remember {
        mutableStateOf(value = "")
    }

    val isErrorState = remember {
        mutableStateOf(value = false)
    }

    val errorMessageState = remember {
        mutableStateOf(value = "")
    }

    // Abrir o arquivo usuario.xml
    // para recuperar o nome que o usuário digitou
    // na tela anterior
    val context = LocalContext.current
    val sharedUserFile = context
        .getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val userName = sharedUserFile.getString("user_name", "Name not found")

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
        Column (
            modifier = Modifier
                .fillMaxSize(),

            verticalArrangement = Arrangement.Bottom
        ){

            Text(
                text = stringResource(R.string.hi_text) + " ${userName}!" ,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(30.dp, 65.dp, 0.dp, 40.dp)
            )

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(705.dp),
                shape = RoundedCornerShape(40.dp, 40.dp)
            ){

                Column (
                    modifier = Modifier
                        .padding(32.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.SpaceEvenly

                ){

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){

                        Column (
                            modifier = Modifier
                                .weight((1f)),
                            horizontalAlignment = Alignment.CenterHorizontally,

                        ){

                            Card (
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(120.dp),
                                border = BorderStroke(
                                    3.dp,
                                    brush = Brush.linearGradient(
                                            listOf(
                                                Color(0xFF497CA3),
                                                Color(0xFFC4D9F5)
                                            )
                                    )
                                )
                            ){

                                Image(
                                    painter = painterResource(id = R.drawable.man_icon),
                                    contentDescription = stringResource(R.string.logo_description),
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }

                            Button(

                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = Color(
                                    0xFF497BA2
                                )
                                ),
                                shape = RoundedCornerShape(60.dp),
                                modifier = Modifier
                                    .padding(0.dp, 7.dp, 0.dp, 0.dp)
                                    .width(130.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.if_male),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )

                            }
                        }

                        Column (
                            modifier = Modifier
                                .weight((1f)),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Card (
                                shape = CircleShape,
                                modifier = Modifier
                                    .size(120.dp),
                                border = BorderStroke(
                                    3.dp,
                                    brush = Brush.linearGradient(
                                        listOf(
                                            Color(0xFFE0B410),
                                            Color(0xFFE44A65)
                                        )
                                    )
                                )
                            ){

                                Image(
                                    painter = painterResource(id = R.drawable.woman_icon),
                                    contentDescription = stringResource(R.string.logo_description),
                                    modifier = Modifier
                                        .fillMaxSize()
                                )
                            }

                            Button(

                                onClick = {},
                                colors = ButtonDefaults.buttonColors(containerColor = Color(
                                    0xFFE0B410
                                )
                                ),
                                shape = RoundedCornerShape(60.dp),
                                modifier = Modifier
                                    .padding(0.dp, 7.dp, 0.dp, 0.dp)
                                    .width(130.dp)
                            ) {
                                Text(
                                    text = stringResource(R.string.if_female),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Column (
                        modifier = Modifier
                            .height(300.dp),
                        verticalArrangement = Arrangement.SpaceEvenly
                    ){

                        OutlinedTextField(
                            value = ageState.value,
                            onValueChange = {
                                ageState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.age)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Numbers,
                                    contentDescription = "",
                                    tint = Color(0xFF4CAF50)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = Color(0xFF4CAF50),
                                unfocusedLabelColor = Color(0xFF4CAF50)
                            )
                        )
                        OutlinedTextField(
                            value = weightState.value,
                            onValueChange = {
                                weightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.weight)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = Color(0xFF4CAF50)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = Color(0xFF4CAF50),
                                unfocusedLabelColor = Color(0xFF4CAF50)
                            )
                        )
                        OutlinedTextField(
                            value = heightState.value,
                            onValueChange = {
                                heightState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(16.dp),
                            label = {
                                Text(
                                    text = stringResource(R.string.height)
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = Color(0xFF4CAF50)
                                )
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Next
                            ),
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = Color(0xFF4CAF50),
                                unfocusedLabelColor = Color(0xFF4CAF50)
                            ),
                            isError = isErrorState.value,
                            supportingText = {
                                Text(
                                    text = errorMessageState.value,
                                    color = Color.Red
                                )
                            }
                        )


                    }

                    Button(
                        onClick = {

                            if (ageState.value.isBlank()) {
                                isErrorState.value = true
                                errorMessageState.value = context.getString(R.string.support_age)

                            } else if (weightState.value.isBlank()) {
                                isErrorState.value = true
                                errorMessageState.value = context.getString(R.string.support_weight)

                            } else if (heightState.value.isBlank()) {
                                isErrorState.value = true
                                errorMessageState.value = context.getString(R.string.support_height)

                            } else{
                                isErrorState.value = false
                                errorMessageState.value = ""
                                navController?.navigate("result_screen")

                                val editor = sharedUserFile.edit()
                                editor.putInt("user_age", ageState.value.trim().toInt())
                                editor.putInt("user_height", heightState.value.trim().toInt())
                                editor.putInt("user_weight", weightState.value.trim().toInt())
                                editor.apply()

                                navController?.navigate("result_screen")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(0.dp, 7.dp, 0.dp, 0.dp)
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen(null)
}