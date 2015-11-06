package classloader;

import sun.misc.Launcher;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Liuxey on 2015/11/6.
 */
public class TestClassloader1 {

    public static void main(String[] args) {
        // coreClassLoaderUrls();
//        extensionClassloader();
        systemClassLoader();
    }

    private static void systemClassLoader() {
        String[] arrays = System.getProperty("java.class.path").split(";");
        for (String a :
                arrays) {
            System.out.println(a);
        }

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
    }

    private static void extensionClassloader() {
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("The parent of extension loader is : " + classLoader);
    }

    private static void coreClassLoaderUrls() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url :
                urls) {
            System.out.println(url.toExternalForm());
        }
    }
}