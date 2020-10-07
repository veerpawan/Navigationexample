package com.example.navigationexample


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(
            activity!!.applicationContext,
            "Bundle args " + arguments!!.getBoolean("test_boolean"),
            Toast.LENGTH_SHORT
        ).show()

        Toast.makeText(
            activity!!.applicationContext, "Bundle args " + FirstFragmentArgs.fromBundle(
                arguments!!
            ).getTestString(), Toast.LENGTH_SHORT
        ).show()
        val button: Button = view.findViewById(R.id.button_frag2)
        button.setOnClickListener(View.OnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)
            navController.navigateUp()
            navController.addOnDestinationChangedListener { controller, destination, arguments ->

                Log.e("TAG", destination.label.toString() + " ")
            }


/*
            navController.addOnNavigatedListener(object : OnNavigatedListener() {
                fun onNavigated(controller: NavController, destination: NavDestination) {
                    Log.d("TAG", destination.label.toString() + " ")
                }
            })*/
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}