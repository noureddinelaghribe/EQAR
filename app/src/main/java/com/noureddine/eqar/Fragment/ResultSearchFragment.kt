package com.noureddine.eqar.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.noureddine.eqar.Adapter.PropertyAdapter
import com.noureddine.eqar.Model.PropertyItem
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentHomeBinding
import com.noureddine.eqar.databinding.FragmentResultSearchBinding
import com.noureddine.eqar.utils.Constants.Companion.wilayasAr


class ResultSearchFragment : Fragment() {

    // ViewBinding للوصول إلى عناصر واجهة المستخدم
    private var _binding: FragmentResultSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentResultSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupResultSearch()
        setupAutoCompleteTextView()


    }


    private fun setupAutoCompleteTextView(){

        val locations: MutableList<String> = wilayasAr.toMutableList()

        val adapter = ArrayAdapter<String>(
            requireContext(),  // في Fragment استخدم requireContext()
            android.R.layout.simple_dropdown_item_1line,
            locations         // الآن هذا MutableList<String>
        )
        binding.autoCompleteTextView.setAdapter(adapter)

    }


    private fun setupResultSearch() {

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
                location = listOf(21,7),
                locationMap = "https://maps.google.com/?q=33.5731,-7.5898",
                imageRes = listOf(R.drawable.sample_property_1.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_3.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(1,2),
                type = 1,
                typePay = 3,
                linkVideo = "",
                features = listOf(1,2,3),
                isFavorite = true,
                isNegotiate = true,
                //isEquipped = true
            ),
            PropertyItem(
                id = "2",
                timestamp = 1749737907,
                typeProperty = 8,
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
                //isEquipped = true
            ),
            PropertyItem(
                id = "3",
                timestamp = 1749737907,
                typeProperty =4,
                startRent = 0L,
                description = "منزل كبير ومجهز، قابل للتبادل مع شقة في الدار البيضاء",
                price = 0,//حسب الاتفاق
                rentByMonth = false,
                minumRent = 0,
                floorNumber = 1,
                Area = 160,
                location = listOf(21,4),
                locationMap = "https://maps.google.com/?q=34.0331,-5.0003",
                imageRes = listOf(R.drawable.sample_property_3.toString(),R.drawable.sample_property_2.toString(),R.drawable.sample_property_1.toString(),R.drawable.sample_property_4.toString()),
                documents = listOf(3,2),
                type = 3,
                typePay = 1,
                linkVideo = "",
                features = listOf(1,2,3,4),
                isFavorite = true,
                isNegotiate = true,
                //isEquipped = false
            )
        )

        // إعداد المحول
        val propertyAdapter = PropertyAdapter(
            items = propertyItems,
            onItemClick = { property ->
                // معالجة النقر على العقار
                // TODO: الانتقال لصفحة تفاصيل العقار
            },
            onFavoriteClick = { property ->
                // معالجة النقر على زر المفضلة
                // TODO: إضافة/إزالة من المفضلة
            }
        )

        // إعداد RecyclerView
        binding.recyclerviewItems.apply {
            adapter = propertyAdapter
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
                )
            )
        }


//        val layoutManager = object : LinearLayoutManager(context) {
//            override fun canScrollVertically(): Boolean {
//                return false
//            }
//        }
//
//        // 1) Get a reference
//        val recyclerView = binding.recyclerviewItems
//
//        // 2) Set layout manager
//        recyclerView.layoutManager = layoutManager
//
//        // 3) Assign your adapter
//        recyclerView.adapter = propertyAdapter
//
//        // 4) (Optional) Add dividers between items
//        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//        recyclerView.addItemDecoration(divider)


        // إخفاء حالة التحميل وإظهار القائمة
//        binding.layoutLoading.visibility = View.GONE
//        binding.recyclerviewItems.visibility = View.VISIBLE

    }


}