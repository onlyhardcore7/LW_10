package com.example.julia.lw_10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    Paint p;
    int mywidth=0, myheight=0;
    float x,y;
    int k=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mm=new one(this);
        setContentView(mm);
        mm.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = (int) event.getX(); // текущая координата X пальца
        y = (int) event.getY(); // текущая координата Y пальца
        mm.invalidate();
        return true;
    }


    class one extends View {

        public one(Context context) {
            super(context);
            p = new Paint();
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            mywidth = w;
            myheight = h;
            super.onSizeChanged(w, h, oldw, oldh);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawARGB(80, 102, 204, 255);
            int y1=100,y2=150;
            int xb1 = 15, xb2 = 65;
            int xw1 = 65,xw2 = 115;
            int num=1;
            while(y1<(myheight-100)) {
                while (xb1 < mywidth-50) {
                    p.setColor(Color.BLACK);
                    canvas.drawRect(xb1, y1, xb2, y2, p);
                    xb1 += 100;
                    xb2 += 100;
                }
                while (xw1 < mywidth-50) {
                    p.setColor(Color.WHITE);
                    canvas.drawRect(xw1, y1, xw2, y2, p);
                    xw1 += 100;
                    xw2 += 100;
                }
                y1 += 50;
                y2 += 50;
                num++;
                if(num%2==1 && num<10){
                    xb1=15;
                    xb2=65;
                    xw1=65;
                    xw2=115;
                }
                if(num%2==0 && num<10) {
                    xb1 = 65;
                    xb2 = 115;
                    xw1 = 15;
                    xw2 = 65;
                }
            }
            p.setTextSize(20);
            p.setTextAlign(Paint.Align.CENTER);
            int mw = myheight-(myheight%50)-150;
            int mh = mywidth-(mywidth%50);
            int sy = myheight - 50;
            int sx = mywidth - (mywidth /2);
            if(x==0 && y==0) {
                String s = "Screen size " + mw + " " + mh;
                p.setColor(Color.BLACK);
                canvas.drawText(s, sx, sy, p);
            }
            if(x>0 && y>0) {
                invalidate(sx,sy,sx,sy);
                p.setColor(Color.BLACK);
                k++;
                String s = x + " " + y + "\n число нажатий " + k/4;
                canvas.drawText(s, sx, sy, p);
            }
        }
    }


    one mm;
}