package com.example.clothesui.ui.theme.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clothesui.Categories
import com.example.clothesui.Clothes
import com.example.clothesui.R
import com.example.clothesui.ui.theme.*


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBackground)
    )
    {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            )
            {
                Image(
                    painterResource(id = R.drawable.menu), contentDescription = null,
                    modifier = Modifier
                        .padding(start = 25.dp, top = 30.dp)
                        .width(30.dp)
                        .height(30.dp)
                        .clickable {}
                )

                Image(
                    painterResource(id = R.drawable.cart), contentDescription = null,
                    modifier = Modifier
                        .padding(end = 25.dp, top = 30.dp)
                        .width(30.dp)
                        .height(30.dp)
                        .clickable {}
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(horizontal = 25.dp, vertical = 25.dp)
                    .background(BlueSearchBackground, RoundedCornerShape(20.dp))
            )
            {
                Column {
                    SearchBer()
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            )
            {
                Text(
                    "Categories", style = MaterialTheme.typography.h1, modifier = Modifier
                    ,color = CategoryText
                )
                Text(
                    "View all",
                    modifier = Modifier
                        .clickable {},
                    color = ViewText,
                    fontWeight = FontWeight.W500
                )
            }
            RowCategoryItems(items = listOf(
                Categories("Clothes", R.drawable.tshirt),
                Categories("Shoes",R.drawable.shoes),
                Categories("Bags",R.drawable.bags)

                ),modifier = Modifier
                .padding(horizontal = 15.dp)
                .offset(y = -(5).dp)
            )
            ClothesGrid(items = listOf(
                Clothes("Clothes 1","$140,00",R.drawable.model_1,175),
                Clothes("Clothes 2","$120,00",R.drawable.model_2,140),
                Clothes("Clothes 3","$220,00",R.drawable.model_3,140),
                Clothes("Clothes 4","$122,00",R.drawable.model_4,175)
            ))
        }
        BottomMenuItems(items =
        listOf(
            R.drawable.home,
            R.drawable.heart,
            R.drawable.bell,
            R.drawable.user
        ),
                modifier=Modifier.align(BottomCenter)
        )
    }
}
@Composable
fun CategoryItem(
    category: Categories,
    clickedCategory: Color = ClickedTextCategory,
    unClickedCategory : Color = UnClickedTextCategory,
    isSelected:Boolean = false,
    onItemClick:()->Unit
)
{
 Row(modifier = Modifier
     .clickable {
         onItemClick()
     }
     .padding(end = 10.dp)
 )
 {
    Box(
        modifier= Modifier
            .background(Color.White, RoundedCornerShape(30.dp))
            .width(110.dp)
            .height(40.dp),
        )
    {
        Box(
            contentAlignment= Alignment.Center,
            modifier= Modifier
                .background(CategoryRoundBox, RoundedCornerShape(50))
                .size(35.dp)
                .padding(5.dp)
        ){
            Image(painterResource(id =category.icon),contentDescription = null,
            Modifier.size(50.dp))
        }
        Text(text = category.title,color = if (isSelected) clickedCategory
        else unClickedCategory,fontSize = 15.sp ,modifier=Modifier.padding(start=45.dp
        ,top = 5.dp),style = MaterialTheme.typography.h1 ,fontWeight = FontWeight.W600)
    }
  }
}

@Composable
fun RowCategoryItems(
    items:List<Categories>,
    modifier :Modifier=Modifier,
    clickedCategory: Color = ClickedTextCategory,
    unClickedCategory : Color = UnClickedTextCategory,
    initialSelectedItemIndex:Int = 0,
){
    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier= modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .horizontalScroll(rememberScrollState())
    ){
    items.forEachIndexed { index, categories ->
        CategoryItem(
            category = categories,
            clickedCategory = clickedCategory,
            unClickedCategory = unClickedCategory,
            isSelected = index == selectedItemIndex
        )
        {
            selectedItemIndex = index
        }
       }
    }
}

@Composable
fun Clothes(items:Clothes){

    Column(
        modifier= Modifier
            .clickable {
            }
            .padding(start = 15.dp)

    ) {
        Box(contentAlignment=Center,
            modifier= Modifier
                .width(175.dp)
                .height(items.height.dp)
                .background(ModelBackground, RoundedCornerShape(20.dp)))
        {
            Image(
                painterResource(items.model), contentDescription = null, modifier = Modifier
                    .fillMaxSize()
            )
        }
        Text(
            text = items.title,
            style = MaterialTheme.typography.body1,
            color = Color(0xFF696481),
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight(500)
        )
        Text(
            text = items.price,
            style = MaterialTheme.typography.h1,
            color = TitlePrice,
            fontSize = 15.sp,
            modifier=Modifier.padding(top = 7.dp,bottom = 15.dp )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClothesGrid(items:List<Clothes>){
    Column(modifier=Modifier.fillMaxWidth())
    {
        Text(
            "New Arrivals",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(start = 25.dp, top = 2.dp, bottom = 18.dp),
            fontSize = 22.sp,
            color = ArrivalsText
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            modifier = Modifier
                .padding(start = 10.dp, end = 25.dp,top=5.dp,bottom = 70.dp)
        )
        {
            items(items.size) {
                Clothes(items[it])
            }
        }
    }
}

@Composable
fun SearchBer(){

    val (value, onValueChange) = remember { mutableStateOf("") }


    Text(
        "Find the best clothes for you", style = MaterialTheme.typography
            .h1, color = BlueText,fontSize = 20.sp,
        modifier = Modifier
            .padding(start = 15.dp, top = 20.dp)
            .width(150.dp),
        lineHeight = 33.sp
    )

    TextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 15.sp),
        leadingIcon = {
            Icon(
                painterResource(R.drawable.search), null, tint = Color(0xFFA39FA8),
                modifier = Modifier
                    .size(25.dp)
                    .offset(x = 5.dp)
                    .clickable {}
            )
        },
        modifier = Modifier
            .padding(top = 20.dp)
            .padding(horizontal = 15.dp)
            .fillMaxWidth()
            .height(55.dp)
            .background(Color(0xFFFFFFFF), RoundedCornerShape(30.dp)),
        placeholder = { Text(text = "Search your clothes", color = Color(0xFFA39FA8)
        ,fontSize = 17.sp,modifier = Modifier.padding(start = 2.dp))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = Color.DarkGray
        )
    )
}

@Composable
fun BottomMenuItems(
    items:List<Int>,
    modifier:Modifier=Modifier
) {
    var selectedItemIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 7.dp)
            .padding(bottom = 17.dp)
    )
    {
        items(items.size) {
            Box(
                contentAlignment = Center,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 25.dp, top = 15.dp, bottom = 0.dp, end = 25.dp)
                    .size(35.dp)
                    .clickable
                    {
                        selectedItemIndex = it
                    }
                    .clip(RoundedCornerShape(50.dp))
                    .background(
                        if (selectedItemIndex == it) BottomItemClicked
                        else Color.Transparent
                    )

            ) {
                Icon(
                    painterResource(id = items[it]),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp),
                    tint = if (selectedItemIndex == it) Color.White
                    else Color(
                        0xFFAFACBE
                    )
                )
            }
        }
    }
 }
