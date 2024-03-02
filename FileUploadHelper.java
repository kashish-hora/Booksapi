package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//uploading of files in the image folder

@Component
public class FileUploadHelper {
    //used for static path that can only be rn in this system
   // public final String UPLOAD_DIR="C:\\Users\\Admin\\Downloads\\Projects\\bootrestbook\\src\\main\\resources\\static\\image";
    
   //creating dynamic path that can be run in other systems too retur the path of image that can be open in any of the browser
    public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public  FileUploadHelper() throws IOException{

    }
    
public boolean uploadFile( MultipartFile multipartfile){
    boolean f=false;
    try{//read
       // InputStream is=multipartfile.getInputStream();
        //byte data[]=new byte[is.available()];
       // is.read(data);
        //write
       // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename());
       // fos.write(data);
       //closing the file object
       // fos.flush();
       // fos.close();

       Files.copy(multipartfile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartfile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
        f=true;
        
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return f;
}
}
