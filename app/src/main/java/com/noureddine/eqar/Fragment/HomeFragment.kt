package com.noureddine.eqar.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.noureddine.eqar.Adapter.SliderAdapter
import com.noureddine.eqar.Model.SliderItem
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentHomeBinding
import com.noureddine.eqar.databinding.FragmentLoginBinding
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import android.view.ViewGroup.MarginLayoutParams
import android.view.MotionEvent
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.noureddine.eqar.Activity.PropertyViewActivity
import kotlin.math.abs
import com.noureddine.eqar.Adapter.PropertyAdapter
import com.noureddine.eqar.Dialog.ChatBotDialog
import com.noureddine.eqar.Dialog.ForgotPasswordDialog
import com.noureddine.eqar.Model.PropertyItem
import com.noureddine.eqar.utils.Constants

/**
 * HomeFragment - الصفحة الرئيسية للتطبيق
 * تحتوي على:
 * 1. شريط التبويب الرئيسي (عقارات - فنادق)
 * 2. شريط التبويب الثانوي (كراء - بيع - تبادل)
 * 3. سلايدر العروض المميزة
 * 4. قائمة العقارات المقترحة
 */
class HomeFragment : Fragment() {
    // ViewBinding للوصول إلى عناصر واجهة المستخدم
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    
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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners() // إعداد مستمعي النقر
        loadSliderHotelsdata()
        loadSliderRealEstatedata()
        loadRealEstatedata()
        loadHotelsdata()

        _binding?.layoutLoading?.visibility = View.GONE
        _binding?.layoutEmpty?.visibility = View.GONE

    }

    /**
     * إعداد مستمعي النقر للتبويبات
     * - التبويب الرئيسي (عقارات - فنادق)
     * - التبويب الثانوي (كراء - بيع - تبادل)
     */
    private fun setupClickListeners() {
        // مستمع نقر تبويب العقارات
        binding.cvTabRealEstate.setOnClickListener {
            // تحديث واجهة المستخدم
            binding.cvTabRealEstate.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primary_green))
            binding.tvTabRealEstate.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            binding.cvTabHotels.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.tvTabhotels.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_green))

            binding.tabLayoutSecondary.visibility = View.VISIBLE // إظهار التبويب الثانوي


        }

        // مستمع نقر تبويب الفنادق
        binding.cvTabHotels.setOnClickListener {
            // تحديث واجهة المستخدم
            binding.cvTabHotels.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.primary_green))
            binding.tvTabhotels.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            binding.cvTabRealEstate.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.tvTabRealEstate.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary_green))

            binding.tabLayoutSecondary.visibility = View.GONE // إخفاء التبويب الثانوي
        }

        // مستمع نقر زر المحادثة
        binding.fabChatbot.setOnClickListener {
            // يمكنك إضافة الكود الخاص بفتح نافذة المحادثة هنا

            ChatBotDialog.show(parentFragmentManager, object : ChatBotDialog.OnClickListener{
                override fun onItemClickSendMsg(msg: String?) {
                    Toast.makeText(requireContext(), "تم إرسال", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }

    /**
     * تحميل البيانات الافتراضية
     * - إعداد سلايدر العروض المميزة
     * - إعداد مؤشر النقاط
     * - بدء التمرير التلقائي
     */
    private fun loadSliderRealEstatedata() {
        // إعداد عناصر السلايدر
        val sliderItems = listOf(
            SliderItem(
                R.drawable.sample_property_1,
                "عقار فاخر للبيع",
                "شقة فاخرة في قلب المدينة مع إطلالة رائعة"
            ),
            SliderItem(
                R.drawable.sample_property_2,
                "محل تجاري للتبادل",
                "محل تجاري في موقع مميز"
            ),
            SliderItem(
                R.drawable.sample_property_3,
                "شقة للإيجار",
                "شقة حديثة في موقع مميز"
            )
        )

        setupSlider(sliderItems as MutableList<SliderItem>)

    }

    private fun loadSliderHotelsdata() {



    }

    private fun loadRealEstatedata() {
        // إعداد قائمة العقارات
        val propertyItems = listOf(
            PropertyItem(
                id = "1",
                timestamp = 1749737907,
                typeProperty = 1,
                startRent = 0L,
                description = "شقة حديثة في قلب المدينة مع إطلالة رائعة",
                price = 2500000,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 2,
                Area = 120,
                location = listOf(21,1),
                locationMap = "https://maps.google.com/?q=33.5731,-7.5898",
                imageRes = listOf(R.drawable.sample_property_1.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(1,2),
                type = 1,
                typePay = 3,
                linkVideo = "",
                features = listOf(1,2,3),
                isFavorite = true,
                isNegotiate = true,
                isEquipped = true
            ),
            PropertyItem(
                id = "2",
                timestamp = 1749737907,
                typeProperty = 2,
                startRent = System.currentTimeMillis(),
                description = "شقة صغيرة مثالية للطلاب",
                price = 3000,
                rentByMonth = true,
                minumRent = 3,
                floorNumber = 1,
                Area = 70,
                location = listOf(21,1),
                locationMap = "https://maps.google.com/?q=34.6828,-1.9092",
                imageRes = listOf(R.drawable.sample_property_2.toString(),R.drawable.sample_property_1.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(1,3),
                type = 2,
                typePay = 2,
                linkVideo = "",
                features = listOf(2,4,3),
                isFavorite = false,
                isNegotiate = false,
                isEquipped = true
            ),
            PropertyItem(
                id = "3",
                timestamp = 1749737907,
                typeProperty = 4,
                startRent = 0L,
                description = "منزل كبير ومجهز، قابل للتبادل مع شقة في الدار البيضاء",
                price = 0, //حسب الاتفاق
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 1,
                Area = 160,
                location = listOf(21,4),
                locationMap = "https://maps.google.com/?q=34.0331,-5.0003",
                imageRes = listOf(R.drawable.sample_property_3.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_1.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(3,2),
                type = 0,
                typePay = 1,
                linkVideo = "",
                features = listOf(1,2,3,4),
                isFavorite = true,
                isNegotiate = true,
                isEquipped = false
            ),
            PropertyItem(
                id = "4",
                timestamp = 1749737907,
                typeProperty = 1,
                startRent = 0L,
                description = "فيلا راقية في منطقة هادئة",
                price = 5000000,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 2,
                Area = 300,
                location = listOf(34,2),
                locationMap = "https://maps.google.com/?q=31.6347,-7.9894",
                imageRes = listOf(R.drawable.sample_property_4.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_1.toString()),
                documents = listOf(1,2,4),
                type = 1,
                typePay = 0,
                linkVideo = "",
                features = listOf(2,3),
                isFavorite = true,
                isNegotiate = true,
                isEquipped = true
            ),
            PropertyItem(
                id = "5",
                timestamp = 1749737907,
                typeProperty = 2,
                startRent = System.currentTimeMillis(),
                description = "شقة مفروشة في وسط المدينة",
                price = 4500,
                rentByMonth = true,
                minumRent = 6,
                floorNumber = 5,
                Area = 90,
                location = listOf(21,1),
                locationMap = "https://maps.google.com/?q=30.4278,-9.5981",
                imageRes = listOf(R.drawable.sample_property_2.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(3),
                type = 2,
                typePay = 1,
                linkVideo = "",
                features = listOf(3),
                isFavorite = false,
                isNegotiate = false,
                isEquipped = true
            ),
            PropertyItem(
                id = "6",
                timestamp = 1749737907,
                typeProperty = 7,
                startRent = 0L,
                description = "شقة مجهزة بالكامل للتبادل في منطقة سياحية",
                price = 0,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 4,
                Area = 85,
                location = listOf(23,2),
                locationMap = "https://maps.google.com/?q=35.7796,-5.8136",
                imageRes = listOf(R.drawable.sample_property_4.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(4),
                type = 0,
                typePay = 1,
                linkVideo = "",
                features = listOf(1,2),
                isFavorite = true,
                isNegotiate = true,
                isEquipped = true
            ),
            PropertyItem(
                id = "7",
                timestamp = 1749737907,
                typeProperty = 5,
                startRent = 0L,
                description = "منزل مستقل على الطراز التقليدي",
                price = 1800000,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 1,
                Area = 140,
                location = listOf(2,1),
                locationMap = "https://maps.google.com/?q=35.5785,-5.3684",
                imageRes = listOf(R.drawable.sample_property_1.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(1,2),
                type = 1,
                typePay = 2,
                linkVideo = "",
                features = listOf(1,2,3),
                isFavorite = false,
                isNegotiate = true,
                isEquipped = false
            ),
            PropertyItem(
                id = "8",
                timestamp = 1749737907,
                typeProperty = 1,
                startRent = System.currentTimeMillis(),
                description = "شقة في عمارة حديثة مع مصعد وأمن",
                price = 6000,
                rentByMonth = true,
                minumRent = 12,
                floorNumber = 6,
                Area = 110,
                location = listOf(1,1),
                locationMap = "https://maps.google.com/?q=34.0209,-6.8416",
                imageRes = listOf(R.drawable.sample_property_2.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(4),
                type = 2,
                typePay = 3,
                linkVideo = "",
                features = listOf(1,2,3,4,5),
                isFavorite = true,
                isNegotiate = false,
                isEquipped = true
            ),
            PropertyItem(
                id = "9",
                timestamp = 1749737907,
                typeProperty = 7,
                startRent = 0L,
                description = "فيلا كبيرة جاهزة للسكن وقابلة للتبادل",
                price = 0,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 2,
                Area = 280,
                location = listOf(16,2),
                locationMap = "https://maps.google.com/?q=33.2344,-8.5001",
                imageRes = listOf(R.drawable.sample_property_3.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(2),
                type = 0,
                typePay = 0,
                linkVideo = "",
                features = listOf(1,2,3),
                isFavorite = false,
                isNegotiate = true,
                isEquipped = true
            ),
            PropertyItem(
                id = "10",
                timestamp = 1749737907,
                typeProperty = 4,
                startRent = 0L,
                description = "شقة اقتصادية مناسبة للأزواج الجدد",
                price = 850000,
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 3,
                Area = 60,
                location = listOf(25,1),
                locationMap = "https://maps.google.com/?q=34.0331,-6.7985",
                imageRes = listOf(R.drawable.sample_property_1.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(1),
                type = 1,
                typePay = 2,
                linkVideo = "",
                features = listOf(1,2,3),
                isFavorite = false,
                isNegotiate = false,
                isEquipped = false
            )
        )


        // إعداد المحول
        val propertyAdapter = PropertyAdapter(
            items = propertyItems,
            onItemClick = { property ->
                // معالجة النقر على العقار
                // TODO: الانتقال لصفحة تفاصيل العقار

                val intent = Intent(requireContext(), PropertyViewActivity::class.java)
                intent.putExtra("property", property)
                startActivity(intent)


            },
            onFavoriteClick = { property ->
                // معالجة النقر على زر المفضلة
                // TODO: إضافة/إزالة من المفضلة

            }
        )

//        // إعداد RecyclerView
//        binding.recyclerviewItems.apply {
//            adapter = propertyAdapter
//            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
//            addItemDecoration(
//                androidx.recyclerview.widget.DividerItemDecoration(
//                    context,
//                    androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
//                )
//            )
//        }


        val layoutManager = object : LinearLayoutManager(context) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        // 1) Get a reference
        val recyclerView = binding.recyclerviewItems

        // 2) Set layout manager
        recyclerView.layoutManager = layoutManager

        // 3) Assign your adapter
        recyclerView.adapter = propertyAdapter

        // 4) (Optional) Add dividers between items
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divider)


        // إخفاء حالة التحميل وإظهار القائمة
        binding.layoutLoading.visibility = View.GONE
        binding.recyclerviewItems.visibility = View.VISIBLE
    }


    private fun loadHotelsdata() {



    }


    private fun setupSlider(sliderItems: MutableList<SliderItem>){

        // إعداد محول السلايدر
        val sliderAdapter = SliderAdapter(sliderItems)
        binding.viewpagerAds.adapter = sliderAdapter

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
            val dot = ImageView(requireContext())
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



    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable) // إيقاف التمرير التلقائي عند إيقاف التطبيق
    }

    override fun onResume() {
        super.onResume()
        startAutoSliding() // إعادة بدء التمرير التلقائي عند استئناف التطبيق
    }

    override fun onDestroyView() {
        super.onDestroyView()
        sliderHandler.removeCallbacks(sliderRunnable) // تنظيف الموارد
        binding.viewpagerAds.unregisterOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {})
        _binding = null
    }
}