package library.android.com.processindicator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import library.android.com.library.ProcessIndicatorView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view = ProcessIndicatorView.Builder()
            .setTrackColor(R.color.colorPrimaryDark)
            .setSelectedProcessColor(R.color.colorAccent)
            .setUnselectedProcessColor(R.color.colorPrimaryDark)
            .setSearchingStageIcon(R.drawable.ic_search)
            .setFlightStageIcon(R.drawable.ic_flight_ico)
            .setSeatStageIcon(R.drawable.ic_search)
            .setPurchaseStageIcon(R.drawable.paso_4)
            .setPayStageIcon(R.drawable.ic_search)
            .create(R.id.main_container, supportFragmentManager)

        this.btn_next.setOnClickListener {
            view.nextStage()
        }

        this.btn_previous.setOnClickListener {
            view.previousStage()
        }
    }
}
