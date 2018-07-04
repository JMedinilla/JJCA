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
                R.id.navigation_home_pb -> {
                }
                R.id.navigation_home_bt -> {
                }
                R.id.navigation_home_sc -> {
                }
                R.id.navigation_home_diu -> {
                }
                R.id.navigation_home_va -> {
                }
                R.id.navigation_home_so -> {
                }
                R.id.navigation_home_sbr -> {
                }
                R.id.navigation_home_jl -> {
                }
                R.id.navigation_home_ot -> {
                }
            }
            true
        }
    }
}