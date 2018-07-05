package ncatz.jvmed.jjca.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.home_activity.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.data.AdapterVolume
import ncatz.jvmed.jjca.data.Part
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringWriter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        setSupportActionBar(home_bottombar)

        phantomList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        battleList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        stardustList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        diamondList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        ventoList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        stoneList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        steelList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        jojolionList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val drawer = HomeDrawer()
                drawer.show(supportFragmentManager, drawer.tag)
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()

        val thread = Thread(Runnable {
            val phantomBlood = readPart(R.raw.phantom_blood)
            val battleTendency = readPart(R.raw.battle_tendency)
            val stardustCrusaders = readPart(R.raw.stardust_crusaders)
            val diamondIsUnbreakable = readPart(R.raw.diamond_is_unbreakable)
            val ventoAureo = readPart(R.raw.vento_aureo)
            val stoneOcean = readPart(R.raw.stone_ocean)
            val steelBallRun = readPart(R.raw.steel_ball_run)
            val jojolion = readPart(R.raw.jojolion)

            runOnUiThread {
                phantomList.adapter = AdapterVolume(phantomBlood.volumes)
                battleList.adapter = AdapterVolume(battleTendency.volumes)
                stardustList.adapter = AdapterVolume(stardustCrusaders.volumes)
                diamondList.adapter = AdapterVolume(diamondIsUnbreakable.volumes)
                ventoList.adapter = AdapterVolume(ventoAureo.volumes)
                stoneList.adapter = AdapterVolume(stoneOcean.volumes)
                steelList.adapter = AdapterVolume(steelBallRun.volumes)
                jojolionList.adapter = AdapterVolume(jojolion.volumes)
            }
        })
        thread.start()
    }

    private fun readPart(part: Int): Part {
        val input = resources.openRawResource(part)
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
        return gson.fromJson(jsonString, Part::class.java)
    }
}
