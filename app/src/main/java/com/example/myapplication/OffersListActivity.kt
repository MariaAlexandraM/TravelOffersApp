package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.OffersAdapter
import com.example.myapplication.interaction.OffersListItemClickListener
import com.example.myapplication.model.DataFactory

class OffersListActivity : AppCompatActivity() {

    lateinit var offersListRef: RecyclerView
    lateinit var offersAdapter: OffersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_offers_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        offersListRef = findViewById(R.id.offersListRV)
        offersListRef.layoutManager = layoutManager

        val offersItemClickListener = object : OffersListItemClickListener {
            override fun onClick(offerId: Int) {
                // Toast.makeText(this@OffersListActivity, "You clicked offer with id $offerId", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@OffersListActivity, OffersDetailsActivity::class.java)
                intent.putExtra("offer-data", offersAdapter.getOfferById(offerId))
                startActivity(intent)
            }
        }
        
        offersAdapter = OffersAdapter(
            this, DataFactory.getOffers(),
            offersItemClickListener
        )

        offersListRef.adapter = offersAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.offers_top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if(id == R.id.chatWithUs) {
            val intent = Intent(this, ChatUIActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}