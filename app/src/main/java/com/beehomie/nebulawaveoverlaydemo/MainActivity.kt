package com.beehomie.nebulawaveoverlaydemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.beehomie.beewalls.util.shared_ui_components.NebulaWaveOverlay
import com.beehomie.nebulawaveoverlaydemo.ui.theme.NebulaWaveOverlayDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NebulaWaveOverlayDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageLayout(
    modifier: Modifier = Modifier
){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Image in Background",
            contentScale = ContentScale.Crop
        )
        NebulaWaveOverlay(
            alpha = 0.3f,
            backgroundAlpha = 0.2f
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageLayoutPreview() {
    NebulaWaveOverlayDemoTheme {
        ImageLayout()
    }
}