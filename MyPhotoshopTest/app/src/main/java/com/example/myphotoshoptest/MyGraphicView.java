package com.example.myphotoshoptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyGraphicView extends View {
    public float sx, sy, angle, color, satur;

    public MyGraphicView(Context context) {
        super(context);
        this.sx = 1.0f;
        this.sy = 1.0f;
        this.angle = 0.0f;
        this.color = 1.0f;
        this.satur = 1.0f;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //px,py = 캔버스의 중심좌표
        int px = this.getWidth() / 2;
        int py = this.getHeight() / 2;
        //1. 캔버스 크기를 결정,각도 조절
        canvas.scale(sx, sy, px, py);
        canvas.rotate(angle, px, py);
        //Paint 생성
        Paint paint = new Paint();
        //2. 밝기 조절
        float[] array = {color, 0, 0, 0, 0,
                        0, color,  0, 0, 0,
                        0, 0, color,  0, 0,
                        0, 0,      0, 1, 0};
        ColorMatrix colorMatrix = new ColorMatrix(array);
        //3.흑백과 컬러선택 1.0 = 컬러 , 0.0 = 흑백
        if(satur == 0){colorMatrix.setSaturation(satur);}
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));

        //1. 이미지를 가져온다 Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.kuku);
        //2. 캔버스 중앙에 위치에 비트맵을 위치시키기 위한 좌표
        int centerX = (this.getWidth() - bitmap.getWidth()) / 2;
        int centerY = (this.getHeight() - bitmap.getHeight()) / 2;
        //3. 화면을 그린다
        canvas.drawBitmap(bitmap, centerX, centerY, paint);
        //4. 비트맵을 메모리에서 삭제
        bitmap.recycle();
        //5. 메인액티비티에서 불러온다

    }
}
