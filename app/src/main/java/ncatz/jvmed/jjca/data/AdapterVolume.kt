package ncatz.jvmed.jjca.data

import android.graphics.BitmapFactory
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ncatz.jvmed.jjca.R

class AdapterVolume(val volumes: List<Volume>) : RecyclerView.Adapter<AdapterVolume.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualVolume = volumes.get(position)

        val decodedString = Base64.decode(actualVolume.base64, Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)

        holder.title.text = actualVolume.title
        holder.image.setImageBitmap(bitmap)

        if (!actualVolume.download) {
            val matrix = ColorMatrix()
            matrix.setSaturation(0f)
            val filter = ColorMatrixColorFilter(matrix)
            holder.image.colorFilter = filter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_volume, parent, false)
    )

    override fun getItemCount() = volumes.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.adapterVolume_title)
        val image: ImageView = itemView.findViewById(R.id.adapterVolume_image)
    }
}