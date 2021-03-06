package com.malygos.gnemes.ui.fragment.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.malygos.gnemes.R
import com.malygos.gnemes.data.entity.MemePost
import com.malygos.gnemes.databinding.ListItemMemePostBinding
import com.malygos.gnemes.ui.activity.MainActivity
import com.malygos.gnemes.ui.activity.detail.MemeDetailActivity

class MemePostsAdapter(
    val fragmentManager: FragmentManager,
    val memePosts: List<MemePost>,
    val activity: FragmentActivity?
) : RecyclerView.Adapter<MemePostsAdapter.MemePostHolder>() {
    private lateinit var parent:ViewGroup
//    private var previousTime = System.currentTimeMillis()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemePostsAdapter.MemePostHolder {
        this.parent =parent
        activity
        return MemePostHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item_meme_post,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return memePosts.size
    }

    override fun onBindViewHolder(holder: MemePostsAdapter.MemePostHolder, position: Int) {
        holder.binding.memePost = memePosts[position]
        holder.binding.memeImg.setOnClickListener {
            if(activity is MainActivity){
//                activity.hideBottomNavigation{
                        MemeDetailActivity.startMemeDetailActivity(parent.context,holder.binding.itemPosterLineTransformationLayout,memePosts[position].id)
//                }
            }
        }
    }

    inner class MemePostHolder(val binding: ListItemMemePostBinding) :
        RecyclerView.ViewHolder(binding.root)
}