package com.example.fooddelivery

import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.ui.theme.BlackTextColor
import com.example.fooddelivery.ui.theme.CardItemBg
import com.example.fooddelivery.ui.theme.DividerColor
import com.example.fooddelivery.ui.theme.FoodDeliveryTheme
import com.example.fooddelivery.ui.theme.IconColor
import com.example.fooddelivery.ui.theme.Orange500
import com.example.fooddelivery.ui.theme.TextColor
import com.example.fooddelivery.ui.theme.Typography
import com.example.fooddelivery.ui.theme.Yellow200
import com.example.fooddelivery.ui.theme.Yellow500



object Destinations {
    const val Home = "Home"
    const val Detail = "Detail"

    object DetailArgs {
        const val foodData = "foodData"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {

               var navController = rememberNavController()

                NavHost(navController = navController, startDestination = Destinations.Home, builder = {

                    composable(Destinations.Home){
                        HomeScreen(navController = navController)
                    }

                    composable(Destinations.Detail){
                        DetailScreen(navController = navController)
                    }

                })

            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController){

    val scrollState = rememberScrollState()

    Box (modifier = Modifier
        .fillMaxSize()
        .padding(start = 30.dp, top = 48.dp, end = 17.dp)
    ){

        Column(
            modifier = Modifier.verticalScroll(state = scrollState)
        ) {
            Header()

            Spacer(modifier = Modifier.size(32.dp))

            OrderNowBox()

            Spacer(modifier = Modifier.size(30.dp))

            Text(
                text = "Categories",
                style = Typography.titleMedium,
                fontSize = 22.sp,
                color = BlackTextColor

                )

            Spacer(modifier = Modifier.size(20.dp))

            CategoryList(categories = listOf(
                CategoryData(redId = R.drawable.pizza, title = "Pizza"),
                CategoryData(redId = R.drawable.hamburger, title = "Burger"),
                CategoryData(redId = R.drawable.drinks, title = "Drinks")


            )

            )

            Spacer(modifier = Modifier.size(20.dp))

            Text(
                text = "Popular",
                style = Typography.titleMedium,
                fontSize = 22.sp,
                color = BlackTextColor

            )

            Spacer(modifier = Modifier.size(20.dp))

            PopularList(popularList = listOf(
                PopularData(
                    R.drawable.salad_pesto_pizza,
                    title = "Salad Pesto Pizza",
                    description = "A salad pesto pizza is a delicious pizza made with a pizza crust topped with fresh basil pesto, sliced tomatoes, and fresh mozzarella cheese",
                    price = 10.55,
                    calori = 540.0,
                    scheduleTime = 20.0,
                    rate = 5.0,
                    ingradients = listOf(
                        R.drawable.ing1,
                        R.drawable.ing2,
                        R.drawable.ing3,
                        R.drawable.ing4,
                        R.drawable.ing5
                    )
                ),
                PopularData(
                    R.drawable.primavera_pizza,
                    title = "Primavera Pizza",
                    description = "A salad pesto pizza is a delicious pizza made with a pizza crust topped with fresh basil pesto, sliced tomatoes, and fresh mozzarella cheese",
                    price = 12.55,
                    calori = 440.0,
                    scheduleTime = 30.0,
                    rate = 4.0,
                    ingradients = listOf(
                        R.drawable.ing1,
                        R.drawable.ing2,
                        R.drawable.ing3,
                        R.drawable.ing4,
                        R.drawable.ing5
                    )
                ),

                PopularData(
                    R.drawable.cheese_pizza,
                    title = "Cheese Pizza",
                    description = "A salad pesto pizza is a delicious pizza made with a pizza crust topped with fresh basil pesto, sliced tomatoes, and fresh mozzarella cheese",
                    price = 12.55,
                    calori = 440.0,
                    scheduleTime = 30.0,
                    rate = 4.0,
                    ingradients = listOf(
                        R.drawable.ing1,
                        R.drawable.ing2,
                        R.drawable.ing3,
                        R.drawable.ing4,
                        R.drawable.ing5
                    )
                )


            ),navController = navController
            )

        }

    }
}

@Composable
fun DetailScreen(navController: NavController){

    var count by remember { mutableStateOf(1) }
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(start = 30.dp, top = 48.dp, end = 30.dp)
    )
    {
        val data = navController.previousBackStackEntry?.arguments?.getParcelable<PopularData>(Destinations.DetailArgs.foodData)

        if (data != null){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {
                DetailsHeader(navController = navController)

                Spacer(modifier = Modifier.size(32.dp))

                Image(
                    painter = painterResource(id = data.resId),
                    contentDescription = "",
                    modifier = Modifier.size(275.dp)

                    )

                Spacer(modifier = Modifier.size(20.dp))

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                )
                    {
                        Column(verticalArrangement = Arrangement.SpaceBetween) {

                            Text(text = data.title,style = Typography.titleMedium,
                                fontSize = 22.sp,
                                color = BlackTextColor)

                            Row(verticalAlignment = Alignment.CenterVertically)
                            {
                                Text(
                                    text = "$",
                                    style = Typography.titleMedium,
                                    fontSize = 20.sp,
                                    color = Orange500
                                )

                                Text(
                                    text = "${data.price}",
                                    style = Typography.titleMedium,
                                    fontSize = 28.sp,
                                    color = BlackTextColor
                                )



                            }

                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(CardItemBg)
                                    .clickable { if (count > 1) count-- },
                                contentAlignment = Alignment.Center,

                            ) {
                                Text(text = "-", fontSize = 20.sp)
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Text(
                                text = String.format("%02d", count),
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.width(16.dp))

                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(color = Yellow500)
                                    .clickable { count++ },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "+", fontSize = 20.sp)
                            }


                        }
                }

                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text =  data.description,
                    style = Typography.titleMedium,
                    fontSize = 16.sp,
                    color = TextColor,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(20.dp))

               DetailBox(data = data)

                Spacer(modifier = Modifier.size(20.dp))

                Text(
                    text = "Ingradients",
                    style = Typography.titleMedium,
                    fontSize = 22.sp,
                    color = BlackTextColor,
                    modifier = Modifier.fillMaxWidth()

                )

                Spacer(modifier = Modifier.size(20.dp))

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    items(data.ingradients.size){
                      index ->   Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CardItemBg),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(painter = painterResource(id = data.ingradients[index]),
                            contentDescription = "",
                            modifier = Modifier.size(width = 30.dp, height = 24.dp)
                        )

                    }
                    }

                }


                Spacer(modifier = Modifier.size(20.dp))

                Box(
                    modifier = Modifier
                        .size(width = 203.dp, height = 56.dp)
                        .clickable {
                            Toast
                                .makeText(context, "Sepete Eklendi", Toast.LENGTH_LONG)
                                .show()
                        }
                        .clip(RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
                        .background(Yellow500),
                    contentAlignment = Alignment.Center

                ) {

                    Text(text = "Add to card", style = Typography.titleMedium, color = Color.White)
                }


            }


        }

    }

}

@Composable
fun Header(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp)

    ) {
        BoxWithRes(resId = R.drawable.menu, description = "Menu")

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = "Location",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "California, USA")
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_down),
                contentDescription = "Down",
                modifier = Modifier.size(16.dp),
                tint = Orange500
            )
        }

        BoxWithRes(resId = R.drawable.search, description = "Search")

    }

}

@Composable
fun DetailBox(data: PopularData){

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                CardItemBg
            )
            .padding(15.dp)
    ) {

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row {
                Image(
                    painter = painterResource(id = R.drawable.calori) ,
                    contentDescription = "Calori",
                    modifier = Modifier.size(20.dp)

                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.calori} kcal",
                    style = Typography.titleMedium,
                    fontSize = 16.sp,
                    color = BlackTextColor
                )
            }

            Divider(color = DividerColor, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))

            Row {

                Image(
                    painter = painterResource(id = R.drawable.star) ,
                    contentDescription = "Star",
                    modifier = Modifier.size(20.dp)

                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.rate}",
                    style = Typography.titleMedium,
                    fontSize = 16.sp,
                    color = BlackTextColor
                )
            }


            Divider(color = DividerColor, modifier = Modifier
                .fillMaxHeight()
                .width(1.dp))

            Row {

                Image(
                    painter = painterResource(id = R.drawable.schedule) ,
                    contentDescription = "Schedule",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "${data.scheduleTime}",
                    style = Typography.titleMedium,
                    fontSize = 16.sp,
                    color = BlackTextColor
                )

            }


        }

    }

}

@Composable
fun DetailsHeader(navController: NavController){

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()


    ) {
        BoxWithRes(resId = R.drawable.arrow_left, description = "Left",navController = navController)


        Box(modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(CardItemBg),
            contentAlignment = Alignment.Center
        ){
            Box(modifier = Modifier
                .size(24.dp)

            ){
                Icon(
                    painter = painterResource(id = R.drawable.bag),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp),
                    tint = IconColor


                )
                Box(
                    modifier = Modifier
                        .padding(top = 2.dp, end = 2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .align(Alignment.TopEnd), contentAlignment = Alignment.Center

                ) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(
                                Yellow500
                            )
                    )

                }
            }
        }
    }
}

@Composable
fun OrderNowBox(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(156.dp)
            .padding(end = 13.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                Yellow200
            )
            .padding(24.dp)
    )
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                Text(buildAnnotatedString {
                    withStyle(style = SpanStyle(color = BlackTextColor)){
                        append("The Fastest In\n"+
                                "Delevery"
                        )
                    }
                    withStyle(style = SpanStyle(color = Yellow500)){
                        append(" Food"
                        )
                    }

                })

                Box(modifier = Modifier
                    .size(width = 126.dp, height = 40.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(Yellow500), contentAlignment = Alignment.Center )
                {
                    Text(
                        text = "Order Now",
                        style = TextStyle.Default,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        fontSize = 14.sp

                    )
                }

            }
            Image(
                painter = painterResource(id = R.drawable.man),
                contentDescription ="Man",
                modifier = Modifier.size(156.dp)

            )

        }

    }

}

@Composable
fun BoxWithRes(
    resId: Int,
    description: String,
    bgColor: Color? = CardItemBg,
    iconColor: Color? = IconColor,
    boxSize: Int? = 40,
    iconSize: Int? = 24,
    navController: NavController? = null
){
    Box(

        modifier = Modifier
            .size(boxSize!!.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                navController?.popBackStack()
            }
            .background(bgColor!!),
        contentAlignment = Alignment.Center
    ){

        Icon(
            painter = painterResource(id = resId),
            contentDescription = description,
            modifier = Modifier.size(iconSize!!.dp),
            tint = iconColor!!

        )
    }



}
@Composable
fun CategoryList(categories: List<CategoryData>){
    val selectedIndex = remember {
        mutableStateOf(0)
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 13.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(categories.size) {
           index ->
            CategoryItem(
                categoryData = categories[index],
                selectedIndex = selectedIndex,
                index = index
            )
        }

    }

}

@Composable
fun CategoryItem(categoryData: CategoryData, selectedIndex: MutableState<Int>, index: Int){
    Box(
        modifier = Modifier
            .size(width = 106.dp, height = 146.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                selectedIndex.value = index
            }
            .background(
                if (selectedIndex.value == index) Yellow500 else CardItemBg
            ), contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = categoryData.redId),
                contentDescription = categoryData.title,
                modifier = Modifier.size(48.dp),
                tint = if (selectedIndex.value == index) Color.White else BlackTextColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = categoryData.title,
                style = Typography.titleMedium,
                fontSize = 18.sp,
                color = if (selectedIndex.value == index) Color.White else BlackTextColor

                )



        }

    }

}


@Composable
fun PopularList(popularList: List<PopularData>,navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        for(item in popularList){
            PopularItem(popularData = item,navController = navController)

        }

    }

}

@Composable
fun PopularItem(popularData: PopularData, navController: NavController){


   Column {
       Box(
           modifier = Modifier
               .fillMaxWidth()
               .height(176.dp)

       ) {
           Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .height(176.dp)
                   .padding(end = 13.dp)
                   .clip(RoundedCornerShape(18.dp))
                   .clickable {
                       navController.currentBackStackEntry?.arguments = Bundle().apply {
                           putParcelable(Destinations.DetailArgs.foodData, popularData)
                       }
                       navController.navigate(Destinations.Detail)


                   }
                   .background(
                       CardItemBg
                   )
           )

           Column(modifier = Modifier
               .padding(start = 20.dp, top = 13.dp)
           ) {
               Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Image(painter = painterResource(id = R.drawable.crown),
                           contentDescription = "Crown",
                           modifier = Modifier.size(24.dp)
                       )

                       Spacer(modifier = Modifier.width(11.dp))

                       Text(
                           text = "Best Selling",
                           style = Typography.titleMedium,
                           fontSize = 14.sp,
                           color = TextColor
                       )


                   }

               }

               Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                   Text(
                       text = popularData.title,
                       style = Typography.titleMedium,
                       fontSize = 19.sp,
                       color = BlackTextColor
                   )

               }

               Box(modifier = Modifier.height(40.dp), contentAlignment = Alignment.Center) {
                   Row(verticalAlignment = Alignment.CenterVertically)
                   {
                       Text(
                           text = "$",
                           style = Typography.titleMedium,
                           fontSize = 16.sp,
                           color = Orange500
                       )

                       Text(
                           text = "${popularData.price}",
                           style = Typography.titleMedium,
                           fontSize = 21.sp,
                           color = BlackTextColor
                       )



                   }

               }

           }

           Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .align(Alignment.BottomStart),


               ) {
               Row(verticalAlignment = Alignment.CenterVertically) {
                   Box(
                       modifier = Modifier
                           .size(width = 60.dp, height = 40.dp)
                           .clip(RoundedCornerShape(bottomStart = 18.dp, topEnd = 18.dp))
                           .background(Yellow500),
                       contentAlignment = Alignment.Center
                   ) {
                       Icon(
                           painter = painterResource(id = R.drawable.add),
                           contentDescription = "Add",
                           modifier = Modifier.size(24.dp),
                           tint = Color.White
                       )

                   }

                   Spacer(modifier = Modifier.width(48.dp))

                   Row(verticalAlignment = Alignment.CenterVertically) {
                       Icon(
                           painter = painterResource(id = R.drawable.star),
                           contentDescription = "Star",
                           modifier = Modifier.size(16.dp),
                           tint = BlackTextColor

                       )
                       Spacer(modifier = Modifier.width(8.dp))

                       Text(
                           text = "${popularData.rate}",
                           style = Typography.titleMedium,
                           color = BlackTextColor,
                           fontSize = 18.sp
                       )
                   }

               }

           }

           Image(painter = painterResource(id = popularData.resId),
               contentDescription = popularData.title,
               modifier = Modifier
                   .size(156.dp)
                   .align(
                       Alignment.CenterEnd
                   )
           )

       }

       Spacer(modifier = Modifier.height(20.dp))
   }

}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {

        val navController = rememberNavController()
        HomeScreen(navController = navController)

    }
}