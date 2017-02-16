package com.wookie.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.wookie.dto.IdTagDTO;

public class FileNameService {
    private static final String NAME_PATTERN = "<number>. <name>.<ext>";

    public static void fixFileNameConvention(File file, IdTagDTO tagDTO, String type) throws IOException {
        String name = generateName(tagDTO, type);
        if (!file.getName().equals(name)){
            Path source=file.toPath();
            Files.move(source, source.resolveSibling(name));
        }
    }

    private static String generateName(IdTagDTO tagDTO, String type) {
        return NAME_PATTERN.replace("<number>", getFullTrackNumer(tagDTO.getTrack())).replace("<name>", tagDTO.getTitle()).replace("<ext>", type);
    }

    private static CharSequence getFullTrackNumer(String track) {
        if (Integer.parseInt(track) < 10) {
            return "0" + track;
        }
        return track;
    }

    public static boolean checkArtist(String name) {
        // TODO Auto-generated method stub
        return false;
    }

}
