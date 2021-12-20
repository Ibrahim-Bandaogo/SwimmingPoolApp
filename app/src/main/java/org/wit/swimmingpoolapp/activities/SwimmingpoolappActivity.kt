package org.wit.swimmingpoolapp.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.wit.swimmingpoolapp.databinding.ActivitySwimmingpoolappBinding
import org.wit.swimmingpoolapp.main.MainApp
import org.wit.swimmingpoolapp.models.SwimmingpoolappModel
import org.wit.swimmingpoolapp.R
import timber.log.Timber
import timber.log.Timber.i

class SwimmingpoolappActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySwimmingpoolappBinding
    var swimmingpoolapp = SwimmingpoolappModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var edit = false
        binding = ActivitySwimmingpoolappBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarAdd.title = title
//        setSupportActionBar(binding.toolbarAdd)
        app = application as MainApp

        i("Swimmingpoolapp Activity Start")


        if (intent.hasExtra("swimmingpoolapp_edit")) {
            edit = true
            swimmingpoolapp = intent.extras?.getParcelable("swimmingpoolapp_edit")!!
            binding.swimmingpoolappTitle.setText(swimmingpoolapp.title)
            binding.description.setText(swimmingpoolapp.description)
            binding.btnAdd.setText(R.string.save_swimmingpoolapp)
        }

        binding.btnAdd.setOnClickListener() {
            swimmingpoolapp.title = binding.swimmingpoolappTitle.text.toString()
            swimmingpoolapp.description = binding.description.text.toString()
            if (swimmingpoolapp.title.isEmpty()) {
                Snackbar.make(it,R.string.enter_Swimmingpoolapp_title, Snackbar.LENGTH_LONG)
                    .show()

            } else {
                if (edit) {

                    app.swimmingpoolapp.update(swimmingpoolapp.copy())
                } else {

                    app.swimmingpoolapp.create(swimmingpoolapp.copy())
                }
            }
            i("herre"+ app.swimmingpoolapp.swimmingpoolappList.toString())
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_cancel -> { finish() }
        }
        return super.onOptionsItemSelected(item)
    }
}