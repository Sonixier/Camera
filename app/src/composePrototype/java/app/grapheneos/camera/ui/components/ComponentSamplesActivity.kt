package app.grapheneos.camera.ui.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import app.grapheneos.camera.ui.components.adjustmentbar.AdjustmentBarSample
import app.grapheneos.camera.ui.components.capturebutton.CaptureButtonSample
import app.grapheneos.camera.ui.components.countdowntimer.CountDownTimerSample
import app.grapheneos.camera.ui.core.CameraPreviewTheme

private val SAMPLES = listOf("Capture button", "Countdown", "Adjustment bar")

/** Shows the Compose component samples on a device, for the prototype build only. */
class ComponentSamplesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            var selected by rememberSaveable { mutableIntStateOf(0) }
            CameraPreviewTheme(modifier = Modifier.fillMaxSize()) {
                Column(modifier = Modifier.safeDrawingPadding()) {
                    PrimaryTabRow(selectedTabIndex = selected) {
                        SAMPLES.forEachIndexed { index, title ->
                            Tab(
                                selected = selected == index,
                                onClick = { selected = index },
                                text = { Text(text = title) },
                            )
                        }
                    }
                    when (selected) {
                        0 -> CaptureButtonSample()
                        1 -> CountDownTimerSample()
                        else -> AdjustmentBarSample()
                    }
                }
            }
        }
    }
}
