package library.android.com.processindicator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import library.android.com.library.ProcessIndicatorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        this.process_view.setTrackColor(R.color.colorAccent)

        val view = ProcessIndicatorFragment.Builder()
            .setTrackColor(R.color.colorPrimaryDark)
            .setSelectedProcessColor(R.color.colorAccent)
            .setUnselectedProcessColor(R.color.colorPrimaryDark)
            .setSearchingStageIcon(R.drawable.ic_search)
            .setFlightStageIcon(R.drawable.ic_search)
            .setSeatStageIcon(R.drawable.ic_search)
            .setPurchaseStageIcon(R.drawable.ic_search)
            .setPayStageIcon(R.drawable.ic_search)
            .create(R.id.main_container, supportFragmentManager)

        this.btn_next.setOnClickListener {
            view.nextStage()
        }

        this.btn_previous.setOnClickListener {
            view.previousStage()
        }

//        supportFragmentManager.beginTransaction().replace(R.id.main_container, processFragment).commitAllowingStateLoss()

//        val scheme = ProcessScheme(this.process_view)
    }
}
