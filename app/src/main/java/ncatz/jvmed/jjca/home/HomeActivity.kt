package ncatz.jvmed.jjca.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.home.fragment.BooksFragment
import ncatz.jvmed.jjca.home.fragment.DownloadsFragment
import ncatz.jvmed.jjca.home.fragment.SettingsFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        home_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_navigation_books -> {
                    launchFragment(BooksFragment())
                }
                R.id.home_navigation_favorites -> {
                    launchFragment(DownloadsFragment())
                }
                R.id.home_navigation_settings -> {
                    launchFragment(SettingsFragment())
                }
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        launchFragment(BooksFragment())
    }

    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.home_container, fragment).commit()
    }
}
