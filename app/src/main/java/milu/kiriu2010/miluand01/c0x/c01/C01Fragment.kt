package milu.kiriu2010.miluand01.c0x.c01

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import milu.kiriu2010.miluand01.R

class C01Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c01, container, false)
        Log.d(this.javaClass.simpleName,"ptn1")
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            C01Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
