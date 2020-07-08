package jp.kosuke.kinoshita.coroutinesapplication

import okhttp3.OkHttpClient

object HttpClient {
    val instance = OkHttpClient()
}