package edu_up_cs301.ludo;

/**
 * SquaredFrame
 * this allows the gui to be a perfect square
 */

/**Extern Citations
 * http://blog.nkdroidsolutions.com/how-to-make-a-square-layout-in-android-example/
 *https://stackoverflow.com/questions/8981029/simple-way-to-do-dynamic-but-square-layout
 *Usage: We were not getting a perfect square as a gui layout. For some reason it was off by a few
 * pixels. Instead of making all the boxes strange floats so as to divide up the screen, we used a
 * square layout instead.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class SquaredFrame extends RelativeLayout{
    public SquaredFrame(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(size, size);
    }
}