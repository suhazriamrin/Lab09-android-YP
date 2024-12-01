package com.suhazri.lab09

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suhazri.lab09.data.PlaceListAdapter
import com.suhazri.lab09.databinding.ActivityMainBinding
import com.suhazri.lab09.model.Place

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var countryList = ArrayList<Place>()
        countryList.add(Place("Malaysia", "Kuala Lumpur"))
        countryList.add(Place("Thailand", "Bangkok"))
        countryList.add(Place("Vietnam", "Hanoi"))
        countryList.add(Place("Indonesia", "Bali"))
        countryList.add(Place("Singapore", "Singapore"))
        countryList.add(Place("Malaysia", "Penang"))

        val adapter = PlaceListAdapter(countryList, this)
        binding.recyclerView.adapter = adapter

    }

    // guna bila Menu exist
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflate -> keluarkan
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // guna bila Menu dipilih
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutMenu -> {
                //open website
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.peoplelogy.com")
                startActivity(intent)
            }
            R.id.emailMenu -> {
                //open email
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:contact@peoplelogy.com")
                startActivity(intent)
            }
            R.id.callMenu -> {
                val intent = Intent(Intent.ACTION_CALL)
                intent.data = Uri.parse("tel:0147754154")
                startActivity(intent)
            }
            R.id.exitMenu -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}