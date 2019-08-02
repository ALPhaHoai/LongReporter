package com.along.longreporter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var email = "alphahoai@gmail.com"
    var email2 = "ngoclonghk96@gmail.com"
    var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            val userEmailItem = menu?.findItem(R.id.action_user_email)
            if (userEmailItem != null) {
                userEmailItem.title = if (userEmailItem.title.equals(email)) email2 else email
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_user_email).title = email
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_notifications -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_text_size -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_send_app_feedback -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_user_email -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_subscribe -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
