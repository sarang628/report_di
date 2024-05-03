package com.sarang.torang.di.report_di

import androidx.compose.runtime.Composable
import com.sarang.torang.BuildConfig
import com.sryang.torang.compose.bottomsheet.share.ShareBottomSheetDialog
import com.sryang.torang.compose.report.ReportModal

fun provideReportModal(): @Composable (Int, onReported: () -> Unit) -> Unit =
    { reviewId, onReported ->
        ReportModal(
            reviewId = reviewId,
            profileServerUrl = BuildConfig.PROFILE_IMAGE_SERVER_URL,
            onReported = onReported
        )
    }

fun provideShareBottomSheetDialog(): @Composable (onClose: () -> Unit) -> Unit = {
    ShareBottomSheetDialog(
        profileServerUrl = BuildConfig.PROFILE_IMAGE_SERVER_URL,
        isExpand = true,
        onSelect = {},
        onClose = it
    )
}
