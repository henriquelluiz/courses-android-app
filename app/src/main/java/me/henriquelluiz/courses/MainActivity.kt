package me.henriquelluiz.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.henriquelluiz.courses.data.DataSource
import me.henriquelluiz.courses.model.Topic
import me.henriquelluiz.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    CourseApp()
                }
            }
        }
    }
}

@Composable
fun CourseApp() {
    CourseGrid(listOfTopics = DataSource.topics)
}

@Composable
fun CourseGrid(listOfTopics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(listOfTopics) { CourseCard(it, Modifier.padding(8.dp)) }
    }
}

@Composable
fun CourseCard(topic: Topic, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.secondary,
                RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(68.dp)
        ) {
            Image(
                painter = painterResource(topic.image),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp)
                    .clip(RoundedCornerShape(8.dp, 0.dp, 0.dp, 8.dp))

            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp,
                    top = 16.dp
                )
            ) {
                Text(
                    text = stringResource(topic.name),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(topic.grainIcon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.items.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    CourseApp()
}
