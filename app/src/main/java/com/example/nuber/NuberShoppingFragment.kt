package com.example.nuber


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_nuber_shopping.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NuberShoppingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuber_shopping, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        send_salad_button.setOnClickListener {
            val  _db = FirebaseDatabase.getInstance().getReference("salands")
            val k = _db.push().key
            val s = Salad(salad_name_edittext.text.toString(),
                salad_description_edittext.text.toString(), k.toString())

            _db.child(k!!).setValue(s).addOnCompleteListener {
                Toast.makeText(activity, "Your purchase has been placed", Toast.LENGTH_LONG).show()
            }
        }
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
            NuberShoppingFragment().apply {
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
