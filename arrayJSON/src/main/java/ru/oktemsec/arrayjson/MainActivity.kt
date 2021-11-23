package ru.oktemsec.arrayjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)

        val rawJSON = "[{\"MemberID\":\"1\",\"Name\":\"Елена\",\"Tel\":\"4954876107\"}" + ",{\"MemberID\":\"2\",\"Name\":\"Сергей\",\"Tel\":\"4954780121\"}" + ",{\"MemberID\":\"3\",\"Name\":\"Витя\",\"Tel\":\"4954543211\"}]"

        try {
            val data: JSONArray = JSONArray(rawJSON)
            val arrayList:ArrayList<HashMap<String, String>> = ArrayList()

            for (i in 0 until data.length()) {
                val jsonObject:JSONObject = data.getJSONObject(i)
                val map = HashMap<String, String>()
                map["MemberID"] = jsonObject.getString("MemberID")
                map["Name"] = jsonObject.getString("Name")
                map["Tel"] = jsonObject.getString("Tel")

                arrayList.add(map)
            }
            val arrayStings:Array<String> = arrayOf("MemberID", "Name", "Tel")
            val arrayInt:IntArray = intArrayOf(R.id.item_textViewMemverId, R.id.item_textViewName, R.id.item_textViewNumber)
            val simpleAdapter:SimpleAdapter = SimpleAdapter(this, arrayList, R.layout.list_item, arrayStings, arrayInt)
            listView.adapter = simpleAdapter

        }
        catch (e: JSONException) {
            Log.d("brearey", e.message.toString())
        }
    }
}