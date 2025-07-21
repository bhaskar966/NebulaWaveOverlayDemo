# 🌌 NebulaWaveOverlay – Magical Gradient Loading Animation

A beautiful Jetpack Compose animation inspired by Gemini's **Circle to Search** and iOS **Siri**.  
`NebulaWaveOverlay` creates radiant, glowing waves from all screen edges that slowly orbit and fade inward — perfect for loading states, splash screens, or magical overlays.

![nebula-demo](https://github.com/bhaskar966/NebulaWaveOverlayDemo/blob/master/NebulaWaveOverlay_demo_screenRecord%20-%20Made%20with%20Clipchamp.gif?raw=true)

---

## ✨ Features

- Animated gradient waves that radiate from all screen edges
- Smooth circular movement of glowing blobs
- Faded radial gradients for soft glow
- Customizable background, colors, and opacity
- 100% Jetpack Compose & performant

---

## 🚀 Usage

```kotlin
Box(modifier = Modifier.fillMaxSize()) {
    // Your background content here

    NebulaWaveOverlay()
}
```
---


## ⚙️ Parameters
| Parameter         | Type          | Default                   | Description                             |
| ----------------- | ------------- | ------------------------- | --------------------------------------- |
| `colors`          | `List<Color>` | Gradient oranges and reds | Colors used for the glowing wave blobs  |
| `alpha`           | `Float`       | `0.5f`                    | Opacity of the gradient blobs           |
| `backgroundColor` | `Color`       | `Color.Black`             | Background color behind the animation   |
| `backgroundAlpha` | `Float`       | `0.3f`                    | Background layer opacity for dimming    |
| `modifier`        | `Modifier`    | `Modifier`                | Modifier to style the overlay container |

---

## 🎨 Customization Tips
- Use blues, purples for sci-fi and calm themes
- Use warm tones (orange, pink) for lively effects
- Combine with loading state or navigation transitions
- Animate visibility with `AnimatedVisibility` or `LaunchedEffect`

---

## 📦 Installation

Copy the [`NebulaWaveOverlay.kt`](https://github.com/bhaskar966/NebulaWaveOverlayDemo/blob/master/app/src/main/java/com/beehomie/nebulawaveoverlaydemo/NebulaWaveOverlay.kt) composable into your Compose project.
Adding as a library or dependency will be available soon. 

- Star ⭐ the repo to stay updated!
---

## 📸 Demo
![nebula-demo](https://github.com/bhaskar966/NebulaWaveOverlayDemo/blob/master/NebulaWaveOverlay_Demo_Video%20-%20Made%20with%20Clipchamp.gif?raw=true)

## 💡 Inspiration

- 🔵 Gemini's Circle to Search ripple animation
- 🟣 iOS Siri's colorful waveform

## 🧑‍💻 Author

Made with ❤️ by Bhaskar Dey 

📧 deybhaskar999@gmail.com
