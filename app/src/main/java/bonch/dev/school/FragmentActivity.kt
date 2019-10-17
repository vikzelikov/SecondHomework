package bonch.dev.school

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import bonch.dev.school.models.Counter

class FragmentActivity : AppCompatActivity() {
    val fm = supportFragmentManager

    private lateinit var attachFragmentButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var textField: EditText
    private lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        initializeViews()
        setInstanceState(savedInstanceState)
        setListeners()
    }

    private fun initializeViews() {
        indicatorButton = findViewById(R.id.indicator_button)
        counterButton = findViewById(R.id.counter_button)
        textField = findViewById(R.id.text_field)
        nextActivityButton = findViewById(R.id.next_activity_button)
        attachFragmentButton = findViewById(R.id.attach_fragment_button)
    }

    private fun setListeners() {
        indicatorButton.setOnClickListener {
            indicatorButton.isEnabled = false
        }

        counterButton.setOnClickListener {
            counter.increment()
            counterButton.text = "${counter.currentCount}"
        }

        attachFragmentButton.setOnClickListener {
            val myFragment = MyFragment()
            val bundle = Bundle()
            bundle.putBoolean("indicatorButton", indicatorButton.isEnabled)
            bundle.putInt("counterButton", counter.currentCount)
            bundle.putString("textField", textField.text.toString())
            myFragment.arguments = bundle

            fm.beginTransaction()
                    .replace(R.id.fragment_container, myFragment)
                    .commit()
        }

        nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            //set values for SecondActivity
            intent.putExtra("indicatorButton", indicatorButton.isEnabled)
            intent.putExtra("counterButton", counter.currentCount)
            intent.putExtra("textField", textField.text.toString())
            startActivity(intent)
        }
    }


    private fun setInstanceState(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            counter = Counter()
        } else {
            counter = Counter(savedInstanceState.getInt("TAP_AMOUNTS"))
            indicatorButton.isEnabled = savedInstanceState.getBoolean("IS_CLICKED")
        }
        counterButton.text = "${counter.currentCount}"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TAP_AMOUNTS", counter.currentCount)
        outState.putBoolean("IS_CLICKED", indicatorButton.isEnabled)
    }

}