package com.cuursoft.sempatistar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CLAS = "extra_clas"
        const val EXTRA_FAS = "extra_fas"
        const val EXTRA_PICT = "extra_pict"
        const val EXTRA_KAMP = "extra_kamp"
        const val EXTRA_FAKUL = "extra_fakul"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        showProductDetail()

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Detail Universitas"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun showProductDetail() {
        claskirim.setText(intent.getStringExtra(EXTRA_CLAS))
        faskirim.setText(intent.getStringExtra(EXTRA_FAS))
        fakulkirim.setText(intent.getStringExtra(EXTRA_FAKUL))


        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_PICT)).into(img_bus)

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_KAMP)).into(img_kamp)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}