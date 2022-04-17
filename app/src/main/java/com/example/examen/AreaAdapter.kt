package com.example.examen

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class AreaAdapter (context: Context) :
    RecyclerView.Adapter<AreaAdapter.AreaViewHolder>(){

    private val areasArr : List<String> = context.resources.getStringArray(R.array.areas).toList()

    class AreaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = Accessibility
        return AreaViewHolder(layout)
    } 
    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        val item = areasArr[position]
        //no sabamos si se queda
        holder.view.context
        holder.button.text = item

        holder.button.setOnClickListener(){
            val context: Context = holder.view.context

            val intent = Intent(context,DetailActivity::class.java)

            intent.putExtra(DetailActivity.AREA,holder.button.text.toString())

            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int = areasArr.size
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.busqueda)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }


}