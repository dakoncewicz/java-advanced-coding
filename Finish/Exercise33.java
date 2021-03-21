package com.dkoncewicz;
/* Zadanie 33
Napisz program, który wyświetli wszystkie zdjęcia (.png, .jpg) w danym katalogu i podkatalogach.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise33 {
    // Key concepts : dir.listFiles(), FilenameFilter
    public void show(){
        String path = "/Users/darekkoncewicz/Documents/Biezace/Obrazy";  //path to scanned directory
        // File representing the folder that you select using a FileChooser
        final File dir = new File(path);

        // array of supported extensions (use a List if you prefer)
        final String[] EXTENSIONS = new String[]{
                "gif", "png", "bmp","jpg" // and other formats you need
        };

        // filter to identify images based on their extensions
        final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (final String ext : EXTENSIONS) {
                    if (name.endsWith("." + ext)) {
                        return (true);
                    }
                }
                return (false);
            }
        };

        // searching flat directory only version
        if (dir.isDirectory()) { // make sure it's a directory
            for ( File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);

                    // you may want something more involved here to display
                    System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());
                } catch (final IOException e) {
                    // handle errors here
                }
            }
        }
        walkThroughDirs(path);
    }

    // walking through dirs and subdirs - implement image filter by yourself
    public void walkThroughDirs(String start){
        Path startPath = Paths.get(start);

        try (Stream<Path> stream = Files.walk(startPath, Integer.MAX_VALUE)) {
            List<String> collect = stream
                    .map(String::valueOf)
                    .sorted()
                    .collect(Collectors.toList());

            collect.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//Walking directories and subdirectories
// See : https://nirajsonawane.github.io/2018/05/29/Java-8-List-all-Files-in-Directory-and-Subdirectories/
