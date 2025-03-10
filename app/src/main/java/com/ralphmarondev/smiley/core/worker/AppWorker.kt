package com.ralphmarondev.smiley.core.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ralphmarondev.smiley.core.notification.AppNotification

class AppWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val notificationHelper = AppNotification(applicationContext)
        notificationHelper.showNotification(
            title = "Reminder",
            message = "This is a reminder!"
        )
        return Result.success()
    }
}