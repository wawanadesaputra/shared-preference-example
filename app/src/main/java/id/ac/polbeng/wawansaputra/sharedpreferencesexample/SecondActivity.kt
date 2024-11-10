// SecondActivity.kt
package id.ac.polbeng.wawansaputra.sharedpreferencesexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.polbeng.wawansaputra.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoad.setOnClickListener {
            // Menggunakan konstanta dari MainActivity
            val filename = "$packageName-${MainActivity.RPL}"
            val pref = getSharedPreferences(filename, Context.MODE_PRIVATE)
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName"
        }
    }

    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}
