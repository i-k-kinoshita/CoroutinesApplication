package jp.kosuke.kinoshita.coroutinesapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.eclipsesource.json.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val URL = "http://weather.livedoor.com/forecast/webservice/json/v1?city=400040"
    var result = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getButton = findViewById<Button>(R.id.button)
        getButton.setOnClickListener { onParallelGetButtonClick() }
    }

    private fun onParallelGetButtonClick() = GlobalScope.launch(Dispatchers.Main) {
        val http = HttpUtil()
        withContext(Dispatchers.Default) { http.httpGet(URL) }.let {
            val result = Json.parse(it).asObject()
            val textView = findViewById<TextView>(R.id.text)
            textView.text = result.get("description").asObject().get("text").asString()

        }     }
    }
