package com.github.fommil.jni;

import java.util.logging.Logger;

public final class JniNamer {

    private static final Logger log = Logger.getLogger(JniNamer.class.getName());
    private static final String UNKNOWN = "unknown";

    public static String getJniName(String stem) {
        String arch = arch();
        String abi = "";
        String os = os();
        String extension = extension(os);
        return stem + "-" + os + "-" + arch + abi + "." + extension;
    }

    private static String arch() {
        String arch = System.getProperty("os.arch", "").toLowerCase();
        if ((arch.equals("x86_64")) || (arch.equals("amd64"))) {
            return "x86_64";
        }
        if ((arch.equals("x86")) || (arch.equals("i386")) || (arch.equals("i486")) || (arch.equals("i586"))
                || (arch.equals("i686"))) {
            return "i686";
        }
        log.warning("unrecognized architecture: " + arch);
        return UNKNOWN;
    }

    private static String os() {
        String os = System.getProperty("os.name", "").toLowerCase();
        if (os.startsWith("windows")) {
            return "win";
        }
        if (os.startsWith("linux")) {
            return "linux";
        }
        if (os.startsWith("android")) {
            return "android";
        }
        log.warning("unable to detect OS type: " + os);
        return UNKNOWN;
    }

    private static String extension(String os) {
        if (os.equals("win")) {
            return "dll";
        }
        return "so";
    }
}
