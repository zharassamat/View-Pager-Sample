package kz.sj.viewpagersample

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.nshmura.recyclertablayout.RecyclerTabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: MoviesPagerAdapter
    private lateinit var recyclerTabLayout: RecyclerTabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the list of movies from the JSON file
        val movies = MovieHelper.getMoviesFromJson("movies.json", this)

        viewPager = findViewById(R.id.viewPager)

        pagerAdapter = MoviesPagerAdapter(supportFragmentManager, movies)
        viewPager.adapter = pagerAdapter

        recyclerTabLayout = findViewById(R.id.recyclerTabLayout)
        recyclerTabLayout.setUpWithViewPager(viewPager)

        viewPager.currentItem = pagerAdapter.count / 2
    }
}

