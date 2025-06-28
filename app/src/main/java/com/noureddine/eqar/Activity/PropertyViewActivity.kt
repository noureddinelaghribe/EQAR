package com.noureddine.eqar.Activity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.noureddine.eqar.Adapter.FlexboxAdapter
import com.noureddine.eqar.Adapter.SliderAdapterPropertyView
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.ActivityPropertyBinding
import kotlin.math.abs
import com.noureddine.eqar.Model.PropertyItem
import com.noureddine.eqar.utils.Constants
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class PropertyViewActivity : AppCompatActivity() {

    // ViewBinding للوصول إلى عناصر واجهة المستخدم
//    private var _binding: ActivityPropertyBinding? = null
//    private val binding get() = _binding!!

    private lateinit var binding: ActivityPropertyBinding
    private lateinit var propertyItem: PropertyItem

    // متغيرات للتحكم في السلايدر
    private var isAutoScrolling = true
    private var touchStartX = 0f
    private var touchEndX = 0f
    private val SWIPE_THRESHOLD = 100 // الحد الأدنى للمسافة للتمرير

    // معالجة التمرير التلقائي للسلايدر
    private val sliderHandler = Handler(Looper.getMainLooper())
    private val sliderRunnable = object : Runnable {
        override fun run() {
            if (isAutoScrolling) {
                val currentItem = binding.viewpagerAds.currentItem
                val itemCount = binding.viewpagerAds.adapter?.itemCount ?: 0
                binding.viewpagerAds.currentItem = if (currentItem == itemCount - 1) 0 else currentItem + 1
            }
            sliderHandler.postDelayed(this, 3000) // تغيير الشريحة كل 3 ثواني
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_property)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize propertyItem from intent
        propertyItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("property", PropertyItem::class.java)
                ?: throw IllegalStateException("Property data not found in intent")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("property")
                ?: throw IllegalStateException("Property data not found in intent")
        }

        // 2. Inflate the binding
        binding = ActivityPropertyBinding.inflate(layoutInflater)

        // 3. Set the Activity’s content to the root of the binding
        setContentView(binding.root)

        loadSliderRealEstatedata(propertyItem.imageRes)

        setupInformation()



    }


    private fun loadSliderRealEstatedata(imageRes: List<String>) {
        // إعداد عناصر السلايدر
        setupSlider(imageRes as MutableList<String>)
    }

    private fun setupInformation() {

        binding.tvTitle.text = Constants.PropertyName.get(propertyItem.typeProperty) +" "+Constants.PropertyTypeName.get(propertyItem.type)
        if (propertyItem.price>1){
            binding.tvPrice.text = Constants.formatWithCommas(propertyItem.price)
        }else{
            binding.tvPrice.text = "حسب الاتفاق"
        }
        val wilaya = Constants.wilayasFr.get(propertyItem.location.get(0))
        val baladias = Constants.wilayaToBaladiasAr[wilaya]
        val baladia = baladias?.get(propertyItem.location.get(1))
        binding.tvLocation.text = wilaya+", "+baladia
        binding.tvDescription.text = propertyItem.description

        // Features
        val featureLayoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent = com.google.android.flexbox.JustifyContent.FLEX_START
        }
        val features = mutableListOf<String>()
        for (i in propertyItem.features){
            features.add(Constants.FeatureIdsName.get(i))
        }
        // Set up RecyclerView
        binding.FeatureRecyclerView.apply {
            layoutManager = featureLayoutManager
            adapter = FlexboxAdapter(features,false)
        }

        //Documents
        val documentLayoutManager = FlexboxLayoutManager(this).apply {
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
            justifyContent = com.google.android.flexbox.JustifyContent.FLEX_START
        }
        val document = mutableListOf<String>()
        for (i in propertyItem.documents){
            document.add(Constants.DocumentIdsName.get(i))
        }
        // Set up RecyclerView
        binding.DocumentRecyclerView.apply {
            layoutManager = documentLayoutManager
            adapter = FlexboxAdapter(document,false)
        }

        binding.tvType.text = Constants.PropertyName.get(propertyItem.type)
        binding.tVTypeProperty.text = Constants.PropertyTypeName.get(propertyItem.type)
        binding.tvTimestamp.text = convertTimestampToDate(propertyItem.timestamp)

        if (propertyItem.isEquipped) {
            binding.tvIsEquipped.backgroundTintList = ContextCompat.getColorStateList(this, R.color.status_success)
            binding.tvIsEquipped.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_check, 0, 0, 0)
        } else {
            binding.tvIsEquipped.backgroundTintList  = ContextCompat.getColorStateList(this, R.color.status_error)
            binding.tvIsEquipped.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_close, 0, 0, 0)
        }

    }

    private fun setupSlider(sliderItems: MutableList<String>){

        // إعداد محول السلايدر
        val sliderAdapterPropertyView = SliderAdapterPropertyView(sliderItems)
        binding.viewpagerAds.adapter = sliderAdapterPropertyView

        // إعداد مؤشر النقاط
        setupDotsIndicator(sliderItems.size)

        // إعداد مستمع تغيير الصفحة للسلايدر
        binding.viewpagerAds.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateDotsIndicator(position) // تحديث مؤشر النقاط عند تغيير الصفحة
            }
        })

        // إعداد مستمع اللمس للسلايدر
        setupSliderTouchListener()

        // بدء التمرير التلقائي
        startAutoSliding()

    }

    /**
     * إعداد مستمع اللمس للسلايدر
     * للتحكم في التمرير التلقائي عند التفاعل مع السلايدر
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun setupSliderTouchListener() {
        binding.viewpagerAds.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    touchStartX = event.x
                    isAutoScrolling = false
                }
                MotionEvent.ACTION_UP -> {
                    touchEndX = event.x
                    val diffX = touchEndX - touchStartX

                    // التحقق من اتجاه التمرير
                    if (abs(diffX) > SWIPE_THRESHOLD) {
                        val currentItem = binding.viewpagerAds.currentItem
                        val itemCount = binding.viewpagerAds.adapter?.itemCount ?: 0

                        if (diffX > 0) {
                            // تمرير لليمين
                            binding.viewpagerAds.currentItem = if (currentItem == 0) itemCount - 1 else currentItem - 1
                        } else {
                            // تمرير لليسار
                            binding.viewpagerAds.currentItem = if (currentItem == itemCount - 1) 0 else currentItem + 1
                        }
                    }

                    // إعادة تشغيل التمرير التلقائي بعد فترة
                    sliderHandler.postDelayed({
                        isAutoScrolling = true
                    }, 3000)
                }
            }
            false
        }
    }

    /**
     * إعداد مؤشر النقاط للسلايدر
     * @param count عدد النقاط (يساوي عدد العناصر في السلايدر)
     */
    private fun setupDotsIndicator(count: Int) {
        binding.dotsIndicator.removeAllViews()
        for (i in 0 until count) {
            val dot = ImageView(this)
            // إعداد معلمات التخطيط مع الهوامش
            val params = MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            params.marginEnd = resources.getDimensionPixelSize(R.dimen.dot_margin)
            dot.layoutParams = params
            // تعيين شكل النقطة (نشطة أو غير نشطة)
            dot.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    if (i == 0) R.drawable.dot_active else R.drawable.dot_inactive,
                    null
                )
            )
            binding.dotsIndicator.addView(dot)
        }
    }

    /**
     * تحديث مؤشر النقاط عند تغيير الصفحة
     * @param selectedPosition موضع الصفحة المحددة
     */
    private fun updateDotsIndicator(selectedPosition: Int) {
        for (i in 0 until binding.dotsIndicator.childCount) {
            val dot = binding.dotsIndicator.getChildAt(i) as ImageView
            dot.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    if (i == selectedPosition) R.drawable.dot_active else R.drawable.dot_inactive,
                    null
                )
            )
        }
    }

    /**
     * بدء التمرير التلقائي للسلايدر
     */
    private fun startAutoSliding() {
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }

    private fun convertTimestampToDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = Date(timestamp)
        return sdf.format(date)
    }


}