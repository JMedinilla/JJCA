package ncatz.jvmed.jjca.home.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_settings.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.utils.Preferences

class SettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val villainsMode = Preferences.getBooksMode(activity!!)
        settings_bookmode_switch.setOnCheckedChangeListener { _, isChecked ->
            Preferences.setBooksMode(activity!!, isChecked)
        }
        settings_bookmode_switch.isChecked = villainsMode
    }
}