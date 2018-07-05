package ncatz.jvmed.jjca.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.home_drawer.*
import ncatz.jvmed.jjca.R

class HomeDrawer : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        home_drawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home_settings -> {
                }
            }
            true
        }
    }
}