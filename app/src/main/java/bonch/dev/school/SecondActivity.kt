package bonch.dev.school

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initializeViews()

        //get values from FirstActivity
        val isEnabledIndicator: Boolean = intent.getBooleanExtra("indicatorButton", true)
        val currentCount: Int = intent.getIntExtra("counterButton", 0)
        val textField: String? = intent.getStringExtra("textField")

        //set data in TextView
        textView.text = "Indicator enabled: $isEnabledIndicator\nButton count: $currentCount\nText field: $textField"

    }

    private fun initializeViews() {
        textView = findViewById(R.id.text_view)
    }

}