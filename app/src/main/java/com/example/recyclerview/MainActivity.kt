package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import kotlin.random.Random

class MainActivity : AppCompatActivity(), DataAdapter.OnItemClickListener {

    val exampleList1 = generateDummyList(500)

    val adapter = DataAdapter(exampleList1, this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter = adapter

        btn3.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("model", Model(R.drawable.ic_baseline_ac_unit_24, "PK", "M"))
            intent.putParcelableArrayListExtra("arraylist", exampleList1 )

            startActivity(intent)

        }


    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: Model = exampleList1[position]
        clickedItem.text1 = "Clicked"
        adapter.notifyItemChanged(position)
    }


    fun insertItem(view: View) {
        val rndm = Random.nextInt(8)

        val newItem =
            Model(R.drawable.ic_baseline_ac_unit_24, "New Item at position $rndm", "Line 2")

        exampleList1.add(rndm, newItem)
//            adapter.notifyDataSetChanged()
        adapter.notifyItemInserted(rndm)

    }

    fun removeItem(view: View) {
        val rndm = Random.nextInt(8)

        exampleList1.removeAt(rndm)
        adapter.notifyItemRemoved(rndm)
    }

    private fun generateDummyList(size: Int): ArrayList<Model> {
        val list = ArrayList<Model>()

        for (i in 0..size) {
            val drawable: Int
            if (i % 2 == 0) {
                drawable = R.drawable.ic_baseline_ac_unit_24
            } else {
                drawable = R.drawable.ic_baseline_add_to_photos_24
            }

            val item = Model(drawable, "Line is $i", "Line 2")
            list.add(item)

        }

        return list
    }


}