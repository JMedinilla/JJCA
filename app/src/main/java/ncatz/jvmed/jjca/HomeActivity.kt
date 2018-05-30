package ncatz.jvmed.jjca

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import ncatz.jvmed.jjca.fragments.BooksFragment
import ncatz.jvmed.jjca.fragments.FavoritesFragment
import ncatz.jvmed.jjca.fragments.SettingsFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    private lateinit var fragment: Fragment

    private var onNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_navigation_books -> {
                fragment = BooksFragment()
            }
            R.id.home_navigation_favorites -> {
                fragment = FavoritesFragment()
            }
            R.id.home_navigation_settings -> {
                fragment = SettingsFragment()
            }
        }
        launchFragment(fragment)
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelected)

        launchFragment(BooksFragment())
    }

    private fun launchFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_container, fragment).commit()
    }
}
