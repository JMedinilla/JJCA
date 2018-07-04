package ncatz.jvmed.jjca.home

import android.os.Bundle
import android.view.Menu
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val drawer = HomeDrawer()
                drawer.show(supportFragmentManager, drawer.tag)
            }
            R.id.menu_home_settings -> {
            }
        }
        return true
    }

    override fun onResume() {
        super.onResume()

        val phantomBlood = readPart(R.raw.phantom_blood)
        val battleTendency = readPart(R.raw.battle_tendency)
        val stardustCrusaders = readPart(R.raw.stardust_crusaders)
        val diamondIsUnbreakable = readPart(R.raw.diamond_is_unbreakable)
        val ventoAureo = readPart(R.raw.vento_aureo)
        val stoneOcean = readPart(R.raw.stone_ocean)
        val steelBallRun = readPart(R.raw.steel_ball_run)
        val jojolion = readPart(R.raw.jojolion)

        phantomList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        phantomList.adapter = AdapterVolume(phantomBlood.volumes)
        battleList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        battleList.adapter = AdapterVolume(battleTendency.volumes)
        stardustList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        stardustList.adapter = AdapterVolume(stardustCrusaders.volumes)
        diamondList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        diamondList.adapter = AdapterVolume(diamondIsUnbreakable.volumes)
        ventoList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        ventoList.adapter = AdapterVolume(ventoAureo.volumes)
        stoneList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        stoneList.adapter = AdapterVolume(stoneOcean.volumes)
        steelList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        steelList.adapter = AdapterVolume(steelBallRun.volumes)
        jojolionList.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        jojolionList.adapter = AdapterVolume(jojolion.volumes)
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
