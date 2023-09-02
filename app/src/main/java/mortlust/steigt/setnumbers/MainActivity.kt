package mortlust.steigt.setnumbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mortlust.steigt.setnumbers.databinding.ActivityMainBinding
import android.view.View

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var B: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        B = ActivityMainBinding.inflate(layoutInflater)
        setContentView(B.root)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}