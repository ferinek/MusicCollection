package com.wookie.service;

import java.io.File;
import java.util.List;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.datatype.Artwork;

import com.wookie.dto.IdTagDTO;

public class Mp3TagEditService {

    public static boolean hasTag(File file) {
        return false;
    }

    public static IdTagDTO getTagDTO(File file) {
        //TODO use MP3 tags 
        try {
            AudioFile f = AudioFileIO.read(file);
            Tag tag = f.getTag();
            IdTagDTO dto = new IdTagDTO();
            dto.setArtist(tag.getFirst(FieldKey.ARTIST));
            dto.setAlbum(tag.getFirst(FieldKey.ALBUM));
            dto.setTitle(tag.getFirst(FieldKey.TITLE));
            dto.setTrack(tag.getFirst(FieldKey.TRACK));
            dto.setYear(tag.getFirst(FieldKey.YEAR));
            dto.setTrackTotal(tag.getFirst(FieldKey.TRACK_TOTAL));
            
            List<Artwork> artworkList = tag.getArtworkList();
            System.out.println("ArtworkCount: "+ artworkList.size());
            for (Artwork art:artworkList){
                System.out.println(art.getDescription());
            }
            return dto;
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
    
    public static void recreateIdTag(File file) {

    }

}
