package com.codegym.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (y > (image.length - 1)
                || y < 0
                || x > (image[0].length - 1)
                || x < 0){
            return false;
        }

        if (image[y][x].equals(desiredColor)){
            return false;
        }

        Color actualColor = image[y][x];
        fillAreaUtill(image, x, y, desiredColor, actualColor);
        return true;

    }

    private void fillAreaUtill(Color[][] image, int x, int y, Color desiredColor, Color actualColor) {

        if (y > (image.length - 1)
            || y < 0
            || x > (image[0].length - 1)
            || x < 0){
            return;
        }

        if (!image[y][x].equals(actualColor)) {
            return;
        } else {
            image[y][x] = desiredColor;
            fillAreaUtill(image, x - 1, y, desiredColor, actualColor);
            fillAreaUtill(image, x + 1, y, desiredColor, actualColor);
            fillAreaUtill(image, x, y - 1, desiredColor, actualColor);
            fillAreaUtill(image, x, y + 1, desiredColor, actualColor);
        }


    }
}