package com.example.xz2dai.myapplication1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {
    public float bitmapX;
    public float bitmapY;
    public RabbitView(Context context)
    {
        super(context);
        bitmapX = 290;
        bitmapY = 130;
    }
    @Override
    protected  void onDraw(Canvans canvans){
        super.onDraw();
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.rabbit);
        canvans.drawBitmap
    }

}
