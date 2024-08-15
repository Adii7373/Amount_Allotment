package com.example.amtallotement

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.amtallotement.ui.theme.AmtAllotementTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            AmtAllotementTheme {
                VideoScreen()
                moving_next()

                }
            }
        }
    }



@Composable

fun  moving_next(modifier: Modifier = Modifier.padding(top = 25.dp)) {
    val context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(130.dp)
                .padding(top = 40.dp) // Add padding to the top
        ) {
            Box {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.searchll),
                    contentDescription = "Card background",
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Welcome in Amount Calculate App",
                    fontStyle = FontStyle.Italic,
                    color = Color.Blue,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(
                        top = 26.dp,
                        start = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp
                    )
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(28.dp))
@Composable
fun background_set()
{

    Image(painter = painterResource(id = R.drawable.searchlol), contentDescription =null )
}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 90.dp)
           ,

        verticalArrangement = Arrangement.Bottom ,
        horizontalAlignment = Alignment.CenterHorizontally
      
    ) {
        
        Spacer(modifier = Modifier.weight(1f))
        
        Spacer(modifier = Modifier.height(16.dp))
        
        
        Button( modifier = Modifier.padding(top = 40.dp) ,onClick = {
            Toast.makeText(context, "Welcome Fill The Info", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, Textifile::class.java)
            context.startActivity(intent)

        }) {

            Text(text = "Click On Next")
        }

    }
}