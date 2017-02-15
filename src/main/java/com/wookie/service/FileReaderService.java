package com.wookie.service;

import java.io.File;

import com.wookie.dto.IdTagDTO;
import com.wookie.enums.EFileType;

public class FileReaderService {

    public static EFileType getFileType(File file) {
        return null;
    }

    public static boolean isMusicFile(File file) {
        return true;
    }

    public static void scanLibrary(File file) {
        if (file.isDirectory()) {
            File[] artists = file.listFiles();
            for (File artist : artists) {
                System.out.println(artist.getName());
                scanArtist(artist);
            }

        } else {
            System.err.println("Given path is not directory!!");
        }
    }

    private static void scanArtist(File artist) {
        if (artist.isDirectory()) {
            FileNameService.checkArtist(artist.getName());
            File[] albums = artist.listFiles();
            for (File album : albums) {
                System.out.println(album.getName());
                scanAlbum(artist, album);
            }
        }
    }

    private static void scanAlbum(File artist, File album) {

        if (hasManyCD(album)) {

        } else {
            // TODO checkIfAlltracks
            // TODO GET ALBUM DATA FROM INTERNET
            File[] tracks = album.listFiles();
            for (File track : tracks) {
                if (isMusicFile(track)) {
                    parseTrack(track, album.getName(), artist.getName());
                } else {
                    // TODO REMOVE UNNESESERY FILES
                    System.err.println("Fount unnesesary file" + track.getName());
                }

            }
        }
    }

    private static void parseTrack(File track, String name, String name2) {
        IdTagDTO tagDTO = Mp3TagEditService.getTagDTO(track);
        System.out.println(tagDTO);
    }

    private static boolean hasManyCD(File album) {
        // TODO Auto-generated method stub
        return false;
    }

}
