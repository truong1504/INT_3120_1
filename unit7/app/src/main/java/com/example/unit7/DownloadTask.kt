package com.example.unit7

import android.os.AsyncTask

class DownloadTask(
    private val onProgress: (Int) -> Unit,
    private val onFinish: () -> Unit
) : AsyncTask<Void, Int, Unit>() {

    override fun doInBackground(vararg params: Void?) {
        for (i in 1..10) {
            Thread.sleep(300) // mô phỏng tải file
            publishProgress(i * 10)
        }
    }

    override fun onProgressUpdate(vararg values: Int?) {
        values.firstOrNull()?.let { onProgress(it) }
    }

    override fun onPostExecute(result: Unit?) {
        onFinish()
    }
}
