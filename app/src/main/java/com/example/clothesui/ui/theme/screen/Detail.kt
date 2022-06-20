package com.example.clothesui.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clothesui.R
import com.example.clothesui.ui.theme.*

@Composable
fun DetailScreen() {
    Box(modifier= Modifier
        .background(WhiteBackground))
    {
        Column{
            ModelPreview()
            SellerProfile()
            ClothesDesc()
            ClothesCheckout(listOf(
                "S","M","L","XL"
            ))
        }
    }
}
@Composable
fun ModelPreview(){

    var selectedItemIndex by remember {
        mutableStateOf(0)
    }

Box(modifier =Modifier.padding(horizontal = 20.dp,vertical = 20.dp))
{
    Box(
        modifier = Modifier
            .background(detailImage, RoundedCornerShape(30.dp))
            .width(350.dp)
            .height(300.dp)
            .padding(vertical = 10.dp, horizontal = 15.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 5.dp)
        )
        {
            Image(
                painterResource(id = R.drawable.arrow_left), contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .offset(x = 5.dp)
                    .clickable {
                    }
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Image(
                    painterResource(id = R.drawable.filled_hert), contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .offset(x = -(15).dp, y = 6.dp)
                        .clickable {
                            selectedItemIndex = 1
                        },
//                if(selectedItemIndex==1) {
//                    Modifier = Modifier.background(Color.White)
//                }
                 )


                Image(
                    painterResource(id = R.drawable.cart_detail), contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = -(10).dp, y = (-7).dp)
                        .clickable {

                        }
                )
            }
        }
        Image(
            painterResource(id = R.drawable.model_3), contentDescription = null, modifier
            = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize()
        )
        {
            ModelRoundPicture(item = R.drawable.model_piece_1)
            ModelRoundPicture(item = R.drawable.model_piece_2)
            ModelRoundPicture(item = R.drawable.model_piece_3)
            }

        }
    }
}

@Composable
fun ModelRoundPicture(item:Int,modifier: Modifier =Modifier){
    Box(contentAlignment = Alignment.Center,
        modifier= modifier
            .background(ModelRoundBackground, RoundedCornerShape(50))
            .size(50.dp)){
         Image(painterResource(id =item),contentDescription = null,
             modifier= Modifier
                 .size(40.dp)
                 .clip(CircleShape)
                 .clickable {

                 })
    }
}

@Composable
fun SellerProfile(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp)
    )
    {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color(0xFFB8BDFF), CircleShape)
                .size(50.dp)
        ) {
            Text(
                "U", color = Color.White, fontFamily = openSans, fontWeight = FontWeight(600),
                fontSize = 20.sp
            )
        }
        Column(modifier = Modifier.padding(start = 0.dp, top = 0.dp, end = 60.dp)) {


            Text("Ucito apparel", style = MaterialTheme.typography.h1,
                color = Color(0XFF595576), fontWeight = FontWeight.W800, fontSize = 17.sp,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .clickable {}
            )
            Text(
                "Official Store", style = MaterialTheme.typography.body1, color =
                Color(0XFFB8B4C5), fontWeight = FontWeight(600), fontSize = 15.sp,
                modifier = Modifier.padding(top = 3.dp)
            )
        }
        Box(contentAlignment = Alignment.Center, modifier = Modifier.offset(x = 0.dp, y = 7.dp)) {

            Box(contentAlignment = Alignment.Center, modifier = Modifier
                .clip(CircleShape)
                .border(3.dp, Color(0xFFB1E3C0), CircleShape)
                .width(100.dp)
                .height(37.dp)
                .clickable {
                }) {
                Row {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(Color(0xFFB1E3C0), RoundedCornerShape(30.dp))
                            .size(20.dp)
                    ) {
                        Icon(
                            painterResource(id = R.drawable.ic_baseline_check_24),
                            contentDescription = null,
                            Modifier.size(13.dp)
                        )
                    }
                    Text(
                        "Following",
                        style = MaterialTheme.typography.h1,
                        color = Color(0xFFB1E3C0),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W800,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }
        }
    }
}
@Composable
fun ClothesDesc() {

    Column(
        modifier= Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 17.dp)
    )
    {
        Text(
            "Saype blue knits sweater maupe", style = MaterialTheme.typography.h1,
            color = Color(0xFF464166), modifier = Modifier.width(250.dp),
            fontSize = 22.sp
        )
        Text(
            "Clothing that is very comfortable to use for daily activities and is not " +
                    "hot.",
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight(600),
            fontSize = 15.sp,
            modifier = Modifier
                .width(400.dp)
                .padding(top = 10.dp),
            color = Color(0xFFC7C3D0)
        )
            Text(
                "Read More", style = MaterialTheme.typography.body1, fontSize = 14.sp, color
                = Color(0xFFFCCEA2), modifier = Modifier
                    .offset(x = 173.dp, y = -(19.3.dp))
                    .clickable {}, fontWeight =
                FontWeight(700)
            )
        }
    }
@Composable
fun  ClothesCheckout(items:List<String>){

    var selectedSizeIndex by remember {
        mutableStateOf(1)
    }
    Column(modifier= Modifier
        .padding(horizontal = 20.dp))
    {

        Text("Select Size",fontFamily=openSans,fontWeight = FontWeight(700),color
        = Color (0xFF3E385F),fontSize = 16.sp)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(5.dp),modifier=Modifier.
                    padding(top=10.dp)
        ) {
            items(items.size) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .clickable {
                        selectedSizeIndex = it
                    }
                    .background(
                        if (selectedSizeIndex == it) Color(0xFFFBBD82) else

                            Color.White, CircleShape
                    )
                    .size(40.dp)
                    .border(
                        width = if (selectedSizeIndex == it) 0.dp else 2.dp,
                        Color(0xFFE6E4EB),
                        CircleShape
                    ))
                {
                    Text(
                        text = items[it], color = if (selectedSizeIndex == it) Color.White
                        else Color(0xFF75728C), fontSize = 12.sp, fontWeight = FontWeight(800)
                    )
                }
            }
        }

        Card(
            backgroundColor = Color(0xFF434AB8),
            shape = RoundedCornerShape(30.dp), modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp)
                .height(55.dp)
                .clickable {
                }
        )
        {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "$140.00", fontFamily = openSans, fontSize = 14.sp, color =
                    Color.White, fontWeight = FontWeight(600), modifier = Modifier.padding(
                        top = 0.dp,
                        start = 25.dp
                    )
                )
                Box(modifier = Modifier.padding(start = 20.dp))
                {
                    Box(
                        modifier = Modifier
                            .width(1.dp)
                            .height(17.dp)
                            .background(Color(0xFF8289E9))
                            .padding(start = 0.dp)
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Add to cart", fontFamily = openSans, fontWeight = FontWeight(500),
                    fontSize = 14.sp, color = Color.White, textAlign = TextAlign.Start,
                    modifier = Modifier.padding(top = 0.dp, start = 50.dp)
                )
            }
        }
    }
}