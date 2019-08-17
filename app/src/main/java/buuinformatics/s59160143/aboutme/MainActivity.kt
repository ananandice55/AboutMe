package buuinformatics.s59160143.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buuinformatics.s59160143.aboutme.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Anan Khaita")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            doneButton.setOnClickListener {
                addNickname(it)
            }
            nicknameText.setOnClickListener {
                updateNickname(it)
            }
            myName = this@MainActivity.myName
        }


    }

    private fun updateNickname (view: View) {
        binding.apply {
           NicknameEdit.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE


            doneButton.visibility = View.VISIBLE

            NicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput( NicknameEdit, 0)
        }

    }

    private fun addNickname(view: View) {
        binding.apply{
            myName?.nickname = binding.NicknameEdit.text.toString()
            NicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
            invalidateAll()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}
