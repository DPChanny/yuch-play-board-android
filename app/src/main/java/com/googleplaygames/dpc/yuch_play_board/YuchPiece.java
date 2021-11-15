package com.googleplaygames.dpc.yuch_play_board;

import android.content.Context;
import android.widget.RelativeLayout;

public class YuchPiece {
    private int x;
    private int y;
    private final YuchPieceView yuchPieceView;

    public YuchPiece(int _x, int _y, int _yuch_resource_id, Context _context, RelativeLayout _layout){
        x = _x;
        y = _y;
        yuchPieceView = new YuchPieceView(_context);
        yuchPieceView.setImageResource(_yuch_resource_id);
        yuchPieceView.setOnTouchListener((v, event) -> {
            yuchPieceView.performClick();
            if(event.getAction() != 2){
                return true;
            }
            x += (int) event.getX();
            y += (int) event.getY();

            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) yuchPieceView.getLayoutParams();
            layoutParams.topMargin = y;
            layoutParams.setMarginStart(x);
            yuchPieceView.setLayoutParams(layoutParams);

            return true;
        });

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(100, 100);
        layoutParams.topMargin = y;
        layoutParams.setMarginStart(x);
        yuchPieceView.setLayoutParams(layoutParams);

        _layout.addView(yuchPieceView);
    }
}
