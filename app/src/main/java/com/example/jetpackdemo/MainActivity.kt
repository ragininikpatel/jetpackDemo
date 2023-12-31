package com.example.jetpackdemo

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Magenta
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackdemo.api.tweestyApi
import com.example.jetpackdemo.screens.CategoryScreen
import com.example.jetpackdemo.screens.DetailScreen
import com.example.jetpackdemo.screens.QuoteDetail
import com.example.jetpackdemo.screens.QuoteListScreen
import com.example.jetpackdemo.ui.theme.JetpackDemoTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweestyApi: tweestyApi

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/*

        GlobalScope.launch {
            var response = tweestyApi.getCategories()
            Log.d("code", response.body()!!.distinct().toString())
        }
*/

        /* CoroutineScope(Dispatchers.IO).launch {
             delay(1000)
             DataManager.loadAssetsFromFile(applicationContext)
         }*/

        setContent {
            //Text(text = "Hi")
            // priviewFun()
            // TextInput()
            // CircularImg()
            // PreviewItem()
            // Recompsable()
            //  notification_screen()
            //  QuoteDetail()
            //App()

            // my_theme()
            // ListComposable()
            // Counter()

            //cntApp()
            //myState()

            //dicompose_app()
            // MediaComposable()
//            KeyboardComposable()
//            TextField(value = "", onValueChange = {})

            //Loader()
            //    Derived()
            JetpackDemoTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = {
                            Text(text = "Tweesty")
                        }, backgroundColor = Black, contentColor = White)
                    }) {
                    Box(modifier = Modifier.padding(it)) {
                        navCatg()
                    }
                }
                //  CategoryScreen()
                //  DetailScreen()
            }

        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
fun priviewFun() {

    //text
    /*Text(
        text = "Ragini Patel",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Red,
        fontSize = 26.sp,
        textAlign = TextAlign.Center
    )*/

    //image
    /*Image(painter = painterResource(id = R.drawable.ragini_img),
        contentDescription = "Dummy Image",
    )*/

    //button
    /*Button(onClick = { },
    colors = ButtonDefaults.buttonColors(
        contentColor = Red,
        backgroundColor = Cyan
    )) {
        Text(text = "Hello")
        Image(painter = painterResource(id = R.drawable.ragini_img), contentDescription ="aa" )
    }*/

    //textfield
    /*TextField(
        value = "Hello User", onValueChange = {},
        label = { Text(text = "Enter Message") },
    )*/

    //linear layout
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "A", fontSize = 24.sp)
//        Text(text = "B", fontSize = 24.sp)
//    }

    /*Row(
         horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
    }*/

    /*Column{
        ListViewItem(R.drawable.ragini_img,"Ragini Patel", "Application Developer")
        ListViewItem(R.drawable.ragini_img,"Ragini Patel", "Application Developer")
        ListViewItem(R.drawable.ragini_img,"Ragini Patel", "Application Developer")
        ListViewItem(R.drawable.ragini_img,"Ragini Patel", "Application Developer")

    }*/

    Text(text = "Hello",
        color = White,
        modifier = Modifier
            .background(Magenta)
            .size(200.dp)
            .padding(36.dp)
            .border(4.dp, Red)
            .clip(CircleShape)
            .background(Yellow)
            .clickable { })
}

@Composable
fun ListViewItem(id: Int, name: String, occupation: String, modifier: Modifier) {
    Row(modifier.padding(8.dp)) {
        Image(
            painter = painterResource(id = id),
            contentDescription = "", Modifier.size(40.dp)
        )
        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = occupation, fontWeight = FontWeight.Thin, fontSize = 12.sp)

        }
    }

}

@Composable
fun CircularImg() {
    Image(
        painter = painterResource(id = R.drawable.ragini_img),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, LightGray, CircleShape),
        contentDescription = ""
    )
}

@Composable
fun TextInput() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("my val :", it)
        },
        label = { Text(text = "Enter Message") },
    )
}

@Composable
fun Recompsable() {
    val state = remember {
        mutableStateOf(0.0)
    }
    Log.d("yag", "log during composition")
    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("tag", "log during both composition and decompostion")
        Text(text = state.value.toString())
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {

        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading..",
                style = MaterialTheme.typography.h6
            )
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}

@Preview
@Composable
fun DefaultPreview() {
    JetpackDemoTheme {
    }
}

//theme
@Composable
fun my_theme() {
    var theme = remember { mutableStateOf(false) }
    JetpackDemoTheme(theme.value) {
        Column(Modifier.background(MaterialTheme.colors.background)) {
            Text(
                text = "Hello Android Developer",
                style = MaterialTheme.typography.h1
            )

            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(text = "Change Theme")
            }
        }

    }
}

//side effect
var counter = 1

@Composable
fun HasSideEffect() {
    counter++
    Text(text = "Hiiii")
}

//list composable
@Composable
fun ListComposable() {
    val categoryState = remember {
        mutableStateOf(emptyList<String>())
    }

    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategories()
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }
}

fun fetchCategories(): List<String> {
    return listOf("one", "two", "three")
}

@Composable
fun Counter() {
    var count = remember {
        mutableStateOf(0)
    }

    var key = count.value % 3 == 0
    LaunchedEffect(key1 = key) {
        Log.d("Counter", "Current Count: ${count.value}")

    }
    Button(onClick = { count.value++ }) {
        Text(text = "Increment Count")

    }
}

//fun counter
@Composable
fun cntApp() {
    var counter = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.value = 10
    }

    Counter1(counter.value)
}

@Composable
fun Counter1(value: Int) {
    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("my code: ", state.toString())
    }
    Text(text = value.toString())
}

//change state
fun a() {
    Log.d("chhezy code", "I am A from App")
}

fun b() {
    Log.d("chhezy code", "I am B from App")
}

@Composable
fun myState() {
    val state = remember { mutableStateOf(::a) }
    Button(onClick = { state.value = ::b }) {
        Text(text = "Click to change state")
    }

    LandingScreen(state.value)
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)
    LaunchedEffect(key1 = true) {
        delay(5000)
        currentOnTimeout()
    }
}

//disposable
@Composable
fun dicompose_app() {
    var state = remember {
        mutableStateOf(false)
    }

    DisposableEffect(key1 = state.value) {
        Log.d("effect start", "Disposable effect started test");
        onDispose {
            Log.d("effect clean up", "Clining up side effect");

        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Change State")
    }
}

//media composable
@Composable
fun MediaComposable() {
    val context = LocalContext.current
    DisposableEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.happy_song)
        mediaPlayer.start()
        onDispose {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}

//keyboard available or not
@Composable
fun KeyboardComposable() {
    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("val..", isKeyboardVisible.toString())
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)

        }
    }
}

//product state for live data decompose
@Composable
fun Loader() {
    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(16)
            value = (value + 10) % 360
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f),
        content = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(degree.value.toFloat())
                )
                Text(text = "Loading")
            }
        })
}

//derive state of
@SuppressLint("UnrememberedMutableState")
@Composable
fun Derived() {
    val tableOf = remember { mutableStateOf(5) }
    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value += 1
        }
    }

    val message = derivedStateOf {
        "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}"
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
        Text(text = message.value, style = MaterialTheme.typography.h3)
    }
}

@ExperimentalFoundationApi
@Composable
fun navCatg() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen(onClick = {
                navController.navigate("detail/${it}")
            })
        }


        composable(

            route = "detail/{category}",
            arguments = listOf(navArgument("category") {
                type = NavType.StringType
            })
        ) {
            DetailScreen()
        }
    }
}