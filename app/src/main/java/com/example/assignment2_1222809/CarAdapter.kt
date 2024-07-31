
package com.example.assignment2_1222809
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(private val carList: List<Car>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewModel: TextView = itemView.findViewById(R.id.text_view_model)
        val textViewName: TextView = itemView.findViewById(R.id.text_view_name)
        val textViewFuelType: TextView = itemView.findViewById(R.id.text_view_fuel_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentItem = carList[position]
        holder.textViewModel.text = currentItem.model
        holder.textViewName.text = currentItem.name
        holder.textViewFuelType.text = currentItem.fuelType
    }

    override fun getItemCount() = carList.size
}
