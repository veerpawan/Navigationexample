package com.example.navigationexample




import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = Bundle()
        bundle.putBoolean("test_boolean", true)

        val navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)


        val button: Button = view.findViewById(R.id.button_frag1)

        button.setOnClickListener(View.OnClickListener {
            navController.navigate(
                R.id.action_firstFragment_to_secondFragment,
                bundle
            )
        })

        //way one
       /* val s =
            Navigation.createNavigateOnClickListener(R.id.action_firstFragment_to_secondFragment)
        val button: Button = view.findViewById(R.id.button_frag1)
        button.setOnClickListener(s)*/


        //way two
    /*    val navDirections: NavDirections =
            FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        val navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)

        button.setOnClickListener {
            navController.navigate(navDirections)
        }*/

        //way three

       /* val navController = Navigation.findNavController(activity!!, R.id.my_nav_host_fragment)

        button_frag1.setOnClickListener { navController.navigate(R.id.action_firstFragment_to_secondFragment) }*/
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}