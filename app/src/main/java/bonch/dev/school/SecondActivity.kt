package bonch.dev.school

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        finishButton = findViewById(R.id.finish_button)
    }

    private fun setListeners() {

        finishButton.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("btn",1)
            setResult(RESULT_OK, intent)
            finish()
        }
    }



}