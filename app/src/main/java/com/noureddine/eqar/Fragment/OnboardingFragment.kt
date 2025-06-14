package com.noureddine.eqar.Fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.noureddine.eqar.Model.OnboardingItem
import com.noureddine.eqar.R

class OnboardingFragment : Fragment() {

    private lateinit var imageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var descriptionTextView: TextView

    companion object {
        private const val ARG_ITEM = "onboarding_item"

        fun newInstance(item: OnboardingItem): OnboardingFragment {
            val fragment = OnboardingFragment()
            val args = Bundle()
            args.putSerializable(ARG_ITEM, item)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupContent()
    }

    private fun initViews(view: View) {
        imageView = view.findViewById(R.id.imageView)
        titleTextView = view.findViewById(R.id.titleTextView)
        descriptionTextView = view.findViewById(R.id.descriptionTextView)
    }

    private fun setupContent() {
        val item = arguments?.getSerializable(ARG_ITEM) as? OnboardingItem
        item?.let {
            imageView.setImageResource(it.imageRes)
            titleTextView.text = it.title
            descriptionTextView.text = it.description
        }
    }
}