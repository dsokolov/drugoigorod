package ru.drugoigorod.app

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainFragment : Fragment() {

    companion object {

        fun newInstance(): MainFragment = MainFragment()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.toolbar) as Toolbar?)
        val list = view.findViewById(R.id.list) as RecyclerView
        list.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        list.adapter = Adapter()
    }


    inner class ViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)) {

        val textView = itemView.findViewById(android.R.id.text1) as TextView

    }

    inner class Adapter : RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.textView.text = "$position"
        }

        override fun getItemCount(): Int = 10

    }


}



