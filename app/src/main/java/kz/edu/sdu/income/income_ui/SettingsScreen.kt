package kz.edu.sdu.income.income_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

class SettingsScreen() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Surface {
                    SettingsApp()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun SettingsApp() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E3E3E)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.padding(top = 60.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.back_button),
                            contentDescription = "back button",
                            modifier = Modifier
                                .width(24.dp)
                                .height(24.dp)
                                .clickable {

                                }
                        )
                        Spacer(modifier = Modifier.padding(start = 150.dp, end = 164.dp))
                    }
                    Spacer(modifier = Modifier.padding(top = 30.dp))
                    Text(
                        text = "Payroll",
                        fontSize = 40.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Column(

                    ){
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "State",
                                fontSize = 20.sp,
                                color = Color(0xFFFFFFFF),
                                fontWeight = FontWeight.Normal,
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier
                            )
                            Spacer(modifier = Modifier.padding(start = 0.dp))
                            OutlinedTextField(
                                value = "Georgia",
                                onValueChange = { it },
                                textStyle = TextStyle(
                                    fontSize = 19.sp,
                                    textAlign = TextAlign.Start,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color(0xFF0E3E3E)
                                ),
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(50.dp),
                                singleLine = true,
                                colors = OutlinedTextFieldDefaults.colors(
                                    unfocusedBorderColor = Color(0x4D0E3E3E),
                                    focusedBorderColor = Color(0x990E3E3E)
                                ),
                                shape = RoundedCornerShape(
                                    topStart = 12.dp,
                                    topEnd = 12.dp,
                                    bottomStart = 12.dp,
                                    bottomEnd = 12.dp
                                ),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )
                        }

                    }
                }
            }
        }
    }
    @Composable
    fun PayrollRow(
        text : String,
    ){
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = text,
                fontSize = 20.sp,
                color = Color(0xFF000000),
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.padding(start = 27.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {if (it.isDigitsOnly()) it},
                textStyle = TextStyle(
                    fontSize = 19.sp,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF0E3E3E)
                ),
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0x4D0E3E3E),
                    focusedBorderColor = Color(0x990E3E3E)
                ),
                shape = RoundedCornerShape(
                    topStart = 12.dp,
                    topEnd = 12.dp,
                    bottomStart = 12.dp,
                    bottomEnd = 12.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}