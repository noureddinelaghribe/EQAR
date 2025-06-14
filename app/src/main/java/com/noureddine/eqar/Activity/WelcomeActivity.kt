package com.noureddine.eqar.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.noureddine.eqar.Adapter.OnboardingAdapter
import com.noureddine.eqar.Model.OnboardingItem
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
//    private lateinit var viewPager: ViewPager2
//    private lateinit var tabLayout: TabLayout
//    private lateinit var btnNext: MaterialButton
//    private lateinit var btnSkip: MaterialButton
    //private lateinit var btnGetStarted: MaterialButton
    private lateinit var adapter: OnboardingAdapter
    //private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize SharedPreferences
        //sharedPreferences = getSharedPreferences("onboarding", MODE_PRIVATE)

        // Check if onboarding was already shown
//        if (sharedPreferences.getBoolean("completed", false)) {
//            navigateToMainActivity()
//            return
//        }

        initViews()
        setupViewPager()
        setupClickListeners()

    }

    private fun initViews() {

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //viewPager = findViewById(R.id.viewPager)
        //tabLayout = findViewById(R.id.tabLayout)
        //btnNext = findViewById(R.id.btnNext)
        //btnSkip = findViewById(R.id.btnSkip)
        //btnGetStarted = findViewById(R.id.btnGetStarted)

        binding.btnNext.visibility = View.VISIBLE
        binding.btnSkip.visibility = View.VISIBLE

        binding.btnNext.text = getString(R.string.next)
        binding.btnSkip.text = getString(R.string.skip)

    }

    private fun setupViewPager() {
        adapter = OnboardingAdapter(this, getOnboardingItems())
        binding.viewPager.adapter = adapter

        // Connect TabLayout with ViewPager2
        //TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.customView = createDotView(position == 0)
        }.attach()


        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                updateDotAppearance(tab.customView, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                updateDotAppearance(tab.customView, false)
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        //tabLayout.post { applyTabMargins() }


        // Handle page changes
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //updateUI(position)

                val isLastPage = binding.viewPager.currentItem == adapter.itemCount - 1
                binding.btnNext.text = if (isLastPage) getString(R.string.start) else getString(R.string.next)
                binding.btnSkip.visibility = if (isLastPage) View.GONE else View.VISIBLE



            }
        })

    }

    private fun setupClickListeners() {
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem < adapter.itemCount - 1) {
                binding.viewPager.currentItem += 1
            }else{
                finishOnboarding()
            }
        }

        binding.btnSkip.setOnClickListener {
            finishOnboarding()
        }

//        btnGetStarted.setOnClickListener {
//            finishOnboarding()
//        }
    }

//    private fun updateUI(position: Int) {
//        val isLastPage = position == adapter.itemCount - 1
//
//        btnNext.visibility = if (isLastPage) View.GONE else View.VISIBLE
//        btnSkip.visibility = if (isLastPage) View.GONE else View.VISIBLE
//        btnGetStarted.visibility = if (isLastPage) View.VISIBLE else View.GONE
//    }

    private fun finishOnboarding() {
        // Mark onboarding as completed
        //sharedPreferences.edit().putBoolean("completed", true).apply()
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    private fun getOnboardingItems(): List<OnboardingItem> {
        return listOf(
            OnboardingItem(
                imageRes = R.drawable.real_state,
                title = getString(R.string.tital_page_1),
                description = getString(R.string.content_page_1)
                ),
            OnboardingItem(
                imageRes = R.drawable.chatbot,
                title = getString(R.string.tital_page_2),
                description = getString(R.string.content_page_2)
            ),
            OnboardingItem(
                imageRes = R.drawable.verified,
                title = getString(R.string.tital_page_3),
                description = getString(R.string.content_page_3)
            ),
            OnboardingItem(
                imageRes = R.drawable.laptop,
                title = getString(R.string.tital_page_4),
                description = getString(R.string.content_page_4)
            ),
            OnboardingItem(
                imageRes = R.drawable.ai,
                title = getString(R.string.tital_page_5),
                description = getString(R.string.content_page_5)
            )
        )
    }

    private fun createDotView(isSelected: Boolean): View {
        val view = LayoutInflater.from(this)
            .inflate(R.layout.view_circle_tab, binding.tabLayout, false)
        updateDotAppearance(view, isSelected)
        return view
    }

    private fun updateDotAppearance(dotView: View?, isActive: Boolean) {
        dotView ?: return
        val drawableRes = if (isActive) R.drawable.dot_active else R.drawable.dot_inactive
        dotView.background = ContextCompat.getDrawable(this, drawableRes)
        val sizePx = if (isActive) 24 else 12
        dotView.layoutParams = dotView.layoutParams.apply {
            width = sizePx
            height = sizePx
        }
    }



}