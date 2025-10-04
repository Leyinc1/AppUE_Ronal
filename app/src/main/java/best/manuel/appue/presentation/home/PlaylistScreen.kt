package best.manuel.appue.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import best.manuel.appue.presentation.auth.appBackground

// Lista de canciones y artistas predefinidos
private val songData = listOf(
    "Bohemian Rhapsody" to "Queen",
    "Stairway to Heaven" to "Led Zeppelin",
    "Hotel California" to "Eagles",
    "Like a Rolling Stone" to "Bob Dylan",
    "Smells Like Teen Spirit" to "Nirvana",
    "Imagine" to "John Lennon",
    "Billie Jean" to "Michael Jackson",
    "Hey Jude" to "The Beatles",
    "Sweet Child O' Mine" to "Guns N' Roses",
    "Wonderwall" to "Oasis",
    "No Woman, No Cry" to "Bob Marley & The Wailers",
    "Losing My Religion" to "R.E.M.",
    "Every Breath You Take" to "The Police",
    "Creep" to "Radiohead",
    "Take on Me" to "a-ha",
    "Africa" to "Toto",
    "Don't Stop Believin'" to "Journey",
    "With or Without You" to "U2",
    "Under the Bridge" to "Red Hot Chili Peppers",
    "Livin' on a Prayer" to "Bon Jovi"
)

@Composable
fun PlaylistScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(appBackground)
    ) {
        // 1. Encabezado Simple
        item {
            SimpleHeader()
        }

        // 2. Lista de Canciones Simple
        items(songData.size) { index ->
            val (title, artist) = songData[index]
            SimpleSongListItem(songNumber = index + 1, title = title, artist = artist)
            Divider(
                color = Color.DarkGray.copy(alpha = 0.4f),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        
        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SimpleHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder para la Portada
        Surface(
            modifier = Modifier.size(180.dp),
            color = Color.DarkGray,
            shape = MaterialTheme.shapes.medium
        ) {}
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = "Grandes Éxitos del Rock",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Las leyendas del rock en un solo lugar.",
            color = Color.Gray,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun SimpleSongListItem(songNumber: Int, title: String, artist: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = songNumber.toString(),
            color = Color.LightGray,
            modifier = Modifier.width(32.dp)
        )

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = artist,
                color = Color.Gray
            )
        }
    }
}