package bonch.dev.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentActivity : AppCompatActivity() {
    val fm = supportFragmentManager
    private var firstFragment = FirstFragment(this)
    private var secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        fm.beginTransaction()
                .add(R.id.fragment_activity, firstFragment)
                .commit()
    }

    fun replaceFragment(){
        fm.beginTransaction()
                .replace(R.id.fragment_activity, secondFragment)
                .addToBackStack("fragment_first")
                .commit()

    }

}