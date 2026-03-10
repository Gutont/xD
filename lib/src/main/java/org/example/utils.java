package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class utils {

    public static void ErrorMessage(Exception error, String where) {
    }

    public static boolean doesDirectoryExist(String directoryPath){
        File directory = new File(directoryPath);
        return directory.exists() && directory.isDirectory();
    }

    public static void copyFileToDirectory(File file, File targetDirectory) throws IOException{
        Path targetPath = targetDirectory.toPath().resolve(file.getName());
        Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static void copyFile(File sourceFile, File targetFile) {
        try {
            if (!targetFile.getParentFile().exists()){
              targetFile.getParentFile().mkdir();
            }
            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copeado com sucesso");
        } catch (Exception e) { e.printStackTrace(); }
    }

   public static List<File> getMatchingDirectories(File directory) {
      List<File> matchingDirectories = new ArrayList<>();
      File[] files;
      if (directory.exists() && directory.isDirectory() && (files = directory.listFiles()) != null) {
         File[] var3 = files;
         int var4 = files.length;
         for(int var5 = 0; var5 < var4; ++var5) {
            File file = var3[var5];
            if (file.isDirectory()) {
               String directoryName = file.getName();
               if (directoryName.matches("^[A-Z0-9].*[A-Z0-9]$")) {
                  matchingDirectories.add(file);
               }
            }
         }
      }
      return matchingDirectories;
   }
   
    public static List<File> getMatchingFiles(File directory) {
        List<File> matchingFiles = new ArrayList<>();
        File[] files;
        if(directory.exists() && directory.isDirectory() && (files = directory.listFiles()) != null){
            File[] var3 = files;
            int var4 = files.length;
            for(int var5 = 0; var5 < var4; var5++){
                File file = var3[var5];
                if(file.isFile()){
                    String fileName = file.getName();
                    if(fileName.matches("^[A-Z0-9].*s$")){
                        matchingFiles.add(file);
                    }
                }
            }
            try {
                matchingFiles.add(new File(directory + "\\key_datas"));} catch (Exception var8) { }
        }
        return matchingFiles;
    }

    public static void copyDirectoryToDirectory(File sourceDirectory, File targetDirectory) throws IOException {
      Path targetPath = targetDirectory.toPath().resolve(sourceDirectory.getName());
      Files.walk(sourceDirectory.toPath()).forEach((sourcePath) -> {
         Path target = targetPath.resolve(sourceDirectory.toPath().relativize(sourcePath));
         try {
            Files.copy(sourcePath, target, StandardCopyOption.REPLACE_EXISTING);
         } catch (IOException var5) { }

      });
   }

    public static void copyDirectory(File sourceDir, File targetDir) throws IOException {
      if (!targetDir.exists()) {
         targetDir.mkdirs();
      }

      File[] files = sourceDir.listFiles();
      if (files != null) {
         File[] var3 = files;
         int var4 = files.length;
         for(int var5 = 0; var5 < var4; ++var5) {
            File entry = var3[var5];
            File destination = new File(targetDir, entry.getName());
            if (entry.isDirectory()) {
               copyDirectory(entry, destination);
            } else {
               Files.copy(entry.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
         }
      }
   }

}
