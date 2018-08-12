package tech.brandonmahoney.strangefacts

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import java.util.*

class StrangeFactsActivity : AppCompatActivity() {
    private val TAG = StrangeFactsActivity::class.java.simpleName
    private val factBook = FactBook()
    private val colorWheel = ColorWheel()
    // Declare variables
    private var factTextView: TextView? = null
    private var showFactButton: Button? = null
    private var relativeLayout: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_strange_facts)

        // Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView)
        showFactButton = findViewById(R.id.showFactButton)
        relativeLayout = findViewById(R.id.relativeLayout)

        factTextView!!.text = factBook.getFact()

        showFactButton!!.setOnClickListener {
            val fact = factBook.getFact()
            val color = colorWheel.getColor()

            // Update the screen with our new fact
            factTextView!!.text = fact
            relativeLayout!!.setBackgroundColor(color)
            showFactButton!!.setTextColor(color)
        }

        //Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_LONG).show()
        Log.d(TAG, "We're logging from the onCreate().")
    }
}
