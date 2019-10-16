package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstFragment(fragmentActivity: FragmentActivity):Fragment() {
    private var fragmentActivity: FragmentActivity
    private lateinit var nextActivityButton: Button
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.first_fragment, container,false)
        nextActivityButton = view.findViewById(R.id.next_activity_button)
        nextActivityButton.setOnClickListener{
            this.fragmentActivity.replaceFragment()
        }
        return view
    }

    init {
        this.fragmentActivity = fragmentActivity
    }

}