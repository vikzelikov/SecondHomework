package bonch.dev.school

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DialogActivity : AppCompatActivity() {

    private lateinit var dialogButton: Button
    val fm = supportFragmentManager
    private val dialogFragment = DialogFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity)
        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        dialogButton = findViewById(R.id.dialog_button)
    }

    private fun setListeners() {
        dialogButton.setOnClickListener {
            dialogFragment.show(fm, "dialog")
        }
    }


}
