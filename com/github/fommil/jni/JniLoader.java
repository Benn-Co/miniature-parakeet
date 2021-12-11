package com.github.fommil.jni;

import java.io.*;
import java.net.URL;
import java.nio.channels.*;
import java.util.*;
import java.util.logging.Logger;

public final class JniLoader {

    private static final Logger log = Logger.getLogger(JniLoader.class.getName());
    private static final String JNI_EXTRACT_DIR_PROP = "com.github.fommil.jni.dir";
    private static final HashSet<String> loaded = new HashSet<String>();

    public static synchronized void load(String... paths) {
        if (paths == null || paths.length == 0) {
            throw new ExceptionInInitializerError("invalid parameters");
        }
        for (String path : paths) {
            String key = new File(path).getName();
            if (loaded.contains(key)) {
                return;
            }
        }

        String javaLibPath[] = System.getProperty("java.library.path").split(File.pathSeparator);

        for (String path : paths) {
            for (String libPath : javaLibPath) {
                File file = new File(libPath, path).getAbsoluteFile();
                if (file.exists() && file.isFile() && liberalLoad(file, path)) {
                    return;
                }
            }
            File extracted = extract(path);
            if (extracted != null && liberalLoad(extracted, path)) {
                return;
            }
        }

        throw new ExceptionInInitializerError(
                new StringBuilder("unable to load from ").append(Arrays.toString(paths)).toString());
    }

    private static boolean liberalLoad(File file, String name) {
        try {
            System.load(file.getAbsolutePath());
            log.info("Successfully loaded " + file);
            loaded.add(name);
            return true;
        } catch (UnsatisfiedLinkError e) {
            String tmpdir = System.getProperty("java.io.tmpdir");
            if (tmpdir != null && tmpdir.trim().length() > 2 && file.getAbsolutePath().startsWith(tmpdir)) {
                try {
                    file.delete();
                } catch (Exception ignore) {
                }
            }
            return false;
        } catch (SecurityException e) {
            return false;
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("resource")
    private static File extract(String path) {
        URL url = JniLoader.class.getResource(new StringBuilder("/").append(path).toString());
        if (url == null) {
            return null;
        }

        InputStream in = JniLoader.class.getResourceAsStream(new StringBuilder("/").append(path).toString());
        FileChannel dest = null;
        try {
            File file = file(path);
            deleteOnExit(file);
            ReadableByteChannel src = Channels.newChannel(in);
            dest = new FileOutputStream(file).getChannel();
            dest.transferFrom(src, 0L, 0x7fffffffffffffffL);
            if (dest != null) {
                dest.close();
            }
            if (in != null) {
                in.close();
            }
            return file;
        } catch (Exception e) {
            if (e instanceof SecurityException || e instanceof IOException) {
                return null;
            } else {
                throw new ExceptionInInitializerError(e);
            }
        } finally {
            try {
                if (dest != null) {
                    dest.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ignore) {
            }
        }
    }

    private static File file(String path) throws IOException {
        String name = new File(path).getName();

        String dir = System.getProperty(JNI_EXTRACT_DIR_PROP);
        if (dir == null) {
            return File.createTempFile("jniloader", name);
        }
        File file = new File(dir, name);
        if (file.exists() && !file.isFile()) {
            throw new IllegalArgumentException(file.getAbsolutePath() + " is not a file");
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    private static void deleteOnExit(File file) {
        try {
            file.deleteOnExit();
        } catch (Exception e) {
            try {
                System.gc();
                Thread.yield();
                file.deleteOnExit();
            } catch (Exception ignore) {
            }
        }
    }

    private JniLoader() {
    }
}
