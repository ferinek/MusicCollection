package com.wookie.service;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import com.wookie.dto.IdTagDTO;

public class Mp3TagEditService {

    public static boolean hasTag(File file) {
        return false;
    }

    public static IdTagDTO getTagDTO(File file) {
        try {
            AudioFile f = AudioFileIO.read(file);
            Tag tag = f.getTag();
            IdTagDTO dto = new IdTagDTO();
            dto.setArtist(tag.getFirst(FieldKey.ARTIST));
            dto.setAlbum(tag.getFirst(FieldKey.ALBUM));
            dto.setTitle(tag.getFirst(FieldKey.TITLE));
            dto.setTrack(tag.getFirst(FieldKey.TRACK));
            dto.setYear(tag.getFirst(FieldKey.YEAR));
            return dto;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void recreateIdTag(File file) {

    }

}
