package kr.hs.dgsw.unsplashphoto.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.unsplashphoto.R
import kr.hs.dgsw.unsplashphoto.di.MyApp
import kr.hs.dgsw.unsplashphoto.ui.adapter.PhotoAdapter
import kr.hs.dgsw.unsplashphoto.ui.factory.MainViewModelFactory
import kr.hs.dgsw.unsplashphoto.ui.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApp).appComponent.inject(this@MainActivity)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val recyclerView : RecyclerView = findViewById(R.id.main_recyclerView)
        val recyclerAdapter = PhotoAdapter()
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.setQuery("no")

        viewModel.trendingPhotos.observe(this) {
            recyclerAdapter.submitData(lifecycle, it)
        }
    }
}