package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var data = intent.extras
        var model = data?.getParcelable<Model>("model")
        val cominglist = data?.getParcelableArrayList<Model>("arraylist")


//
//        if (cominglist != null) {
//            textView_stu.text = cominglist[0].text1 + " " + cominglist[0].text2
//        }

        var exlist : List<Model> = cominglist?.toList() as List<Model>
//
//        if (exlist != null) {
//            textView_stu.text = cominglist[0].text1 + " Just for check " + cominglist[0].text2
//        }




//        if (model != null) {
//            textView_stu.text = model.text1.toString() + " " + model.text2.toString()
//        }

        lateinit var recyclerView: RecyclerView

        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.adapter = SecondActivityAdapter(exlist)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)




    }







}