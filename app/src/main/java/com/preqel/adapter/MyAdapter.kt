package com.preqel.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.preqel.huncunrx.R

/**
 * Created by preqel on 2018/10/7.
 */
class MyAdapter(private val context: Context, private val data: Array<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.layout_item_view, null)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textview.setText(data.get(position))
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var textview: TextView = itemView?.findViewById(R.id.tv1)!!
    }
}