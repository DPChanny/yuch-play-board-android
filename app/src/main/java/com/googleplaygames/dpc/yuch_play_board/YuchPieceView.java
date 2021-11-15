package com.googleplaygames.dpc.yuch_play_board;

import android.content.Context;
import android.view.MotionEvent;

public class YuchPieceView extends androidx.appcompat.widget.AppCompatImageView {
    public YuchPieceView(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;

            case MotionEvent.ACTION_UP:
                performClick();
                return true;
        }
        return false;
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
