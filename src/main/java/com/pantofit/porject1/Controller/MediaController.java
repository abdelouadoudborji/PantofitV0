package com.pantofit.porject1.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.pantofit.porject1.dao.MediaRepository;
import com.pantofit.porject1.dao.SalleRepository;
import com.pantofit.porject1.entities.Media;
import com.pantofit.porject1.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin()

public class MediaController {

    @Autowired
    MediaRepository mediaRepository;
@Autowired
    SalleRepository salleRepository;





    @PostMapping("/upload")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
   public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @RequestParam("visible")Long visible,@RequestParam("salle")Long id) throws IOException {
    //public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
  /* Long visible=1L;
   Long  id=1L;*/
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Salle salle=salleRepository.getOne(id);

        System.out.print("log");
        Media img = new Media(null,visible,"EEEEEEE",
                compressZLib(file.getBytes()),salle);
        mediaRepository.save(img);
        return ResponseEntity.status(HttpStatus.OK);
    }
    @GetMapping(path = { "/getimage/{id}" })
    public List<Media> getImage(@PathVariable("id") Long id) throws IOException {
        List<Media> sentMedia = new ArrayList<Media>();

        List<Media> medias=mediaRepository.getbysalle(id);

        medias.forEach(retrievedImage -> {
           Media mediasent = new Media(retrievedImage.getId(),retrievedImage.getVisible(),retrievedImage.getCode()
           , decompressZLib(retrievedImage.getPicbyte()),null);
            sentMedia.add(mediasent);
        });



        return sentMedia ;
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressZLib(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressZLib(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}