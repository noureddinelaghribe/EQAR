package com.noureddine.eqar.Fragment

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.noureddine.eqar.R
import com.noureddine.eqar.databinding.FragmentAddRealStateBinding
import com.noureddine.eqar.databinding.FragmentAdvancedSearchBinding
import com.noureddine.eqar.utils.Constants.Companion.wilayaToBaladiasFr
import com.noureddine.eqar.utils.Constants.Companion.wilayasFr
import java.util.ArrayList
import java.util.List
import kotlin.collections.get

class AddRealStateFragment : Fragment() {
    private var _binding: FragmentAddRealStateBinding? = null
    private val binding get() = _binding!!
    
    private var floorNumber = 0
    private var duration = 1
    private var isDailyRental = true

    private var selectedWilaya: String? = null
    private var selectedBaladia: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAddRealStateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupListeners()
        setupLocationSpinners()
        setupRentalPreference()
        setupPropertyFeatures()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupPropertyFeatures() {
        // Floor number increment/decrement
        binding.btnIncrementFloor.setOnClickListener {
            floorNumber++
            updateFloorNumber()
        }
        binding.btnDecrementFloor.setOnClickListener {
            if (floorNumber > 0) {
                floorNumber--
                updateFloorNumber()
            }
        }
    }

    private fun updateFloorNumber() {
        binding.tvFloorNumber.text = floorNumber.toString()
    }

    private fun setupRentalPreference() {
        // Duration increment/decrement
        binding.btnIncrementDuration.setOnClickListener {
            duration++
            updateDurationText()
        }
        binding.btnDecrementDuration.setOnClickListener {
            if (duration > 1) {
                duration--
                updateDurationText()
            }
        }

        // Daily/Monthly selection
        binding.cardDaily.setOnClickListener {
            isDailyRental = true
            updateRentalTypeSelection()
            updateDurationText()
        }
        binding.cardMonthly.setOnClickListener {
            isDailyRental = false
            updateRentalTypeSelection()
            updateDurationText()
        }

        // Set initial state
        updateRentalTypeSelection()
    }

    private fun updateRentalTypeSelection() {
        if (isDailyRental) {
            binding.cardDaily.setCardBackgroundColor(resources.getColor(R.color.primary_blue, null))
            binding.cardMonthly.setCardBackgroundColor(resources.getColor(R.color.white, null))
            binding.cardDaily.strokeWidth = 0
            binding.cardMonthly.strokeWidth = 1
            
            // Change Daily card colors to white
            binding.cardDaily.findViewById<ImageView>(R.id.ivDaily)?.setColorFilter(resources.getColor(R.color.white, null))
            binding.cardDaily.findViewById<TextView>(R.id.tvDaily)?.setTextColor(resources.getColor(R.color.white, null))
            
            // Change Monthly card colors to primary_blue
            binding.cardMonthly.findViewById<ImageView>(R.id.ivMonthly)?.setColorFilter(resources.getColor(R.color.primary_blue, null))
            binding.cardMonthly.findViewById<TextView>(R.id.tvMonthly)?.setTextColor(resources.getColor(R.color.primary_blue, null))
        } else {
            binding.cardDaily.setCardBackgroundColor(resources.getColor(R.color.white, null))
            binding.cardMonthly.setCardBackgroundColor(resources.getColor(R.color.primary_blue, null))
            binding.cardDaily.strokeWidth = 1
            binding.cardMonthly.strokeWidth = 0
            
            // Change Daily card colors to primary_blue
            binding.cardDaily.findViewById<ImageView>(R.id.ivDaily)?.setColorFilter(resources.getColor(R.color.primary_blue, null))
            binding.cardDaily.findViewById<TextView>(R.id.tvDaily)?.setTextColor(resources.getColor(R.color.primary_blue, null))
            
            // Change Monthly card colors to white
            binding.cardMonthly.findViewById<ImageView>(R.id.ivMonthly)?.setColorFilter(resources.getColor(R.color.white, null))
            binding.cardMonthly.findViewById<TextView>(R.id.tvMonthly)?.setTextColor(resources.getColor(R.color.white, null))
        }
    }

    private fun updateDurationText() {
        val unit = if (isDailyRental) "يوم" else "شهر"
        binding.tvDuration.text = "$duration $unit"
    }


    private fun setupViews(){

        binding.cardOperationType.visibility = View.GONE
        //binding.cardFullName.visibility = View.GONE
        //binding.cardGender.visibility = View.GONE
        //binding.cardFamilyStatus.visibility = View.GONE
        //binding.cardYearOfBirth.visibility = View.GONE
        binding.cardStartOfRent.visibility = View.GONE
        binding.cardLocation.visibility = View.GONE
        binding.cardRealEstateType.visibility = View.GONE
        binding.cardFeatures.visibility = View.GONE
        binding.cardFurnished.visibility = View.GONE
        binding.cardRentalDuration.visibility = View.GONE
        binding.cardRentalPrice.visibility = View.GONE
        binding.cardRangeOfPrice.visibility = View.GONE
        binding.cardPropertyDetails.visibility = View.GONE
        binding.documentsChipGroup.visibility = View.GONE
        binding.paymentMethodChipGroup.visibility = View.GONE
        binding.cardImages.visibility = View.GONE
        binding.cardDescription.visibility = View.GONE

    }


    private fun setupListeners() {
        // Main type toggle listeners
        binding.toggleAddMyRealestate.setOnCheckedChangeListener { buttonView, isChecked ->
                        if (isChecked) {
                            binding.toggleAddRequest.setChecked(false)
                            binding.cardOperationType.visibility = View.VISIBLE
                        }
        }
        binding.toggleAddRequest.setOnCheckedChangeListener { buttonView, isChecked ->
                        if (isChecked) {
                            binding.toggleAddMyRealestate.setChecked(false);
                            binding.cardOperationType.visibility = View.VISIBLE
                        }
        }

        setupSpinners()

        // Operation type toggle listeners
        setupOperationTypeListeners()

        // Property type toggle listeners
        setupPropertyTypeListeners()

        // Features toggle listeners
        setupFeaturesListeners()

        // Furnished toggle listeners
        setupFurnishedListeners()

        // Payment method toggle listeners
        setupPaymentMethodListeners()

        // Price range slider listeners
        setupPriceRangeSlider()
    }

    private fun setupSpinners() {
        // Setup Wilaya spinner
        val wilayaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, wilayasFr)
        (binding.spinnerWilaya as? AutoCompleteTextView)?.apply {
            setAdapter(wilayaAdapter)
            setOnItemClickListener { _, _, position, _ ->
                selectedWilaya = wilayasFr[position]
                updateBaladiaSpinner(selectedWilaya)
            }
        }

        // Setup Baladia spinner
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setOnItemClickListener { _, _, position, _ ->
                val baladias = wilayaToBaladiasFr[selectedWilaya] ?: emptyList()
                if (position < baladias.size) {
                    selectedBaladia = baladias[position]
                }
            }
        }
    }

    private fun updateBaladiaSpinner(selectedWilaya: String?) {
        val baladias = wilayaToBaladiasFr[selectedWilaya] ?: emptyList()
        val baladiaAdapter = ArrayAdapter(requireContext(), R.layout.item_dropdown, baladias)
        (binding.spinnerBaladia as? AutoCompleteTextView)?.apply {
            setAdapter(baladiaAdapter)
            setText("") // Clear previous selection
        }
    }

    private fun setupOperationTypeListeners() {
        binding.toggleRent.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleSale.isChecked = false
                binding.toggleExchange.isChecked = false

                if (binding.toggleAddMyRealestate.isChecked){

                    // my real estate for rent

                    //binding.cardFullName.visibility = View.GONE
                    //binding.cardGender.visibility = View.GONE
                    //binding.cardFamilyStatus.visibility = View.GONE
                    //binding.cardYearOfBirth.visibility = View.GONE
                    binding.cardStartOfRent.visibility = View.GONE
                    binding.cardRangeOfPrice.visibility = View.GONE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.VISIBLE
                    binding.cardPropertyDetails.visibility = View.VISIBLE
                    binding.documentsChipGroup.visibility = View.GONE
                    binding.paymentMethodChipGroup.visibility = View.GONE
                    binding.cardImages.visibility = View.VISIBLE
                    binding.cardDescription.visibility = View.VISIBLE


                }else if (binding.toggleAddRequest.isChecked){

                    // looking for rent

                    //binding.cardFullName.visibility = View.VISIBLE
                    //binding.cardGender.visibility = View.VISIBLE
                    //binding.cardFamilyStatus.visibility = View.VISIBLE
                    //binding.cardYearOfBirth.visibility = View.VISIBLE
                    binding.cardStartOfRent.visibility = View.VISIBLE
                    binding.cardRangeOfPrice.visibility = View.VISIBLE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.GONE
                    binding.cardPropertyDetails.visibility = View.VISIBLE
                    binding.documentsChipGroup.visibility = View.GONE
                    binding.paymentMethodChipGroup.visibility = View.GONE
                    binding.cardImages.visibility = View.GONE
                    binding.cardDescription.visibility = View.GONE

                }

            }
        }
        binding.toggleSale.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleRent.isChecked = false
                binding.toggleExchange.isChecked = false

                if (binding.toggleAddMyRealestate.isChecked){

                    // my real estate for Sale

                    //binding.cardFullName.visibility = View.GONE
                    //binding.cardGender.visibility = View.GONE
                    //binding.cardFamilyStatus.visibility = View.GONE
                    //binding.cardYearOfBirth.visibility = View.GONE
                    binding.cardStartOfRent.visibility = View.GONE
                    binding.cardRangeOfPrice.visibility = View.GONE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.VISIBLE
                    binding.cardPropertyDetails.visibility = View.GONE
                    binding.documentsChipGroup.visibility = View.VISIBLE
                    binding.paymentMethodChipGroup.visibility = View.VISIBLE
                    binding.cardImages.visibility = View.VISIBLE
                    binding.cardDescription.visibility = View.VISIBLE


                }else if (binding.toggleAddRequest.isChecked){

                    // looking for Sale

//                    binding.cardFullName.visibility = View.VISIBLE
//                    binding.cardGender.visibility = View.GONE
//                    binding.cardFamilyStatus.visibility = View.GONE
//                    binding.cardYearOfBirth.visibility = View.GONE
                    binding.cardStartOfRent.visibility = View.GONE
                    binding.cardRangeOfPrice.visibility = View.VISIBLE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.GONE
                    binding.cardPropertyDetails.visibility = View.GONE
                    binding.documentsChipGroup.visibility = View.VISIBLE
                    binding.paymentMethodChipGroup.visibility = View.VISIBLE
                    binding.cardImages.visibility = View.GONE
                    binding.cardDescription.visibility = View.GONE

                }

            }
        }
        binding.toggleExchange.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleRent.isChecked = false
                binding.toggleSale.isChecked = false

                if (binding.toggleAddMyRealestate.isChecked){

                    // my real estate for Exchange

//                    binding.cardFullName.visibility = View.GONE
//                    binding.cardGender.visibility = View.GONE
//                    binding.cardFamilyStatus.visibility = View.GONE
//                    binding.cardYearOfBirth.visibility = View.GONE
                    binding.cardStartOfRent.visibility = View.GONE
                    binding.cardRangeOfPrice.visibility = View.GONE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.GONE
                    binding.cardPropertyDetails.visibility = View.GONE
                    binding.documentsChipGroup.visibility = View.VISIBLE
                    binding.paymentMethodChipGroup.visibility = View.GONE
                    binding.cardImages.visibility = View.VISIBLE
                    binding.cardDescription.visibility = View.VISIBLE


                }else if (binding.toggleAddRequest.isChecked){

                    // looking for Exchange

//                    binding.cardFullName.visibility = View.VISIBLE
//                    binding.cardGender.visibility = View.VISIBLE
//                    binding.cardFamilyStatus.visibility = View.VISIBLE
//                    binding.cardYearOfBirth.visibility = View.VISIBLE
                    binding.cardStartOfRent.visibility = View.GONE
                    binding.cardRangeOfPrice.visibility = View.GONE
                    binding.cardLocation.visibility = View.VISIBLE
                    binding.cardRealEstateType.visibility = View.VISIBLE
                    binding.cardFeatures.visibility = View.VISIBLE
                    binding.cardFurnished.visibility = View.VISIBLE
                    binding.cardRentalDuration.visibility = View.VISIBLE
                    binding.cardRentalPrice.visibility = View.GONE
                    binding.cardPropertyDetails.visibility = View.GONE
                    binding.documentsChipGroup.visibility = View.VISIBLE
                    binding.paymentMethodChipGroup.visibility = View.GONE
                    binding.cardImages.visibility = View.GONE
                    binding.cardDescription.visibility = View.GONE

                }

            }
        }
    }

    private fun setupPropertyTypeListeners() {
        val propertyToggles: MutableList<View> = ArrayList()
        propertyToggles.add(binding.toggleApartment)
        propertyToggles.add(binding.toggleHouse)
        propertyToggles.add(binding.toggleCabin)
        propertyToggles.add(binding.toggleTouristComplex)
        propertyToggles.add(binding.toggleMausoleum)
        propertyToggles.add(binding.toggleDuplex)
        propertyToggles.add(binding.toggleCommercial)
        propertyToggles.add(binding.toggleVilla)
        propertyToggles.add(binding.togglePartyHall)
        propertyToggles.add(binding.toggleStudio)
        propertyToggles.add(binding.toggleLand)
        propertyToggles.add(binding.toggleAgriculturalLand)
        propertyToggles.add(binding.toggleBuilding)
        propertyToggles.add(binding.toggleBungalow)
        propertyToggles.add(binding.toggleWarehouse)
        propertyToggles.add(binding.toggleOther)
        for (toggle in propertyToggles) {
            if (toggle is android.widget.ToggleButton) {
                val toggleButton = toggle
                toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        for (otherToggle in propertyToggles) {
                            if (otherToggle != toggle && otherToggle is android.widget.ToggleButton) {
                                (otherToggle as android.widget.ToggleButton).isChecked = false
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setupFeaturesListeners() {
        // Features can be multiple selection, so no need for mutual exclusivity
        binding.toggleParking.setOnCheckedChangeListener { buttonView, isChecked ->
            // Handle parking toggle
        }
        binding.toggleGarden.setOnCheckedChangeListener { buttonView, isChecked ->
            // Handle garden toggle
        }
        binding.togglePool.setOnCheckedChangeListener { buttonView, isChecked ->
            // Handle pool toggle
        }
        binding.toggleSecurity.setOnCheckedChangeListener { buttonView, isChecked ->
            // Handle security toggle
        }
    }

    private fun setupFurnishedListeners() {
        binding.toggleFurnishedYes.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleFurnishedNo.isChecked = false
                binding.toggleFurnishedDoesntMatter.isChecked = false
            }
        }
        binding.toggleFurnishedNo.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleFurnishedYes.isChecked = false
                binding.toggleFurnishedDoesntMatter.isChecked = false
            }
        }
        binding.toggleFurnishedDoesntMatter.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleFurnishedYes.isChecked = false
                binding.toggleFurnishedNo.isChecked = false
            }
        }
    }

    private fun setupPaymentMethodListeners() {
        binding.toggleInstallment.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleBankCredit.isChecked = false
                binding.toggleSalePromise.isChecked = false
                binding.toggleCash.isChecked = false
            }
        }
        binding.toggleBankCredit.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleInstallment.isChecked = false
                binding.toggleSalePromise.isChecked = false
                binding.toggleCash.isChecked = false
            }
        }
        binding.toggleSalePromise.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleInstallment.isChecked = false
                binding.toggleBankCredit.isChecked = false
                binding.toggleCash.isChecked = false
            }
        }
        binding.toggleCash.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                binding.toggleInstallment.isChecked = false
                binding.toggleBankCredit.isChecked = false
                binding.toggleSalePromise.isChecked = false
            }
        }
    }

    private fun setupLocationSpinners() {
        // TODO: Implement location data loading and adapter setup
        // This will require loading the list of wilayas and their corresponding baladias
        // You'll need to implement the data source and adapter for these spinners
    }

    private fun setupPriceRangeSlider() {
        binding.priceRangeSliderHotel.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val minPrice = values[0].toInt()
            val maxPrice = values[1].toInt()

            // Update the text fields
            binding.etMinPriceHotel.setText(minPrice.toString())
            binding.etMaxPriceHotel.setText(maxPrice.toString())
        }

        // Update slider when text fields change
        binding.etMinPriceHotel.addTextChangedListener(object : android.text.TextWatcher {
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

        binding.etMaxPriceHotel.addTextChangedListener(object : android.text.TextWatcher {
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

    fun validateForm(): Boolean {
        // Validate location
        if (binding.spinnerWilaya.text.toString().isEmpty()) {
            Toast.makeText(context, "الرجاء اختيار الولاية", Toast.LENGTH_SHORT).show()
            return false
        }
        if (binding.spinnerBaladia.text.toString().isEmpty()) {
            Toast.makeText(context, "الرجاء اختيار البلدية", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate property type
        if (!binding.toggleApartment.isChecked && !binding.toggleHouse.isChecked && !binding.toggleCabin.isChecked &&
            !binding.toggleTouristComplex.isChecked && !binding.toggleMausoleum.isChecked && !binding.toggleDuplex.isChecked &&
            !binding.toggleCommercial.isChecked && !binding.toggleVilla.isChecked && !binding.togglePartyHall.isChecked &&
            !binding.toggleStudio.isChecked && !binding.toggleLand.isChecked && !binding.toggleAgriculturalLand.isChecked &&
            !binding.toggleBuilding.isChecked && !binding.toggleBungalow.isChecked && !binding.toggleWarehouse.isChecked &&
            !binding.toggleOther.isChecked) {
            Toast.makeText(context, "الرجاء اختيار نوع العقار", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate operation type
        if (!binding.toggleRent.isChecked && !binding.toggleSale.isChecked && !binding.toggleExchange.isChecked) {
            Toast.makeText(context, "الرجاء اختيار نوع العملية", Toast.LENGTH_SHORT).show()
            return false
        }

        // Validate furnished status
        if (!binding.toggleFurnishedYes.isChecked && !binding.toggleFurnishedNo.isChecked && !binding.toggleFurnishedDoesntMatter.isChecked) {
            Toast.makeText(context, "الرجاء تحديد حالة التجهيز", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    fun submitForm() {
        if (!validateForm()) {
            return
        }

        // TODO: Implement form submission logic
        // This will involve collecting all the selected values and sending them to your backend
    }
}