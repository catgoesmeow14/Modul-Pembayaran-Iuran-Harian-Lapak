package id.aryad.sipasar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1700;

    Animation fadeinAnim;
    ImageView ivLogoApp, ivJudulModul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        fadeinAnim = AnimationUtils.loadAnimation(this, R.anim.fadein);

        ivLogoApp = findViewById(R.id.ivLogoApp);
        ivJudulModul = findViewById(R.id.ivJudulModul);

        ivLogoApp.setAnimation(fadeinAnim);
        ivJudulModul.setAnimation(fadeinAnim);

        new Handler().postDelayed(() -> {
            Intent toLoginIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
            startActivity(toLoginIntent);
            finish();
        }, SPLASH_SCREEN);
    }
}