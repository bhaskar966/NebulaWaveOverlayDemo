package com.beehomie.beewalls.util.shared_ui_components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * Displays an animated nebula-style wave overlay inspired by Gemini's "Circle to Search" effect.
 *
 * This overlay animates multiple glowing radial gradient blobs originating from all edges
 * of the screen. Each blob gently expands, fades toward the center, and moves in a slow,
 * circular orbit around the screen — creating a mesmerizing cosmic-like loading shimmer.
 *
 * Inspired by iOS Siri and Google's recent animated UI elements.
 *
 *
 * Usage:
 * ```
 * Box(modifier = Modifier.fillMaxSize()) {
 *     // Your background/content
 *     MagicalLoadingOverlay()
 * }
 * ```
 *
 * @param modifier [Modifier] to customize layout behavior (e.g., size, zIndex)
 * @param colors List of [Color] values to be animated as glowing blobs
 * @param alpha Opacity of the animated blobs (default is 0.5f)
 *
 * @author Bhaskar Dey (https://github.com/bhaskar966)
 * @since 2025-07-21
 */


@Composable
fun NebulaWaveOverlay(
    modifier: Modifier = Modifier,
    colors: List<Color> = listOf(
        Color(0xFFB388FF),                  // Soft Lavender
        Color(0xFF80DEEA),                  // Sky Blue Glow
        Color(0xFFFF80AB),                  // Pink Light
    Color(0xFFFFF59D)                       // Soft Yellow
    ),
    alpha: Float = 0.5f,                    // Opacity of blobs
    backgroundColor: Color = Color.Black,   // Background color of overlay
    backgroundAlpha: Float = 0.3f           // Opacity of background color
){

    // Infinite transition to drive continuous animation
    val transition = rememberInfiniteTransition(label = "NebulaWaveOverlay_animation")

    // Animate radius of each blob: 900 → 1200 → 900 → ...
    val radius by transition.animateFloat(
        initialValue = 900f,
        targetValue = 1200f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 5000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "radius"
    )

    // Animate a progress value from 0f to 1f that repeats forever
    val movementProgress by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 20000,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "movement_progress"
    )


    Canvas(
        modifier = modifier
            .fillMaxSize()
    ){

        val w = size.width
        val h = size.height

        // Base origin points for the color blobs (corners + edges)
        val basePoints = listOf(
            Offset(0f, 0f),            // Top-left
            Offset(w / 2f, 0f),        // Top-center
            Offset(w, 0f),             // Top-right
            Offset(w, h / 2f),         // Right-center
            Offset(w, h),              // Bottom-right
            Offset(w / 2f, h),         // Bottom-center
            Offset(0f, h),             // Bottom-left
            Offset(0f, h / 2f),        // Left-center
        )

        // Semi-transparent dark overlay
        drawRect(
            color = backgroundColor.copy(alpha = backgroundAlpha),
            size = size
        )

        // Animate each blob
        val animatedCenters = basePoints.mapIndexed { index, start ->
            // Stagger movement per blob: 1/8 offset each
            val localProgress = ((movementProgress + index * 0.125f) % 1f) * basePoints.size

            // Which segment are we in? (e.g., between point 2 and 3)
            val segmentIndex = localProgress.toInt()
            val segmentProgress = localProgress % 1f

            val form = basePoints[segmentIndex % basePoints.size]
            val to = basePoints[(segmentIndex + 1) % basePoints.size]

            // Smooth interpolation between two edge points
            lerp(
                start = form,
                stop = to,
                fraction = segmentProgress
            )
        }


        // Draw glowing blobs
        animatedCenters.forEachIndexed { i,  origin ->
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        colors[i % colors.size].copy(alpha = alpha),
                        colors[i % colors.size].copy(alpha = alpha/2),
                        colors[i % colors.size].copy(alpha = 0f)
                    ),
                    center = origin,
                    radius = radius,
                ),
                radius = radius,
                center = origin,
                blendMode = BlendMode.SrcOver
            )
        }

    }
}