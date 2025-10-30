package com.sarang.torang.di.report_di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.bottomsheet.share.ShareModalBottomSheet
import com.sarang.torang.compose.bottomsheet.share.components.LocalShareImageLoad
import com.sarang.torang.compose.report.ReportModal
import com.sarang.torang.di.bottomsheet_di.CustomShareImageLoader

fun provideReportModal(): @Composable (Int, onReported: () -> Unit) -> Unit =
    { reviewId, onReported ->
        ReportModal(
            reviewId = reviewId,
            profileServerUrl = BuildConfig.PROFILE_IMAGE_SERVER_URL,
            onReported = onReported
        )
    }

fun provideShareBottomSheetDialog(show : Boolean): @Composable (onClose: () -> Unit) -> Unit = {
    CompositionLocalProvider(LocalShareImageLoad provides CustomShareImageLoader) {
        ShareModalBottomSheet(
            isExpand = show,
            reviewId = 0,
            //onSelect = {},
            onClose = it
        )
    }
}
