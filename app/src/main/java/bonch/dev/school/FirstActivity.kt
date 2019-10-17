package bonch.dev.school

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    private lateinit var secondActivityButton: Button
    private lateinit var thirdActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initializeViews()
        setListeners()
    }

    private fun initializeViews() {
        secondActivityButton = findViewById(R.id.second_activity_button)
        thirdActivityButton = findViewById(R.id.third_activity_button)
    }

    private fun setListeners() {
        secondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent,2)
        }
        thirdActivityButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent,3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val isBtn = data?.getIntExtra("btn", -1)
        if (isBtn == 1){
            Toast.makeText(this, "Button pressed, activity #${requestCode}", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Button not pressed, activity #${requestCode}", Toast.LENGTH_LONG).show()
        }
    }

}
