package ncatz.jvmed.jjca.part

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_part.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.data.AdapterCreative
import ncatz.jvmed.jjca.data.Part
import ncatz.jvmed.jjca.utils.Preferences
import java.io.*

class PartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part)
        setSupportActionBar(part_toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.toolbar_back)

        val partToLoad = intent.extras.getInt("partToLoad")
        when (partToLoad) {
            0 -> {
                supportActionBar!!.title = "Others"
            }
            1 -> {
                supportActionBar!!.title = "Phantom Blood"
                val input = resources.openRawResource(R.raw.phantom_blood)
                readPart(input)
            }
            2 -> {
                supportActionBar!!.title = "Battle Tendency"
                val input = resources.openRawResource(R.raw.battle_tendency)
                readPart(input)
            }
            3 -> {
                supportActionBar!!.title = "Stardust Crusaders"
                val input = resources.openRawResource(R.raw.stardust_crusaders)
                readPart(input)
            }
            4 -> {
                supportActionBar!!.title = "Diamond is Unbreakable"
                val input = resources.openRawResource(R.raw.diamond_is_unbreakable)
                readPart(input)
            }
            5 -> {
                supportActionBar!!.title = "Vento Aureo"
                val input = resources.openRawResource(R.raw.vento_aureo)
                readPart(input)
            }
            6 -> {
                supportActionBar!!.title = "Stone Ocean"
                val input = resources.openRawResource(R.raw.stone_ocean)
                readPart(input)
            }
            7 -> {
                supportActionBar!!.title = "Steel Ball Run"
                val input = resources.openRawResource(R.raw.steel_ball_run)
                readPart(input)
            }
            8 -> {
                supportActionBar!!.title = "Jojolion"
                val input = resources.openRawResource(R.raw.jojolion)
                readPart(input)
            }
        }
    }

    private fun readPart(input: InputStream) {
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

        loadPart(part)
    }

    private fun loadPart(part: Part) {
        //
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
