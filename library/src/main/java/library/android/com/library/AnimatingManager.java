package library.android.com.library;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;


public class AnimatingManager {

    public static void scaleUpViewFirst(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1f, 1.5f, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

    public static void scaleDownViewFirst(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1.5f, 1f, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

    public static void scaleUpView(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1f, 1.5f, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

    public static void scaleDownView(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1.5f, 1f, startScale, endScale, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

    public static void scaleUpViewLast(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1f, 1.5f, startScale, endScale, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

    public static void scaleDownViewLast(View view, float startScale, float endScale) {
        Animation anim = new ScaleAnimation(1.5f, 1f, startScale, endScale, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setFillAfter(true);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(600);
        view.startAnimation(anim);
    }

}
