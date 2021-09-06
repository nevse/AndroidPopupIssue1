package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.LayoutInflater
import android.widget.PopupWindow
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner


class MainActivity : AppCompatActivity() {
    var data = arrayOf("test1", "test2", "test3", "test4", "test5")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view : View = LayoutInflater.from(this).inflate(R.layout.layout_popup, null)
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        val spinner : Spinner = view.findViewById<View>(R.id.spinner) as Spinner
        spinner.adapter = adapter
        spinner.prompt = "Title"
        spinner.setSelection(2)
        val button : Button = this.findViewById<Button>(R.id.button_show_popup)

        button.setOnClickListener() {
            var popup : PopupWindow = PopupWindow(view, 200, 200)
            popup.showAtLocation(it,0,300, 300)
        }
    }
}