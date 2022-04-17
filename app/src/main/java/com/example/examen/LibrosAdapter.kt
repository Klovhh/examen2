package com.example.examen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class LibrosAdapter(areaId: String):
    RecyclerView.Adapter<AreaAdapter.AreaViewHolder>() {

    var listaAreas = LibroOrganizer().obtenerLibrosPorArea(areaId)

    class AreaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AreaAdapter.AreaViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        // Setup custom accessibility delegate to set the text read
        layout.accessibilityDelegate = AreaAdapter
        return AreaAdapter.AreaViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AreaAdapter.AreaViewHolder, position: Int) {
        val item = listaAreas[position]
        //no sabamos si se queda
        val context = holder.view.context
        holder.button.text = item.Titulo
        holder.button.setOnClickListener{
            val queryURL: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryURL)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listaAreas.size

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