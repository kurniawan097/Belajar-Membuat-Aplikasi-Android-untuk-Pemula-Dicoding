package com.cuursoft.sempatistar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var TampBus: RecyclerView
    private var list: ArrayList<Bus> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TampBus = findViewById(R.id.tampbus)
        TampBus.setHasFixedSize(true)

        list.addAll(BusData.listData)
        showRecyclerList()

    }


    private fun showRecyclerList() {
        TampBus.layoutManager = LinearLayoutManager(this)
        val listBusAdapter = ListBusAdapter(list)
        TampBus.adapter = listBusAdapter

        listBusAdapter.setOnItemClickCallback(object : ListBusAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Bus) {
                //showSelectedBus(data)
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                    .apply {
                        putExtra(DetailActivity.EXTRA_CLAS, data.clas)
                        putExtra(DetailActivity.EXTRA_FAS, data.fas)
                        putExtra(DetailActivity.EXTRA_PICT, data.pict)
                        putExtra(DetailActivity.EXTRA_KAMP, data.kamp)
                        putExtra(DetailActivity.EXTRA_FAKUL, data.fakul)
                    }
                startActivity(moveIntent)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_profil, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.myProfil -> {
                val moveIntent = Intent(this@MainActivity, profil::class.java)
                startActivity(moveIntent)
            }

        }
    }


}
