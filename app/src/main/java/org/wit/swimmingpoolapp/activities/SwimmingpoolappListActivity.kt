package org.wit.swimmingpoolapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.wit.swimmingpoolapp.R
import org.wit.swimmingpoolapp.adapters.SwimmingpoolappAdapter
import org.wit.swimmingpoolapp.adapters.SwimmingpoolappListener
import org.wit.swimmingpoolapp.databinding.ActivitySwimmingpoolappBinding
import org.wit.swimmingpoolapp.databinding.ActivitySwimmingpoolappListBinding
import org.wit.swimmingpoolapp.databinding.CardSwimmingpoolappBinding
import org.wit.swimmingpoolapp.models.SwimmingpoolappModel
import org.wit.swimmingpoolapp.main.MainApp

class SwimmingpoolappListActivity : AppCompatActivity(), SwimmingpoolappListener {

    lateinit var app: MainApp
    private lateinit var binding: ActivitySwimmingpoolappListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwimmingpoolappListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.title = title
//        setSupportActionBar(binding.toolbar)
        app = application as MainApp

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = SwimmingpoolappAdapter(app.swimmingpoolapp.findAll(), this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_add -> {
                val launcherIntent = Intent(this, SwimmingpoolappActivity::class.java)
                startActivityForResult(launcherIntent, 0)
            }
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onSwmmingpoolappClick(swimm: SwimmingpoolappModel) {
        val launcherIntent = Intent(this, SwimmingpoolappActivity::class.java)
        launcherIntent.putExtra("swimmingpoolapp_edit", swimm)
        startActivityForResult(launcherIntent, 0)
    }
}
