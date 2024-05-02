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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kz.edu.sdu.income.R
import kz.edu.sdu.income.ui.theme.IncomeTheme

class PayCheckScreen() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncomeTheme {
                Surface {
                    PayCheckApp()
                }
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun PayCheckApp() {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF0E3E3E),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    ),
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
                        text = "Paycheck",
                        fontSize = 40.sp,
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.padding(top = 35.dp))
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                PayCheckRow(20, 100, "Gross Paycheck")
                Spacer(modifier = Modifier.padding(top = 30.dp))
                PayCheckRow(0, 140, "Federal Tax")
                PayCheckRow(15, 160, "State Tax")
                PayCheckRow(15, 169, "Tips Tax")
                PayCheckRow(15, 119, "Food Expense")
                PayCheckRow(15, 207, "Rent")
                Spacer(modifier = Modifier.padding(top=50.dp))
                PayCheckRow(15, 120, "Net Paycheck")


            }




            Spacer(modifier = Modifier.padding(top=80.dp))
            Row() {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(90.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0E3E3E)
                    ),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),

                    ) {
                    Text(
                        text = "Print",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Spacer(modifier = Modifier.padding(end=90.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(90.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0E3E3E)
                    ),
                    shape = RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    ),

                    ) {
                    Text(
                        text = "Draft",
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }

    @Composable
    fun PayCheckRow(
         top : Int,
         start : Int,
         text : String
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = top.dp)
        ){
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp)
            )

            Text(
                text="915.00",
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = start.dp)
            )
        }
        Spacer(modifier = Modifier.padding(top=10.dp))
        Image(
            painter = painterResource(id = R.drawable.bottom_rectanglee),
            contentDescription = "",
            modifier = Modifier
                .width(357.dp)
                .height(1.dp)
                .padding(start = 30.dp)
        )
    }
}