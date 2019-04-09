package com.example.nuber

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class NuberPagerAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm){
    override fun getItem(p0: Int): Fragment {
        return when(p0){
            0-> NUberMapsActivity()
            1-> NuberShoppingFragment()
            else-> NuberProductsFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Mapa Nuver"
            1-> "Shopping"
            else-> "My Shopping Car"
        }

    }
    override fun getCount(): Int{
        return 3
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