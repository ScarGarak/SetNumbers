package mortlust.steigt.setnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mortlust.steigt.setnumbers.databinding.ActivityMainBinding
import android.widget.SeekBar

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var B: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        B = ActivityMainBinding.inflate(layoutInflater)
        setContentView(B.root)

        B.sbOne.setOnSeekBarChangeListener(this)
        B.sbTwo.setOnSeekBarChangeListener(this)

        B.buSum.setOnClickListener {
            val valueOne = B.sbOne.progress
            val valueTwo = (B.sbTwo.progress / 10.0) + 0.5
            Log.d("valueTwo", "progress: ${B.sbTwo.progress}")
            Log.d("valueTwo", "progress / 10: ${B.sbTwo.progress / 10.0}")
            Log.d("valueTwo", "(progress / 10) + 0.5: ${(B.sbTwo.progress / 10.0) + 0.5}")
            val sum = valueOne + valueTwo
            B.tvOutput.text = "Sum: $valueOne + $valueTwo = $sum"
        }

        B.buStartingValues.setOnClickListener {
            B.sbOne.progress = 5
            B.sbTwo.progress = 5
        }
    }

    override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
        val trigger = if (fromUser) "User" else "Button"
        when (sb?.id) {
            B.sbOne.id -> {
                B.tvOne.text = "$progress"
                B.tvOutput.text = "SeekBar: 1, Auslöser: $trigger"
            }
            B.sbTwo.id -> {
                val value = (progress / 10.0) + 0.5
                B.tvTwo.text = "$value"
                B.tvOutput.text = "SeekBar: 2, Auslöser: $trigger"
            }
        }
    }

    override fun onStartTrackingTouch(sb: SeekBar?) {
        val nr = if (sb?.id == B.sbOne.id) 1 else 2
        B.tvOutput.text = "SeekBar: $nr, Start"
    }

    override fun onStopTrackingTouch(sb: SeekBar?) {
        val nr = if (sb?.id == B.sbOne.id) 1 else 2
        B.tvOutput.text = "SeekBar: $nr, Stop"
    }
}