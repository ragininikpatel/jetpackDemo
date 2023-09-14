package com.example.jetpackdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(heightDp = 300)
@Composable
fun PreviewItem() {
    //  BlogCategory(img = R.drawable.ragini_img, title ="Ragini Patel" , subtitle = "Android App Developer")
    /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        getCatgList().map {item->
            BlogCategory(img = item.img, title = item.title, subtitle =item.subtitle )

        }
    }*/

    LazyColumn(content = {
        items(getCatgList()) { item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    })
}

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img), contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDesc(title, subtitle, Modifier.weight(.8f))
        }
    }
}

@Composable
fun ItemDesc(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.h6)
        Text(
            text = subtitle,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
    }
}

data class Category(val img: Int, val title: String, val subtitle: String)

fun getCatgList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))
    list.add(Category(R.drawable.ragini_img, "aaa", "aaaaaa"))

    return list
}