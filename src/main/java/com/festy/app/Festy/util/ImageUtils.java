package com.festy.app.Festy.util;

import com.festy.app.Festy.product.Image;
import org.imgscalr.Scalr;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class ImageUtils {

    private static int IMAGE_REDUCER_PIXELS_WIDTH = 480;
    public static byte[] compressImage(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];

            while (!inflater.finished()) {
                int count = 0;
                try {
                    count = inflater.inflate(tmp);
                } catch (DataFormatException e) {
                    throw new RuntimeException(e);
                }
                outputStream.write(tmp, 0, count);
            }
        try {
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return outputStream.toByteArray();
    }

    public static Image buildEntity(MultipartFile file){

        byte[] reducedImage = new byte[0];
        try {
            reducedImage = ImageUtils.resizeImage(file.getBytes(), getFileExtension(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtils.compressImage(reducedImage))
                .build();

    }

    private static String getFileExtension(String filename){
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    public static byte[] resizeImage(byte[] file, String extension){
        ByteArrayInputStream in = new ByteArrayInputStream(file);
        BufferedImage img;
        try {
            img = ImageIO.read(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedImage resizedImage = Scalr.resize(img,IMAGE_REDUCER_PIXELS_WIDTH);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            ImageIO.write(resizedImage,extension,out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return out.toByteArray();
    }


}
