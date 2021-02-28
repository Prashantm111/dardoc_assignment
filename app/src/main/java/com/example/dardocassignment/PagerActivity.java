package com.example.dardocassignment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class PagerActivity extends AppCompatActivity {

    public CustomPagerAdapter mAdapter;
    public ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initPager();
    }

    private  void initPager(){
        mViewPager = findViewById(R.id.data_vp);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(getResources().getDimensionPixelOffset(R.dimen.pager_padding), 0, getResources().getDimensionPixelOffset(R.dimen.pager_padding), 0);
        mViewPager.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.pager_margin));
        mAdapter = new CustomPagerAdapter(this.getSupportFragmentManager());
        mViewPager.setPageTransformer(true, new CarouselEffectTransformer(this));
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(25);
    }

    public class CarouselEffectTransformer implements ViewPager.PageTransformer {

        private int maxTranslateOffsetX;
        private ViewPager viewPager;

        public CarouselEffectTransformer(Context context) {
            this.maxTranslateOffsetX = dp2px(context, 180);
        }

        @Override
        public void transformPage(View view, float position) {
            if (viewPager == null) {
                viewPager = (ViewPager) view.getParent();
            }

            int leftInScreen = view.getLeft() - viewPager.getScrollX();
            int centerXInViewPager = leftInScreen + view.getMeasuredWidth() / 2;
            int offsetX = centerXInViewPager - viewPager.getMeasuredWidth() / 2;
            float offsetRate = (float) offsetX * 0.5f / viewPager.getMeasuredWidth();
            float scaleFactor = 1 - Math.abs(offsetRate);

            if (scaleFactor > 0) {
                view.setRotation(45 * offsetRate);
                view.setScaleX(scaleFactor);
                view.setTranslationX(-maxTranslateOffsetX * offsetRate);

            }

            if (position < 0) {
                view.setTranslationY(-75*offsetRate);
            } else  if (position > 0){
                view.setTranslationY(75*offsetRate);
            }

        }

        /**
         * Dp to pixel conversion
         */
        private int dp2px(Context context, float dipValue) {
            float m = context.getResources().getDisplayMetrics().density;
            return (int) (dipValue * m + 0.5f);
        }

    }
}