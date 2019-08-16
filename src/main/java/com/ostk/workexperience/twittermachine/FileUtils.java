package com.ostk.workexperience.twittermachine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

  public static File convertToUploadFile(final MultipartFile multipartFile) throws IOException {
    final File file = new File(multipartFile.getOriginalFilename());
    if (file.createNewFile()) {
      try (final FileOutputStream fos = new FileOutputStream(file)) {
        fos.write(multipartFile.getBytes());
      }
      return file;
    }
    return null;
  }

}
