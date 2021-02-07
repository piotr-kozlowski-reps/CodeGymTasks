package pl.codegym.task.task16.task1631;

import pl.codegym.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes jakiImg){
        ImageReader aktualnyReader = null;

        try {
                if (jakiImg.equals(ImageTypes.JPG)) {
                    aktualnyReader = new JpgReader();
                } else if (jakiImg.equals(ImageTypes.BMP)) {
                    aktualnyReader = new BmpReader();
                } else if (jakiImg.equals(ImageTypes.PNG)) {
                    aktualnyReader = new PngReader();
                } else {
                    throw new IllegalArgumentException("Nieznany typ obrazu");
                }

        } catch (NullPointerException e){
            throw new IllegalArgumentException("Nieznany typ obrazu");
        }


        return aktualnyReader;
    }

}
