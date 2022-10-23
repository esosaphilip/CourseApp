package com.esosaphilip.courseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Grain
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esosaphilip.courseapp.data.DataSource
import com.esosaphilip.courseapp.model.Topic
import com.esosaphilip.courseapp.ui.theme.CourseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CourseGrid()
                }
            }
        }
    }
}
@Composable
fun CourseGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(DataSource.topics) { topic ->
            GridItem(topic)
        }
    }
}




@Composable
fun GridItem(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier = Modifier.padding(8.dp), elevation = 4.dp ) {

        Row() {
            Box {
                Image(
                    painter = painterResource(topic.imageResourceId),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop
                )
            }
            Column() {
                Text(text =  stringResource(topic.stringResourceId),
                    style = MaterialTheme.typography.body2,
                   modifier = Modifier.
                   padding(
                       start = 16.dp,
                       top = 16.dp,
                       end = 16.dp,
                       bottom = 8.dp
                   )
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Grain,
                        contentDescription = null,
                        Modifier.size(width = 25.dp,
                            height = 45.dp)
                         )
                    Text(text = topic.numAssociated.toString(),
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.padding(start = 8.dp, top = 8.dp))

                }
            }
        }


    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CourseAppTheme {
        GridItem(Topic(R.string.culinary,118 ,R.drawable.culinary))
    }
}