package com.along.longreporter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val framents: ArrayList<FragmentModel> = ArrayList()
    var viewPagerAdapter: ViewPagerAdapter? = null


    var email = "alphahoai@gmail.com"
    var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        framents.add(FragmentModel("Home", HomeFragment()))
        framents.add(FragmentModel("Sport", HomeFragment()))
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, framents)
        viewpager.adapter = viewPagerAdapter
        tablayout.setupWithViewPager(viewpager)

//        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

//            email = "ngoclonghk96@gmail.com"
//            menu?.findItem(R.id.action_user_email)?.setTitle(email)
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        this.menu = menu
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_user_email).setTitle(email)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_notifications -> {
                Toast.makeText(this, "Notification", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_text_size -> {
                Toast.makeText(this, "Text Size", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_send_app_feedback -> {
                Toast.makeText(this, "Send App Feedback", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_user_email -> {
                Toast.makeText(this, "User email", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_subscribe -> {
                Toast.makeText(this, "Subscribe", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}
