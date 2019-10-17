package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment:Fragment() {
    private lateinit var textView: TextView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_fragment, container,false)
        textView = view.findViewById(R.id.text_view)

        val isEnabledIndicator: Boolean = arguments!!.getBoolean("indicatorButton", true)
        val currentCount: Int = arguments!!.getInt("counterButton", 0)
        val textField: String? = arguments!!.getString("textField")

        textView.text = "Indicator enabled: $isEnabledIndicator\nButton count: $currentCount\nText field: $textField"
        return view
    }



}