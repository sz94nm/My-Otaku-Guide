package com.example.sz94n.ineedspleep.activites.activities

import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import com.example.sz94n.ineedspleep.R
import com.example.sz94n.ineedspleep.activites.fragments.AnimeFragment
import com.example.sz94n.ineedspleep.activites.fragments.CharacterFragment
import com.example.sz94n.ineedspleep.activites.fragments.MangaFragment
import com.example.sz94n.myanimeguide.junk.Consts
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    var lastPosition = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter

        tabs.setupWithViewPager(container)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        lastPosition = sharedPreferences.getInt(Consts.LAST_POS, 0)
        container.currentItem = lastPosition


    }
    //WHY U NO WORK !!!!
//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        val loading = animeLoadingImageView.background as AnimationDrawable
//        loading.start()
//
//    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       return super.onOptionsItemSelected(item)
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {



        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> AnimeFragment()
                1 -> MangaFragment()
                2 -> CharacterFragment()
                else -> AnimeFragment()

            }
            lastPosition=container.currentItem
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {

            return when (position) {
                0 -> getString(R.string.animeTitle)
                1 -> getString(R.string.mangaTitle)
                2 -> getString(R.string.characterTitle)
                else -> getString(R.string.unknownTitle)
            }

        }
    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()
        editor.putInt(Consts.LAST_POS, lastPosition)
    }



}
