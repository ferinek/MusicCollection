package com.wookie.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.wookie.dto.IdTagDTO;

public class CheckingService {

    public void scanLibrary(File file) throws IOException {
        // TODO get problems from scanning
        if (file.isDirectory()) {
            File[] artists = file.listFiles();
            for (File artist : artists) {
                scanArtist(artist);
            }

        } else {
            System.err.println("Given path is not directory!!");
        }
    }

    private void scanArtist(File artist) throws IOException {
        if (artist.isDirectory()) {
            FileNameService.checkArtist(artist.getName());
            File[] albums = artist.listFiles();
            for (File album : albums) {
                scanAlbum(artist, album);
            }
        }
    }

    private void scanAlbum(File artist, File album) throws IOException {

        // TODO GET ALBUM DATA FROM INTERNET
        // TODO checkIfAlltracks
        File[] tracks = album.listFiles();
        for (File track : tracks) {
            if (isMusicFile(track)) {
                parseTrack(track, album.getName(), artist.getName());
            } else {
                // TODO REMOVE UNNESESERY FILES
                System.err.println("Found unnesesary file" + track.getName());
            }

        }
    }

    private void parseTrack(File track, String name, String name2) throws IOException {
        IdTagDTO tagDTO = Mp3TagEditService.getTagDTO(track);
        String type = FilenameUtils.getExtension(track.getName());
        FileNameService.fixFileNameConvention(track, tagDTO, type);
        System.out.println(tagDTO);
    }

    private boolean isMusicFile(File file) {
        return true;
    }
}
