package ncatz.jvmed.jjca.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter
import ncatz.jvmed.jjca.R

class AdapterCreative(val context: Context, val volumes: List<Volume>, private val villainMode: Boolean) : CreativePagerAdapter {

    override fun getCount(): Int {
        return volumes.size
    }

    override fun instantiateContentItem(inflater: LayoutInflater, container: ViewGroup, position: Int): View {
        val root = inflater.inflate(R.layout.creative_adapter_header, container, false)

        val image: ImageView = root.findViewById(R.id.creative_adapter_header_image)

        val part = volumes.get(position).part
        if (villainMode) {
            when (part) {
                0 -> {
                    image.setImageResource(R.mipmap.others)
                }
                1 -> {
                    image.setImageResource(R.mipmap.bad01)
                }
                2 -> {
                    image.setImageResource(R.mipmap.bad02)
                }
                3 -> {
                    image.setImageResource(R.mipmap.bad03)
                }
                4 -> {
                    image.setImageResource(R.mipmap.bad04)
                }
                5 -> {
                    image.setImageResource(R.mipmap.bad05)
                }
                6 -> {
                    image.setImageResource(R.mipmap.bad06)
                }
                7 -> {
                    image.setImageResource(R.mipmap.bad07)
                }
                8 -> {
                    image.setImageResource(R.mipmap.bad08)
                }
            }
        } else {
            when (part) {
                0 -> {
                    image.setImageResource(R.mipmap.others)
                }
                1 -> {
                    image.setImageResource(R.mipmap.jojo01)
                }
                2 -> {
                    image.setImageResource(R.mipmap.jojo02)
                }
                3 -> {
                    image.setImageResource(R.mipmap.jojo03)
                }
                4 -> {
                    image.setImageResource(R.mipmap.jojo04)
                }
                5 -> {
                    image.setImageResource(R.mipmap.jojo05)
                }
                6 -> {
                    image.setImageResource(R.mipmap.jojo06)
                }
                7 -> {
                    image.setImageResource(R.mipmap.jojo07)
                }
                8 -> {
                    image.setImageResource(R.mipmap.jojo08)
                }
            }
        }

        return root
    }

    override fun instantiateHeaderItem(inflater: LayoutInflater, container: ViewGroup, position: Int): View {
        val root = inflater.inflate(R.layout.creative_adapter_content, container, false)

        val image: ImageView = root.findViewById(R.id.creative_adapter_content_image)
        val title: TextView = root.findViewById(R.id.creative_adapter_content_title)
        val subtitle: TextView = root.findViewById(R.id.creative_adapter_content_subtitle)

        val volume = volumes.get(position)
        val decodedString = Base64.decode(volume.base64, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

        image.setImageBitmap(decodedByte)
        title.text = "Volume " + volume.number
        subtitle.text = volume.title

        return root
    }

    override fun isUpdatingBackgroundColor(): Boolean {
        return true
    }

    override fun requestBitmapAtPosition(position: Int): Bitmap? {
        val volume = volumes.get(position)
        val decodedString = Base64.decode(volume.base64, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
        return decodedByte
    }
}