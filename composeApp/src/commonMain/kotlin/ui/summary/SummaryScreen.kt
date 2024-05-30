package ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import theme.AppTheme

@Composable
fun SummaryScreen(
//    orderUiState: OrderUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text("Summary")
    }
}

@Preview
@Composable
fun OrderSummaryPreview() {
    AppTheme {
        SummaryScreen(
            modifier = Modifier.fillMaxHeight()
        )
    }
}
