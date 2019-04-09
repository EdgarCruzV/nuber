package com.example.nuber

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

class NuberProductsAdapter(private val list: List<Salad>)
    : RecyclerView.Adapter<SaladViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaladViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SaladViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: SaladViewHolder, position: Int) {
        val salad: Salad = list[position]
        holder.bind(salad)
    }

    override fun getItemCount(): Int = list.size

}

class SaladViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.nuber_product_item, parent, false)) {
    private var saladNameTextView: TextView? = null
    private var saladDescrptionView: TextView? = null


    init {
        saladNameTextView = itemView.findViewById(R.id.salad_name)
        saladDescrptionView = itemView.findViewById(R.id.salad_description)
    }

    fun bind(salad: Salad) {
        saladNameTextView?.text = salad.name
        saladDescrptionView?.text = salad.description
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Adoptar_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        private var param1: String? = null
        private var param2: String? = null
        @JvmStatic
        fun newInstance() =
            NuberProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(Companion.ARG_PARAM1, param1)
                    putString(Companion.ARG_PARAM2, param2)
                }
            }

        // TODO: Rename and change types of parameters
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
    }
}