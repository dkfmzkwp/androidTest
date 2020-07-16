package com.example.androidtest20200715;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ImageViewTest extends View {
    //멤버변수 선언
    private String imagePath;

    public ImageViewTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.imagePath = null;
    }

    //ImageViewTest 객체가 만들어지면 화면에 그려질때 이 함수를 자동으로 불러주는 콜백함수.

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //이미지 파일을 불러서 화면에 그려넣는다
        if(imagePath != null){
            //imagePath 에 있는 이미지 파일을 비트맵으로 변환
            Bitmap bitmap =BitmapFactory.decodeFile(imagePath);
            //캔버스 설정
            canvas.scale((float)canvas.getWidth()/bitmap.getWidth(),(float)canvas.getHeight()/bitmap.getHeight(),0,0);
            //설정한 캔버스에 비트맵으로 변환한 이미지를 넣는다
            canvas.drawBitmap(bitmap,0,0,null);
            bitmap.recycle();
        }
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
