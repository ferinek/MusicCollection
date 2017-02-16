package com.wookie.dto;

public class IdTagDTO {

    private String title;
    private String artist;
    private String album;
    private String year;
    private String track;
    private String trackTotal;
    private String discNumber;
    private String discTotal;


    public String getTrackTotal() {
        return trackTotal;
    }

    public void setTrackTotal(String trackTotal) {
        this.trackTotal = trackTotal;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getDiscTotal() {
        return discTotal;
    }

    public void setDiscTotal(String discTotal) {
        this.discTotal = discTotal;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(artist).append(" - ").append(album).append(" (").append(year).append(")").append(": ").append(title).append(" (").append(track).append("\\").append(trackTotal).append(", CD ").append(discNumber).append("\\").append(discTotal);
        
//        builder.append("IdTagDTO [title=").append(title).append(", artist=").append(artist).append(", album=").append(album).append(", year=").append(year)
//                .append(", track=").append(track).append(", trackTotal=").append(trackTotal).append(", discNumber=").append(discNumber).append(", discTotal=")
//                .append(discTotal).append("]");
        return builder.toString();
    }

    
    

}
