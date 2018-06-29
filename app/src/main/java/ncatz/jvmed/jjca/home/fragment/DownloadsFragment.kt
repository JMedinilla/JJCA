package ncatz.jvmed.jjca.home.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_downloads.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.data.AdapterCreative
import ncatz.jvmed.jjca.data.Part
import ncatz.jvmed.jjca.utils.Preferences
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

class DownloadsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val input = resources.openRawResource(R.raw.downloads)
        readDownloads(input)
    }

    private fun readDownloads(input: InputStream) {
        val writer = StringWriter()
        val buffer = CharArray(1024)

        val reader = BufferedReader(InputStreamReader(input, "UTF-8"))
        var n = reader.read(buffer)
        while (n != -1) {
            writer.write(buffer, 0, n)
            n = reader.read(buffer)
        }
        input.close()

        val gson = Gson()
        val jsonString = writer.toString()
        val part = gson.fromJson(jsonString, Part::class.java)

        loadDownloads(part)
    }

    private fun loadDownloads(part: Part) {
        val villainMode = Preferences.getBooksMode(activity!!)
        downloads_creative.setCreativeViewPagerAdapter(AdapterCreative(activity!!, part.volumes, villainMode))
    }
}