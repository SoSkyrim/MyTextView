package com.so.mytextview.utils;

/**
 * 颜色util
 * Created by sorrower on 2018/7/19.
 */

public class ColorUtil {
    public static void toRGB(String hex) {
        int color = Integer.parseInt(hex.replace("#", ""), 16);
        int red = (color & 0xff0000) >> 16;
        int green = (color & 0x00ff00) >> 8;
        int blue = (color & 0x0000ff);
        LogUtil.i("red=" + red + "--green=" + green + "--blue=" + blue);
    }

    public static void toHex(int red, int green, int blue) {
        String hr = Integer.toHexString(red);
        String hg = Integer.toHexString(green);
        String hb = Integer.toHexString(blue);
        LogUtil.i("#" + hr + hg + hb);
    }

    public void toARGB() {
        LogUtil.i("透明度 | 十六进制");
        LogUtil.i("---- | ----");
        for (double i = 1; i >= 0; i -= 0.01) {
            i = Math.round(i * 100) / 100.0d;
            int alpha = (int) Math.round(i * 255);
            String hex = Integer.toHexString(alpha).toUpperCase();
            if (hex.length() == 1) hex = "0" + hex;
            int percent = (int) (i * 100);
            System.out.println(String.format("%d%% | %s", percent, hex));
        }
    }
}
