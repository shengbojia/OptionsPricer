package com.shengbojia.optionspricer.ui

import android.app.AlertDialog
import android.content.Intent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.shengbojia.optionspricer.R
import com.shengbojia.optionspricer.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TitleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater, R.layout.fragment_title, container, false)

        binding.btnTitleBlackscholes.setOnClickListener {
            it.findNavController().navigate(R.id.action_titleFragment_to_calculatorFragment)
        }

        binding.btnTitleInfo.setOnClickListener {
            showInfo()
        }

        return binding.root
    }

    private fun showInfo() {
        val builder = AlertDialog.Builder(activity, R.style.InfoDialogStyle)
        builder.setTitle("Help")
        builder.setMessage("This app uses the Black-Scholes-Merton model to price vanilla European options.")
        builder.setPositiveButton("More info") { _, _ ->
            openWikiPage()
        }

        builder.setNegativeButton("Cancel") { _, _ ->

        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun openWikiPage() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://wikipedia.org/wiki/Black–Scholes_model")

        val chooserIntent = Intent.createChooser(intent, "Open this link with: ")

        if (intent.resolveActivity(activity?.packageManager) != null) {
            startActivity(chooserIntent)
        } else {
            Log.d(TAG, "Could not resolve intent!")
        }
    }

    companion object {
        private const val TAG = "TitleFrag"
    }
}
