package app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class Saver {

    public Saver() {

    }

    public boolean toSaveImage(final String fileName, final InputStream content) {

        final File file = new File(fileName);


        if (content == null) {
            return false;
        }

        try (
                InputStream input = content;

        ) {


            BufferedImage im = ImageIO.read(input);
            ImageIO.write(im, "jpg", file);

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return true;
    }
}
