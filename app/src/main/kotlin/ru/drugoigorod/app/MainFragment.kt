package ru.drugoigorod.app

import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import ru.drugoigorod.app.data.IndexItem
import ru.drugoigorod.app.data.IndexItemParser
import ru.drugoigorod.app.web.IndexRequest

class MainFragment : Fragment() {

    companion object {

        fun newInstance(): MainFragment = MainFragment()

    }

    var progressBar: ContentLoadingProgressBar? = null
    var list: RecyclerView? = null

    val adapter = Adapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar?)
        progressBar = view.findViewById(R.id.progress) as ContentLoadingProgressBar?
        list = view.findViewById(R.id.list) as RecyclerView?
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0) {
                    return 2
                } else {
                    return 1
                }
            }
        }
        list?.layoutManager = layoutManager
        list?.adapter = adapter
        val t = Task()
        t.execute()
    }


    inner class ViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.listitem_index, parent, false)) {

        val backgroundImageView = itemView.findViewById(R.id.item_background) as ImageView
        val titleTextView = itemView.findViewById(R.id.item_title) as TextView

    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {

        val data = mutableListOf<IndexItem>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = data[position]
            Glide.with(this@MainFragment).load(item.backgroundUrl).into(holder.backgroundImageView);
            holder.titleTextView.text = "${item.title}"
            holder.titleTextView.setTextColor(item.textColor)
            holder.titleTextView.setBackgroundColor(item.textBackgroundColor)
        }

        override fun getItemCount(): Int = data.size

    }

    inner class Task : AsyncTask<Unit, Unit, List<IndexItem>>() {

        override fun doInBackground(vararg p0: Unit?): List<IndexItem> {
            val s = IndexRequest().request()
            return IndexItemParser().parse(s)
        }

        override fun onPostExecute(result: List<IndexItem>?) {
            super.onPostExecute(result)
            adapter.data.clear()
            if (result == null) {

            } else {
                adapter.data.addAll(result)
            }
            adapter.notifyDataSetChanged()
            progressBar?.visibility = View.GONE
            list?.visibility = View.VISIBLE
        }

    }


}



