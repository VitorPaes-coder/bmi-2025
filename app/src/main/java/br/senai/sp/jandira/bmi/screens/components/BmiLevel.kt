package br.senai.sp.jandira.bmi.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.bmi.R

@Composable
fun BmiLevel(
    markColor: Color = Color.Red,
    text1: String = "",
    text2: String = "",
    isFilled: Boolean = false
){

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp )
    ){

        Card (
            modifier = Modifier
                .size(20.dp),
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = markColor)
        ){}

        Spacer(modifier = Modifier.width(20.dp))

        Card (
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(
                containerColor = if(isFilled) markColor else Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        ){

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Text(
                    text = text1,
                    modifier = Modifier
                        .padding(8.dp)
                )

                Text(
                    text = text2,
                    modifier = Modifier
                        .padding(8.dp)
                )

            }
        }


    }
}

@Preview
@Composable
private fun BmiLevelPreview() {
    BmiLevel()
}
