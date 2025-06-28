package com.noureddine.eqar.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentAdvancedSearchBinding
import android.text.Editable
import com.noureddine.eqar.Adapter.toggleAdapter
import com.noureddine.eqar.Model.ToggleBtn
import com.noureddine.eqar.utils.Constants.Companion.wilayaToBaladiasAr
import com.noureddine.eqar.utils.Constants.Companion.wilayasAr
import java.util.Calendar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [advancedSearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdvancedSearchFragment : Fragment() {
    private var _binding: FragmentAdvancedSearchBinding? = null
    private val binding get() = _binding!!

    // Search state
    private var selectedPropertyType: String? = null
    private var selectedOperationType: String? = null
    private var minPrice: String? = null
    private var maxPrice: String? = null
    private var selectedFeatures = mutableListOf<String>()
    private var selectedWilaya: String? = null
    private var selectedBaladia: String? = null
    private var selectedFurnishedStatus: String? = null
    private var checkInDate: String? = null
    private var checkOutDate: String? = null
    private var selectedStarRatings = mutableSetOf<Int>()

    private val operationTypeItems: MutableList<ToggleBtn> = mutableListOf()
    private val propertyNameItems: MutableList<ToggleBtn> = mutableListOf()
    private val featuresItems: MutableList<ToggleBtn> = mutableListOf()
    private val StarRatingItems: MutableList<ToggleBtn> = mutableListOf()
    private val typeResidenceItems: MutableList<ToggleBtn> = mutableListOf()
    private val featuresHotelItems: MutableList<ToggleBtn> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAdvancedSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinners()
        setupPropertyTypeSelection()
        setupOperationTypeSelection()
        setupFeaturesSelection()
        setupFurnishedStatusSelection()
        setupPriceRangeSlider()
        setupHotelPriceRangeSlider()
        setupDatePickers()
        setupStarRatingSelection()
        setupTypeResidence()
        setupFeaturesHotel()
        setupButtons()
    }

    private fun setupSpinners() {
        // Setup Wilaya spinner
        val wilayaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, wilayasAr)
        (binding.spinnerWilaya as? AutoCompleteTextView)?.apply {
            setAdapter(wilayaAdapter)
            setOnItemClickListener { _, _, position, _ ->
                selectedWilaya = wilayasAr[position]
                updateBaladiaSpinner(selectedWilaya)
            }
        }

        // Setup Baladia spinner
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setOnItemClickListener { _, _, position, _ ->
                val baladias = wilayaToBaladiasAr[selectedWilaya] ?: emptyList()
                if (position < baladias.size) {
                    selectedBaladia = baladias[position]
                }
            }
        }
    }

    private fun updateBaladiaSpinner(selectedWilaya: String?) {
        val baladias = wilayaToBaladiasAr[selectedWilaya] ?: emptyList()
        val baladiaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, baladias)
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setAdapter(baladiaAdapter)
            setText("") // Clear previous selection
        }
    }

    private fun setupPropertyTypeSelection() {

        binding.toggleRealestate.isChecked = true
        binding.toggleHotels.isChecked = false
        binding.llHotels.visibility = View.GONE
        binding.llRealestate.visibility = View.VISIBLE

        // Real Estate vs Hotels toggle
        binding.toggleRealestate.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Real Estate", Toast.LENGTH_SHORT).show()
                binding.toggleHotels.isChecked = false
                binding.llHotels.visibility = View.GONE
                binding.llRealestate.visibility = View.VISIBLE
            }
        }

        binding.toggleHotels.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Hotels", Toast.LENGTH_SHORT).show()
                binding.toggleRealestate.isChecked = false
                binding.llHotels.visibility = View.VISIBLE
                binding.llRealestate.visibility = View.GONE
            }
        }

        // Property type toggles
//        val propertyTypeToggles = mapOf(
//            binding.toggleApartment to "شقة",
//            binding.toggleHouse to "منزل",
//            binding.toggleCommercial to "محل تجاري",
//            binding.toggleVilla to "فيلا",
//            binding.togglePartyHall to "قاعة حفلات"
//        )
//
//        propertyTypeToggles.forEach { (toggle, type) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    selectedPropertyType = type
//                    // Uncheck other toggles
//                    propertyTypeToggles.forEach { (otherToggle, _) ->
//                        if (otherToggle != toggle) {
//                            otherToggle.isChecked = false
//                        }
//                    }
//                } else if (selectedPropertyType == type) {
//                    selectedPropertyType = null
//                }
//            }
//        }

        propertyNameItems.add(ToggleBtn("شقة",false))
        propertyNameItems.add(ToggleBtn("بيت طابق",false))
        propertyNameItems.add(ToggleBtn("كوخ",false))
        propertyNameItems.add(ToggleBtn("مجمع سياحي",false))
        propertyNameItems.add(ToggleBtn("مرقد",false))
        propertyNameItems.add(ToggleBtn("دوبلكس",false))
        propertyNameItems.add(ToggleBtn("محل تجاري",false))
        propertyNameItems.add(ToggleBtn("فيلا",false))
        propertyNameItems.add(ToggleBtn("قاعة حفلات",false))
        propertyNameItems.add(ToggleBtn("ستوديو",false))
        propertyNameItems.add(ToggleBtn("أرض",false))
        propertyNameItems.add(ToggleBtn("أرض فلاحية",false))
        propertyNameItems.add(ToggleBtn("عمارة",false))
        propertyNameItems.add(ToggleBtn("بالڨالو",false))
        propertyNameItems.add(ToggleBtn("مستودع - مصنع",false))
        propertyNameItems.add(ToggleBtn("آخر",false))

        // إعداد RecyclerView
        binding.PropertyNameRecyclerView.apply {
            adapter = toggleAdapter(propertyNameItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }

    }

    private fun setupOperationTypeSelection() {

        operationTypeItems.add(ToggleBtn("كراء",false))
        operationTypeItems.add(ToggleBtn("بيع",false))
        operationTypeItems.add(ToggleBtn("تبادل",false))

        // إعداد RecyclerView

        binding.typeOperationRecyclerView.apply {
            adapter = toggleAdapter(operationTypeItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }

//        val operationTypeToggles = mapOf(
//            binding.toggleRent to "كراء",
//            binding.toggleSale to "بيع",
//            binding.toggleExchange to "تبادل"
//        )
//        operationTypeToggles.forEach { (toggle, type) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    // Uncheck all other toggles in the group
//                    operationTypeToggles.keys.forEach { otherToggle ->
//                        if (otherToggle != toggle) {
//                            otherToggle.isChecked = false
//                        }
//                    }
//                    selectedOperationType = type
//                } else {
//                    selectedOperationType = null
//                }
//            }
//        }
    }

    private fun setupFeaturesSelection() {

        featuresItems.add(ToggleBtn("موقف سيارة",false))
        featuresItems.add(ToggleBtn("حديقة",false))
        featuresItems.add(ToggleBtn("بركة سباحة",false))
        featuresItems.add(ToggleBtn("حراسة",false))


        // إعداد RecyclerView

        binding.featuresRecyclerView.apply {
            adapter = toggleAdapter(featuresItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }

//        val featureToggles = mapOf(
//            binding.toggleParking to "موقف سيارة",
//            binding.toggleGarden to "حديقة",
//            binding.togglePool to "بركة سباحة",
//            binding.toggleSecurity to "حراسة"
//        )
//
//        featureToggles.forEach { (toggle, feature) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    selectedFeatures.add(feature)
//                } else {
//                    selectedFeatures.remove(feature)
//                }
//            }
//        }

    }

    private fun setupFurnishedStatusSelection() {
        val furnishedToggles = mapOf(
            binding.toggleFurnishedYes to "نعم",
            binding.toggleFurnishedNo to "لا",
            binding.toggleFurnishedDoesntMatter to "لايهم"
        )

        furnishedToggles.forEach { (toggle, status) ->
            toggle.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // Uncheck all other toggles in the group
                    furnishedToggles.keys.forEach { otherToggle ->
                        if (otherToggle != toggle) {
                            otherToggle.isChecked = false
                        }
                    }
                    selectedFurnishedStatus = status
                } else {
                    selectedFurnishedStatus = null
                }
            }
        }
    }

    private fun setupPriceRangeSlider() {
        binding.priceRangeSlider.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val minPrice = values[0].toInt()
            val maxPrice = values[1].toInt()

            // Update the text fields
            binding.etMinPrice.setText(minPrice.toString())
            binding.etMaxPrice.setText(maxPrice.toString())
        }

        // Update slider when text fields change
        binding.etMinPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val minPrice = s.toString().toIntOrNull() ?: 0
                val maxPrice = binding.etMaxPrice.text.toString().toIntOrNull() ?: 100000
                if (minPrice <= maxPrice) {
                    binding.priceRangeSlider.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })

        binding.etMaxPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val maxPrice = s.toString().toIntOrNull() ?: 100000
                val minPrice = binding.etMinPrice.text.toString().toIntOrNull() ?: 0
                if (minPrice <= maxPrice) {
                    binding.priceRangeSlider.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })
    }

    private fun setupHotelPriceRangeSlider() {

        binding.priceRangeSliderHotel.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val minPrice = values[0].toInt()
            val maxPrice = values[1].toInt()

            // Update the text fields
            binding.etMinPriceHotel.setText(minPrice.toString())
            binding.etMaxPriceHotel.setText(maxPrice.toString())
        }

        // Update slider when text fields change
        binding.etMinPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val minPrice = s.toString().toIntOrNull() ?: 0
                val maxPrice = binding.etMaxPriceHotel.text.toString().toIntOrNull() ?: 100000
                if (minPrice <= maxPrice) {
                    binding.priceRangeSliderHotel.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })

        binding.etMaxPrice.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val maxPrice = s.toString().toIntOrNull() ?: 100000
                val minPrice = binding.etMinPriceHotel.text.toString().toIntOrNull() ?: 0
                if (minPrice <= maxPrice) {
                    binding.priceRangeSliderHotel.setValues(minPrice.toFloat(), maxPrice.toFloat())
                }
            }
        })


    }

    private fun setupButtons() {
        binding.btnSearch.setOnClickListener {
            performSearch()
        }

        binding.btnReset.setOnClickListener {
            resetSearch()
        }
    }

    private fun setupDatePickers() {
        binding.etCheckInDateHotel.setOnClickListener {
            showDatePicker(true)
        }

        binding.etCheckOutDateHotel.setOnClickListener {
            showDatePicker(false)
        }
    }

    private fun setupStarRatingSelection() {

        StarRatingItems.add(ToggleBtn("★",false))
        StarRatingItems.add(ToggleBtn("★★",false))
        StarRatingItems.add(ToggleBtn("★★★",false))
        StarRatingItems.add(ToggleBtn("★★★★",false))
        StarRatingItems.add(ToggleBtn("★★★★★",false))

        // إعداد RecyclerView

        binding.starRatingRecyclerView.apply {
            adapter = toggleAdapter(StarRatingItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }


//        val starRatingToggles = mapOf(
//            binding.toggle5StarHotel to 5,
//            binding.toggle4StarHotel to 4,
//            binding.toggle3StarHotel to 3,
//            binding.toggle2StarHotel to 2,
//            binding.toggle1StarHotel to 1
//        )
//
//        starRatingToggles.forEach { (toggle, stars) ->
//            toggle.setOnCheckedChangeListener { _, isChecked ->
//                if (isChecked) {
//                    selectedStarRatings.add(stars)
//                } else {
//                    selectedStarRatings.remove(stars)
//                }
//            }
//        }


    }

    private fun setupTypeResidence(){

        typeResidenceItems.add(ToggleBtn("فندق",false))
        typeResidenceItems.add(ToggleBtn("منتجع",false))
        typeResidenceItems.add(ToggleBtn("شقق فندقية",false))
        typeResidenceItems.add(ToggleBtn("بيت ضيافة",false))
        typeResidenceItems.add(ToggleBtn("نزل",false))
        typeResidenceItems.add(ToggleBtn("موتيل",false))
        typeResidenceItems.add(ToggleBtn("مخيم",false))

        // إعداد RecyclerView

        binding.typeResidenceRecyclerView.apply {
            adapter = toggleAdapter(typeResidenceItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }

    }

    private fun setupFeaturesHotel(){

        featuresHotelItems.add(ToggleBtn("واي فاي مجاني",false))
        featuresHotelItems.add(ToggleBtn("إفطار مجاني",false))
        featuresHotelItems.add(ToggleBtn("موقف سيارات",false))
        featuresHotelItems.add(ToggleBtn("مسبح",false))
        featuresHotelItems.add(ToggleBtn("صالة رياضية",false))
        featuresHotelItems.add(ToggleBtn("سبا",false))
        featuresHotelItems.add(ToggleBtn("مطعم",false))
        featuresHotelItems.add(ToggleBtn("خدمة الغرف",false))
        featuresHotelItems.add(ToggleBtn("يقبل الحيوانات",false))

        // إعداد RecyclerView

        binding.featuresHotelRecyclerView.apply {
            adapter = toggleAdapter(featuresHotelItems)
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                context,
                androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL,
                false
            )
            addItemDecoration(
                androidx.recyclerview.widget.DividerItemDecoration(
                    context,
                    androidx.recyclerview.widget.DividerItemDecoration.HORIZONTAL
                )
            )
        }

    }




    private fun showDatePicker(isCheckIn: Boolean) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%02d/%02d/%04d", selectedDay, selectedMonth + 1, selectedYear)
                if (isCheckIn) {
                    binding.etCheckInDateHotel.setText(formattedDate)
                    checkInDate = formattedDate
                } else {
                    binding.etCheckOutDateHotel.setText(formattedDate)
                    checkOutDate = formattedDate
                }
            },
            year,
            month,
            day
        )

        // Set minimum date to today for check-in
        if (isCheckIn) {
            datePickerDialog.datePicker.minDate = System.currentTimeMillis()
        } else {
            // For check-out, set minimum date to check-in date if it exists
            if (!checkInDate.isNullOrEmpty()) {
                val checkInCalendar = Calendar.getInstance()
                val checkInParts = checkInDate!!.split("/")
                checkInCalendar.set(
                    checkInParts[2].toInt(),
                    checkInParts[1].toInt() - 1,
                    checkInParts[0].toInt()
                )
                datePickerDialog.datePicker.minDate = checkInCalendar.timeInMillis
            } else {
                datePickerDialog.datePicker.minDate = System.currentTimeMillis()
            }
        }

        datePickerDialog.show()
    }


//    private fun updateStarRatingUI() {
//        // Update UI elements based on selected star ratings
//        binding.toggle5StarHotel.isChecked = selectedStarRatings.contains(5)
//        binding.toggle4StarHotel.isChecked = selectedStarRatings.contains(4)
//        binding.toggle3StarHotel.isChecked = selectedStarRatings.contains(3)
//        binding.toggle2StarHotel.isChecked = selectedStarRatings.contains(2)
//        binding.toggle1StarHotel.isChecked = selectedStarRatings.contains(1)
//    }


    private fun performSearch() {
        // Get price range
        minPrice = binding.etMinPrice.text?.toString()
        maxPrice = binding.etMaxPrice.text?.toString()

        // Validate inputs
        if (selectedPropertyType == null) {
            Toast.makeText(context, "الرجاء اختيار نوع العقار", Toast.LENGTH_SHORT).show()
            return
        }

        if (selectedOperationType == null) {
            Toast.makeText(context, "الرجاء اختيار نوع العملية", Toast.LENGTH_SHORT).show()
            return
        }

        if (selectedWilaya == null) {
            Toast.makeText(context, "الرجاء اختيار الولاية", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate dates if provided
        if (!checkInDate.isNullOrEmpty() && !checkOutDate.isNullOrEmpty()) {
            val checkInParts = checkInDate!!.split("/")
            val checkOutParts = checkOutDate!!.split("/")

            val checkInCalendar = Calendar.getInstance().apply {
                set(checkInParts[2].toInt(), checkInParts[1].toInt() - 1, checkInParts[0].toInt())
            }

            val checkOutCalendar = Calendar.getInstance().apply {
                set(checkOutParts[2].toInt(), checkOutParts[1].toInt() - 1, checkOutParts[0].toInt())
            }

            if (checkOutCalendar.before(checkInCalendar)) {
                Toast.makeText(context, "تاريخ المغادرة يجب أن يكون بعد تاريخ الوصول", Toast.LENGTH_SHORT).show()
                return
            }
        }


        // Validate price range if provided
        if (!minPrice.isNullOrEmpty() && !maxPrice.isNullOrEmpty()) {
            val min = minPrice!!.toIntOrNull()
            val max = maxPrice!!.toIntOrNull()

            if (min == null || max == null) {
                Toast.makeText(context, "الرجاء إدخال قيم صحيحة للسعر", Toast.LENGTH_SHORT).show()
                return
            }

            if (min > max) {
                Toast.makeText(context, "السعر الأدنى يجب أن يكون أقل من السعر الأقصى", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Create search parameters
        val searchParams = mapOf(
            "propertyType" to selectedPropertyType,
            "operationType" to selectedOperationType,
            "wilaya" to selectedWilaya,
            "baladia" to selectedBaladia,
            "minPrice" to minPrice,
            "maxPrice" to maxPrice,
            "features" to selectedFeatures.toList(),
            "furnished" to selectedFurnishedStatus,
            "furnished" to selectedFurnishedStatus,
            "checkInDate" to checkInDate,
            "checkOutDate" to checkOutDate,
            "starRatings" to selectedStarRatings.toList()
        )

        // TODO: Implement search logic with the parameters
        Toast.makeText(context, "جاري البحث...", Toast.LENGTH_SHORT).show()
    }

    private fun resetSearch() {
        // Reset property type selection
        binding.toggleRealestate.isChecked = true
        binding.toggleHotels.isChecked = false
        selectedPropertyType = null

        // Reset operation type selection
//        binding.toggleRent.isChecked = false
//        binding.toggleSale.isChecked = false
//        binding.toggleExchange.isChecked = false

        operationTypeItems.clear()
        selectedOperationType = null

        // Reset features selection
//        binding.toggleParking.isChecked = false
//        binding.toggleGarden.isChecked = false
//        binding.togglePool.isChecked = false
//        binding.toggleSecurity.isChecked = false
//        selectedFeatures.clear()
        featuresItems.clear()

        // Reset furnished status
        binding.toggleFurnishedYes.isChecked = false
        binding.toggleFurnishedNo.isChecked = false
        binding.toggleFurnishedDoesntMatter.isChecked = false
        selectedFurnishedStatus = null

        // Reset price range
        binding.etMinPrice.text?.clear()
        binding.etMaxPrice.text?.clear()
        binding.priceRangeSlider.setValues(0f, 100000f)

        // Reset hotel price range
//        binding.etMinPriceHotel.text?.clear()
//        binding.etMaxPriceHotel.text?.clear()
//        binding.priceRangeSliderHotel.setValues(0f, 100000f)

        // Reset dates
//        binding.etCheckInDateHotel.text?.clear()
//        binding.etCheckOutDateHotel.text?.clear()
        checkInDate = null
        checkOutDate = null

        // Reset star ratings
//        binding.toggle5StarHotel.isChecked = false
//        binding.toggle4StarHotel.isChecked = false
//        binding.toggle3StarHotel.isChecked = false
//        binding.toggle2StarHotel.isChecked = false
//        binding.toggle1StarHotel.isChecked = false
        selectedStarRatings.clear()

        // Reset location
        binding.spinnerWilaya.setText("", false)
        binding.spinnerBaladia.setText("", false)
        selectedWilaya = null
        selectedBaladia = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
