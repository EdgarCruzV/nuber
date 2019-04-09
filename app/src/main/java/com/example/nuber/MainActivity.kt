package com.example.nuber
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_nuber_shopping.*
import kotlinx.android.synthetic.main.nav_header.*


class  MainActivity : NavigationView.OnNavigationItemSelectedListener, AppCompatActivity(){
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.getItemId()) {
            R.id.Mapa_NUber -> {
                drawer.closeDrawers()

                val fragment : Fragment = NUberMapsActivity.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()

            }
            R.id.Shopping -> {
                drawer.closeDrawers()
                val tiendaFragment = NuberShoppingFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, tiendaFragment).commit();
                Toast.makeText(this, "Shopping", Toast.LENGTH_SHORT).show()

            }
            R.id.My_Shopping_Car -> {
                drawer.closeDrawers()
                val informacionFragment = NuberProductsFragment.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, informacionFragment).commit();
                Toast.makeText(this, "Shopping Car", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }
    private lateinit var drawer: DrawerLayout
    lateinit var _db: DatabaseReference

    val fragmentAdapter = NuberPagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Para el menu
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        var navigationView : NavigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        setUpMap()
        val fragment = NUberMapsActivity.newInstance();
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.buy_item  -> {


                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)

                startActivity(intent)

            }
            R.id.log_out ->{
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, RegisterActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private  val LOCATION_PERMISSION_REQUEST_CODE = 666


    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
    }
}


data class Salad(
    val name: String = "",
    val description: String = "",
    var uuid: String = "")
data class User(
    var uuid: String = "",
    val username: String = "",
    val image: String = ""
    )