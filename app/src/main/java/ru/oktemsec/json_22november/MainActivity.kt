package ru.oktemsec.json_22november

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val JsonSrcTV:TextView = findViewById(R.id.tv1)
        val JsonObjectTV:TextView = findViewById(R.id.tv2)
        val JsonResultTV:TextView = findViewById(R.id.tv3)
        val JsonMySiteTV:TextView = findViewById(R.id.tv4)
        val JsonUrlTV:TextView = findViewById(R.id.tv5)
        val JsonArrayTV:TextView = findViewById(R.id.tv6)

        val json_source:String = getString(R.string.simple_json)

        JsonSrcTV.text = json_source

        try {
            val jsonObject:JSONObject = JSONObject(json_source)
            val results:JSONObject = jsonObject.getJSONObject("results")
            val mySiteName = results.getString("sitename")
            val myUrl:String = results.getString("url")

            JsonObjectTV.text = "jsonObject:\n $jsonObject"
            JsonResultTV.text = "results:\n $results"
            JsonMySiteTV.text = "Имя сайта:\n $mySiteName"
            JsonUrlTV.text = "Адрес сайта:\n $myUrl"
            JsonArrayTV.text = "Developed by Abramov on kotlin"

            var stringArrayElement:String = "\n"
            val jsonArray:JSONArray = results.getJSONArray("array")
            for (i in 0 until jsonArray.length()) {
                val arrayElement:JSONObject = jsonArray.getJSONObject(i)
                stringArrayElement += arrayElement.getString("element\n")
            }
            Log.d("brearey", stringArrayElement)
        }
        catch (e:JSONException) {
            Log.d("brearey", e.message.toString())
        }
    }
}