package ncatz.jvmed.jjca.home.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_books.*
import ncatz.jvmed.jjca.R
import ncatz.jvmed.jjca.part.PartActivity
import ncatz.jvmed.jjca.utils.Preferences

class BooksFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        card_PB.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 1)
            })
        }
        card_BT.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 2)
            })
        }
        card_SC.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 3)
            })
        }
        card_DIU.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 4)
            })
        }
        card_VA.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 5)
            })
        }
        card_SO.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 6)
            })
        }
        card_SBR.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 7)
            })
        }
        card_JL.setOnClickListener {
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 8)
            })
        }
        card_OT.setOnClickListener {
            /*
            startActivity(Intent(activity, PartActivity::class.java).apply {
                putExtra("partToLoad", 0)
            })
            */
        }

        if (Preferences.getBooksMode(activity!!)) {
            card_PB_image.setImageResource(R.mipmap.bad01)
            card_BT_image.setImageResource(R.mipmap.bad02)
            card_SC_image.setImageResource(R.mipmap.bad03)
            card_DIU_image.setImageResource(R.mipmap.bad04)
            card_VA_image.setImageResource(R.mipmap.bad05)
            card_SO_image.setImageResource(R.mipmap.bad06)
            card_SBR_image.setImageResource(R.mipmap.bad07)
            card_JL_image.setImageResource(R.mipmap.bad08)
            card_OT_image.setImageResource(R.mipmap.others)
        } else {
            card_PB_image.setImageResource(R.mipmap.jojo01)
            card_BT_image.setImageResource(R.mipmap.jojo02)
            card_SC_image.setImageResource(R.mipmap.jojo03)
            card_DIU_image.setImageResource(R.mipmap.jojo04)
            card_VA_image.setImageResource(R.mipmap.jojo05)
            card_SO_image.setImageResource(R.mipmap.jojo06)
            card_SBR_image.setImageResource(R.mipmap.jojo07)
            card_JL_image.setImageResource(R.mipmap.jojo08)
            card_OT_image.setImageResource(R.mipmap.others)
        }
    }
}
