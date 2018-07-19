package com.so.mytextview.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.so.mytextview.R;

/**
 * 自定义文本
 * Created by sorrower on 2018/7/16.
 */

public class MyTextView extends View {
    /**
     * 文本
     */
    private String mText;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 颜色
     */
    private int mColor;
    private int mBkColor;
    private float mSize;

    public MyTextView(Context context) {
        this(context, null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        // 获取自定义属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);

        mSize = ta.getDimension(R.styleable.MyTextView_size, 16);
        mText = ta.getString(R.styleable.MyTextView_text);
        mColor = ta.getColor(R.styleable.MyTextView_color, Color.BLACK);

        ta.recycle();

        // 设置画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(mSize);

        // 设置背景颜色
        mBkColor = Color.BLUE;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = 0;
        int height = 0;

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;

            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                width = (int) (getPaddingLeft() + getPaddingRight()
                        + mPaint.measureText(mText));
                break;
        }

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);

        switch (specMode) {
            case MeasureSpec.EXACTLY:
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;

            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                Paint.FontMetrics fmi = mPaint.getFontMetrics();
                float textHeight = Math.abs(fmi.bottom - fmi.top);
                height = (int) (getPaddingTop() + getPaddingBottom() + textHeight);
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制背景
        mPaint.setColor(mBkColor);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        // 绘制文本
        mPaint.setColor(mColor);

        int x = getWidth() / 2;
        int y = getHeight() / 2;

        Paint.FontMetricsInt fmi = mPaint.getFontMetricsInt();
        float baseline = y + Math.abs(fmi.top + fmi.bottom) / 2.0f;
//        float baseline = y - (fmi.ascent + fmi.descent + fmi.leading) / 2.0f;

        canvas.drawText(mText, x - mPaint.measureText(mText) / 2, baseline, mPaint);
//        canvas.drawText(mText, x - getTextWidth(mPaint, mText) / 2, baseline, mPaint);
    }

    /**
     * 获取字符串宽度
     *
     * @param paint 画笔
     * @param str   字符串
     * @return 得到的宽度
     */
    public static int getTextWidth(Paint paint, String str) {
        int width = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                width += (int) Math.ceil(widths[j]);
            }
        }
        return width;
    }

    /**
     * 设置文本
     *
     * @param text 文本
     */
    public void setMyTxt(String text) {
        mText = text;
    }

    /**
     * 设置文本颜色
     *
     * @param color 文本颜色
     */
    public void setMyColor(int color) {
        mColor = color;
        mPaint.setColor(color);
    }

    /**
     * 设置背景颜色
     *
     * @param color 背景颜色
     */
    public void setBkColor(int color) {
        mBkColor = color;
        mPaint.setColor(color);
    }

    /**
     * 设置字号
     *
     * @param size 字号
     */
    public void setMySize(int size) {
        mSize = size;
        mPaint.setTextSize(size);
    }

    /**
     * 获取文本内容
     *
     * @return 文本内容
     */
    public String getMyTxt() {
        return mText;
    }

    /**
     * 获取文本颜色
     *
     * @return 文本颜色
     */
    public int getMyColor() {
        return mColor;
    }

    /**
     * 获取背景颜色
     *
     * @return 背景颜色
     */
    public int getBkColor() {
        return mBkColor;
    }

    /**
     * 获取字号
     *
     * @return 字号
     */
    public float getMySize() {
        return mSize;
    }
}
