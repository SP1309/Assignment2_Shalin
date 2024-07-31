package com.example.assignment2_1222809

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class CarDetailsFragment : Fragment() {

    companion object {
        val carList = mutableListOf<Car>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_car_details, container, false)

        val spinnerCarModel: Spinner = view.findViewById(R.id.spinner_car_model)
        val editTextCarName: EditText = view.findViewById(R.id.edit_text_car_name)
        val radioGroupFuelType: RadioGroup = view.findViewById(R.id.radio_group_fuel_type)
        val buttonSubmit: Button = view.findViewById(R.id.button_submit)
        val textViewCarDetails: TextView = view.findViewById(R.id.text_view_car_details)

        buttonSubmit.setOnClickListener {
            val carModel = spinnerCarModel.selectedItem.toString()
            val carName = editTextCarName.text.toString()
            val selectedFuelTypeId = radioGroupFuelType.checkedRadioButtonId
            val fuelType = if (selectedFuelTypeId != -1) {
                view.findViewById<RadioButton>(selectedFuelTypeId).text.toString()
            } else {
                "Not selected"
            }

            if (carName.isNotEmpty() && selectedFuelTypeId != -1) {
                val car = Car(carModel, carName, fuelType)
                carList.add(car)

                val carDetails = "Car Model: $carModel\nCar Name: $carName\nFuel Type: $fuelType"
                textViewCarDetails.text = carDetails
                textViewCarDetails.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Please enter all details", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}
