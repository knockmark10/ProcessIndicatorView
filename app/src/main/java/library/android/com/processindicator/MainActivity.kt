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
            .setSelectedProcessDrawable(R.drawable.round_test)
            .setUnselectedProcessDrawable(R.drawable.round_test_normal)
            .setFistStageIcon(R.drawable.ic_search)
            .setSecondStageIcon(R.drawable.ic_search)
            .setThirdStageIcon(R.drawable.ic_search)
            .setFourthStageIcon(R.drawable.ic_search)
            .setFiftsStageIcon(R.drawable.ic_search)
            .create(R.id.main_container, supportFragmentManager)

        this.btn_next.setOnClickListener {
            view.nextStage()
        }

        this.btn_previous.setOnClickListener {
            view.previousStage()
        }
    }
}
