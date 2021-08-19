package com.user.profileevalution

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.user.profileevalution.api.Client
import com.user.profileevalution.api.ClientInterface
import com.user.profileevalution.api.GlobalVariable
import com.user.profileevalution.utils.Function
import com.user.profileevalution.utils.Network
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

data class Article(val titleArticle:String, val datePublished:String)

class ViewArticle : AppCompatActivity() {
    private lateinit var bckBtn: AppCompatImageView
    private lateinit var listArrayArticle:MutableList<Article>
    private lateinit var listArticle:RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var client: ClientInterface
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_article)

        bckBtn = findViewById(R.id.bckBtn)
        bckBtn.setOnClickListener(View.OnClickListener {
            finish()
        })

        progressBar = findViewById(R.id.Progress)

        listArticle = findViewById(R.id.list_item)
        listArticle.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        listArticle.setHasFixedSize(true)

        when(intent.getStringExtra("text")){
            "mostView" ->{
                if (Network.isOnline(this)){
                    client = Client.getClient(GlobalVariable.baseUrl, GlobalVariable.timeOut)!!.create(ClientInterface::class.java)

                    val clientreq: Call<ResponseBody> = client.getMostView(GlobalVariable.keyApi)

                    clientreq.enqueue(object: Callback<ResponseBody>{
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            progressBar.visibility = View.GONE

                            if (response.code() == 200) {
                                val jsonObject = Gson().fromJson(
                                    response.body()!!.string(),
                                    JsonObject::class.java
                                )

                                var resultJsonArray = jsonObject["results"].asJsonArray

                                if (resultJsonArray.size() > 0){  // show list
                                    listArticle.visibility = View.VISIBLE

                                    listArrayArticle = arrayListOf()

                                    resultJsonArray.forEach {
                                        var titlePage =  it.asJsonObject["title"].asString
                                        var datePublish = it.asJsonObject["published_date"].asString

                                        listArrayArticle.add(Article(titlePage, datePublish))
                                    }

                                    // show adapter
                                    adapter = ArticleAdapter(listArrayArticle)
                                    listArticle.adapter = adapter
                                }else{  //hide list
                                    listArticle.visibility = View.GONE
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            progressBar.visibility = View.GONE

                            Toast.makeText(this@ViewArticle, "Connection lose", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })
                }
                else{
                    Toast.makeText(this, "Please open your internet connection", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }
            "mostShared"->{
                if (Network.isOnline(this)){
                    client = Client.getClient(GlobalVariable.baseUrl, GlobalVariable.timeOut)!!.create(ClientInterface::class.java)

                    val clientreq: Call<ResponseBody> = client.getMostShared(GlobalVariable.keyApi)

                    clientreq.enqueue(object: Callback<ResponseBody>{
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            progressBar.visibility = View.GONE

                            if (response.code() == 200) {
                                val jsonObject = Gson().fromJson(
                                    response.body()!!.string(),
                                    JsonObject::class.java
                                )

                                var resultJsonArray = jsonObject["results"].asJsonArray

                                if (resultJsonArray.size() > 0){  // show list
                                    listArticle.visibility = View.VISIBLE

                                    listArrayArticle = arrayListOf()

                                    resultJsonArray.forEach {
                                        var titlePage =  it.asJsonObject["title"].asString
                                        var datePublish = it.asJsonObject["published_date"].asString

                                        listArrayArticle.add(Article(titlePage, datePublish))
                                    }

                                    // show adapter
                                    adapter = ArticleAdapter(listArrayArticle)
                                    listArticle.adapter = adapter
                                }else{  //hide list
                                    listArticle.visibility = View.GONE
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            progressBar.visibility = View.GONE

                            Toast.makeText(this@ViewArticle, "Connection lose", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })
                }
                else{
                    Toast.makeText(this, "Please open your internet connection", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }
            "mostEmail" ->{
                if (Network.isOnline(this)){
                    client = Client.getClient(GlobalVariable.baseUrl, GlobalVariable.timeOut)!!.create(ClientInterface::class.java)

                    val clientreq: Call<ResponseBody> = client.getMostEmailed(GlobalVariable.keyApi)

                    clientreq.enqueue(object: Callback<ResponseBody>{
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            progressBar.visibility = View.GONE

                            if (response.code() == 200) {
                                val jsonObject = Gson().fromJson(
                                    response.body()!!.string(),
                                    JsonObject::class.java
                                )

                                var resultJsonArray = jsonObject["results"].asJsonArray

                                if (resultJsonArray.size() > 0){  // show list
                                    listArticle.visibility = View.VISIBLE

                                    listArrayArticle = arrayListOf()

                                    resultJsonArray.forEach {
                                        var titlePage =  it.asJsonObject["title"].asString
                                        var datePublish = it.asJsonObject["published_date"].asString

                                        listArrayArticle.add(Article(titlePage, datePublish))
                                    }

                                    // show adapter
                                    adapter = ArticleAdapter(listArrayArticle)
                                    listArticle.adapter = adapter
                                }else{  //hide list
                                    listArticle.visibility = View.GONE
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            progressBar.visibility = View.GONE

                            Toast.makeText(this@ViewArticle, "Connection lose", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })
                }
                else{
                    Toast.makeText(this, "Please open your internet connection", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }
            else ->{
                if (Network.isOnline(this)){
                    client = Client.getClient(GlobalVariable.baseUrl2, GlobalVariable.timeOut)!!.create(ClientInterface::class.java)

                    val clientreq: Call<ResponseBody> = client.getSearchArticle(intent.getStringExtra("text").toString(), GlobalVariable.keyApi)

                    clientreq.enqueue(object: Callback<ResponseBody>{
                        override fun onResponse(
                            call: Call<ResponseBody>,
                            response: Response<ResponseBody>
                        ) {
                            progressBar.visibility = View.GONE

                            if (response.code() == 200) {
                                val jsonObject = Gson().fromJson(
                                    response.body()!!.string(),
                                    JsonObject::class.java
                                )

                                var response = jsonObject["response"].asJsonObject

                                var resultJsonArray = response.asJsonObject["docs"].asJsonArray

                                if (resultJsonArray.size() > 0){  // show list
                                    listArticle.visibility = View.VISIBLE

                                    listArrayArticle = arrayListOf()

                                    resultJsonArray.forEach {
                                        var headline = it.asJsonObject["headline"]
                                        var titlePage =  headline.asJsonObject["main"].asString
                                        var datePublish = it.asJsonObject["pub_date"].asString

                                        listArrayArticle.add(Article(titlePage, Function.getTime(datePublish)))
                                    }

                                    // show adapter
                                    adapter = ArticleAdapter(listArrayArticle)
                                    listArticle.adapter = adapter
                                }
                                else{  //hide list
                                    listArticle.visibility = View.GONE
                                }
                            }
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            progressBar.visibility = View.GONE

                            Toast.makeText(this@ViewArticle, "Connection lose", Toast.LENGTH_SHORT)
                                .show()
                        }

                    })
                }
                else{
                    Toast.makeText(this, "Please open your internet connection", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = View.GONE
                }
            }
        }
    }
}
class ArticleAdapter(var listArticle:MutableList<Article>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: AppCompatTextView = itemView.findViewById(R.id.title1)
        var datetxt: AppCompatTextView = itemView.findViewById(R.id.date)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewArticle = holder as ArticleViewHolder

        viewArticle.title.text = listArticle[position].titleArticle
        viewArticle.datetxt.text = listArticle[position].datePublished
    }

    override fun getItemCount(): Int {
        return listArticle.size
    }
}