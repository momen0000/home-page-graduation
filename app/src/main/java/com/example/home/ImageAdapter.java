package com.example.home;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {
    public final Context mContext;
    public final int[] mImageIds = new int[]{R.drawable.hvac_and_electric_classes, R.drawable._58f15c1_dfee_4112_9b45_3931968ed172_sewing_machine_hero, R.drawable.how_to_spot_an_electrician_scam, R.drawable.blacksmith_jpg,R.drawable.car_mechanic,R.drawable.restaurants,R.drawable.photography};

    ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
