package com.wookie.config;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wookie.service.FileReaderService;

public class Initializer {

    public static void main(String[] args) throws IOException {
        Logger.getLogger("org.jaudiotagger").setLevel(Level.OFF);
        FileReaderService.scanLibrary(new File("C:\\Users\\krzysztof.slodowicz.BKMGTSRV\\Music"));
    }

}
