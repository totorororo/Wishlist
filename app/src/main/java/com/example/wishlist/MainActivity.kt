package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val items = ArrayList<ListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.SubmitButton)

        val rvItems = findViewById<View>(R.id.rvWishlist) as RecyclerView
        val adapter = ListAdapter(items)
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.adapter = adapter

        button.setOnClickListener {

            it.hideKeyboard()

            val urlEdit = findViewById<EditText>(R.id.urlText)
            val itemEdit = findViewById<EditText>(R.id.ItemText)
            val amountEdit = findViewById<EditText>(R.id.PriceText)

            val textUrl = urlEdit.text.toString()
            val textItem = itemEdit.text.toString()
            val textAmount = amountEdit.text.toString()
            items.add(ListItem(textItem, textAmount, textUrl))

            adapter.notifyItemInserted(items.size-1)

            urlEdit.text.clear()
            itemEdit.text.clear()
            amountEdit.text.clear()

        }

    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}