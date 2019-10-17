package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class DialogFragment: DialogFragment() {
    private lateinit var okButton: Button
    private lateinit var cancelButton: Button
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_fragment, container, false)
        init(view)
        setListeners()
        return view
    }

    private fun init(view: View){
        okButton = view.findViewById(R.id.dialog_ok)
        cancelButton = view.findViewById(R.id.dialog_cancel)
    }

    private fun setListeners(){
        okButton.setOnClickListener {
            Toast.makeText(this.context, "Pressed OK", Toast.LENGTH_LONG).show()
            dismiss()
        }

        cancelButton.setOnClickListener {
            Toast.makeText(this.context, "Pressed CANCEL", Toast.LENGTH_LONG).show()
            dismiss()
        }
    }
}