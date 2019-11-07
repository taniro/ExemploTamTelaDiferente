package tads.eaj.ufrn.exemplotamteladiferente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.ActivityInfo
import android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE
import android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val screenSize = resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK
        //if device is a tablet, set phoneDevice to false
        var ehTelefone = true

        if (screenSize == SCREENLAYOUT_SIZE_LARGE || screenSize == SCREENLAYOUT_SIZE_XLARGE) {
            ehTelefone = false // not a phone-sized device
        }

        // if running on phone-sized device, allow only portrait orientation
        if (ehTelefone) {
            Log.i("TESTE", "Mudando a orientação para retrato, pois é telefone")
            //mudar a rotação de tela para RETRATO, independente da posição do dispositivo
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }

        try {
            if (viewpager != null){
                //necessário carregar o viewpager, para apresentar
                viewpager.adapter = TabsAdapter(supportFragmentManager)
                tab.setupWithViewPager(viewpager)
            }

        } catch (e: NullPointerException) {

        }

    }
}
