package stor.ens.ma.stor.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import stor.ens.ma.stor.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);

        // Rotation complète
        logo.animate().rotation(360f).setDuration(2000);

        // Réduction de taille
        logo.animate().scaleX(0.5f).scaleY(0.5f).setDuration(3000);

        // Translation vers le bas
        logo.animate().translationYBy(1000f).setDuration(2000);

        // Disparition progressive
        logo.animate().alpha(0f).setDuration(6000);

        // Redirection après 5 secondes
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(5000);
                Intent intent = new Intent(SplashActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
