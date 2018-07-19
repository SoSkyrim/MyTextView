package com.so.mytextview.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.so.mytextview.R;
import com.so.mytextview.ui.view.MyTextView;
import com.so.mytextview.utils.UIUtil;

public class MainActivity extends AppCompatActivity {

    private EditText mEtContent;
    private MyTextView mMtvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        // 获取视图
        mEtContent = (EditText) findViewById(R.id.et_content);

        SeekBar sbTxtA = (SeekBar) findViewById(R.id.sb_txt_a);
        SeekBar sbTxtR = (SeekBar) findViewById(R.id.sb_txt_r);
        SeekBar sbTxtG = (SeekBar) findViewById(R.id.sb_txt_g);
        SeekBar sbTxtB = (SeekBar) findViewById(R.id.sb_txt_b);
        SeekBar sbTxtSize = (SeekBar) findViewById(R.id.sb_txt_size);
        SeekBar sbBkA = (SeekBar) findViewById(R.id.sb_bk_a);
        SeekBar sbBkR = (SeekBar) findViewById(R.id.sb_bk_r);
        SeekBar sbBkG = (SeekBar) findViewById(R.id.sb_bk_g);
        SeekBar sbBkB = (SeekBar) findViewById(R.id.sb_bk_b);

        final TextView tvTxtA = (TextView) findViewById(R.id.tv_txt_a);
        final TextView tvTxtR = (TextView) findViewById(R.id.tv_txt_r);
        final TextView tvTxtG = (TextView) findViewById(R.id.tv_txt_g);
        final TextView tvTxtB = (TextView) findViewById(R.id.tv_txt_b);
        final TextView tvTxtSize = (TextView) findViewById(R.id.tv_txt_size);
        final TextView tvBkA = (TextView) findViewById(R.id.tv_bk_a);
        final TextView tvBkR = (TextView) findViewById(R.id.tv_bk_r);
        final TextView tvBkG = (TextView) findViewById(R.id.tv_bk_g);
        final TextView tvBkB = (TextView) findViewById(R.id.tv_bk_b);

        mMtvTest = (MyTextView) findViewById(R.id.mtv_test);

        // 文本颜色监听
        int txtColor = mMtvTest.getMyColor();
        int[] txtRGB = setColor(txtColor);

        sbTxtR.setProgress((int) (txtRGB[0] * 1.0f / 255 * 100));
        sbTxtG.setProgress((int) (txtRGB[1] * 1.0f / 255 * 100));
        sbTxtB.setProgress((int) (txtRGB[2] * 1.0f / 255 * 100));

        tvTxtR.setText(String.format(
                UIUtil.getString(R.string.txt_r_n), (int) (txtRGB[0] * 1.0f / 255 * 100)));

        tvTxtG.setText(String.format(
                UIUtil.getString(R.string.txt_g_n), (int) (txtRGB[1] * 1.0f / 255 * 100)));

        tvTxtB.setText(String.format(
                UIUtil.getString(R.string.txt_b_n), (int) (txtRGB[2] * 1.0f / 255 * 100)));

        sbTxtA.setProgress(100);
        sbTxtA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTxtA.setText(String.format(
                        UIUtil.getString(R.string.txt_a_n), progress));

                int txtColor = mMtvTest.getMyColor();
                int[] txtRGB = setColor(txtColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setMyColor(Color.argb(color, txtRGB[0], txtRGB[1], txtRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbTxtR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTxtR.setText(String.format(
                        UIUtil.getString(R.string.txt_r_n), progress));

                int txtColor = mMtvTest.getMyColor();
                int[] txtRGB = setColor(txtColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setMyColor(Color.argb(255, color, txtRGB[1], txtRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbTxtG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTxtG.setText(String.format(
                        UIUtil.getString(R.string.txt_g_n), progress));

                int txtColor = mMtvTest.getMyColor();
                int[] txtRGB = setColor(txtColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setMyColor(Color.argb(255, txtRGB[0], color, txtRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbTxtB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTxtB.setText(String.format(
                        UIUtil.getString(R.string.txt_b_n), progress));

                int txtColor = mMtvTest.getMyColor();
                int[] txtRGB = setColor(txtColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setMyColor(Color.argb(255, txtRGB[0], txtRGB[1], color));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // 字号监听
        float mySize = mMtvTest.getMySize();
        sbTxtSize.setProgress((int) UIUtil.px2sp(mySize));
        tvTxtSize.setText(String.format(
                UIUtil.getString(R.string.txt_size_n), (int) UIUtil.px2sp(mySize)));

        sbTxtSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvTxtSize.setText(String.format(
                        UIUtil.getString(R.string.txt_size_n), progress));
                mMtvTest.setMySize(UIUtil.sp2px(progress));
                mMtvTest.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // 背景色监听
        int bkColor = mMtvTest.getBkColor();
        int[] bkRGB = setColor(bkColor);
        sbBkR.setProgress((int) (bkRGB[0] * 1.0f / 255 * 100));
        sbBkG.setProgress((int) (bkRGB[1] * 1.0f / 255 * 100));
        sbBkB.setProgress((int) (bkRGB[2] * 1.0f / 255 * 100));

        tvBkR.setText(String.format(
                UIUtil.getString(R.string.bk_r_n), (int) (bkRGB[0] * 1.0f / 255 * 100)));

        tvBkG.setText(String.format(
                UIUtil.getString(R.string.bk_g_n), (int) (bkRGB[1] * 1.0f / 255 * 100)));

        tvBkB.setText(String.format(
                UIUtil.getString(R.string.bk_b_n), (int) (bkRGB[2] * 1.0f / 255 * 100)));

        sbBkA.setProgress(100);
        sbBkA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBkA.setText(String.format(
                        UIUtil.getString(R.string.bk_a_n), progress));
                int bkColor = mMtvTest.getBkColor();
                int[] bkRGB = setColor(bkColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setBkColor(Color.argb(color, bkRGB[0], bkRGB[1], bkRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbBkR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBkR.setText(String.format(
                        UIUtil.getString(R.string.bk_r_n), progress));

                int bkColor = mMtvTest.getBkColor();
                int[] bkRGB = setColor(bkColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setBkColor(Color.argb(255, color, bkRGB[1], bkRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbBkG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBkG.setText(String.format(
                        UIUtil.getString(R.string.bk_g_n), progress));

                int bkColor = mMtvTest.getBkColor();
                int[] bkRGB = setColor(bkColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setBkColor(Color.argb(255, bkRGB[0], color, bkRGB[2]));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sbBkB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvBkB.setText(String.format(
                        UIUtil.getString(R.string.bk_b_n), progress));

                int bkColor = mMtvTest.getBkColor();
                int[] bkRGB = setColor(bkColor);

                int color = (int) (progress * 1.0f / seekBar.getMax() * 255);
                mMtvTest.setBkColor(Color.argb(255, bkRGB[0], bkRGB[1], color));
                mMtvTest.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    /**
     * 设置内容到视图
     *
     * @param v 视图
     */
    public void setContent(View v) {
        mMtvTest.setMyTxt(mEtContent.getText().toString());
        mMtvTest.requestLayout();
    }

    /**
     * 依据颜色值获取rgb值
     *
     * @param color 颜色值
     * @return rgb值
     */
    public int[] setColor(int color) {
        int[] rgb = new int[3];
        rgb[0] = (color & 0x00ff0000) >> 16;
        rgb[1] = (color & 0x0000ff00) >> 8;
        rgb[2] = (color & 0x000000ff);
        return rgb;
    }
}