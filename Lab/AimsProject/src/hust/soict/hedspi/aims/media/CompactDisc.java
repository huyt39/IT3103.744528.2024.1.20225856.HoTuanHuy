package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.List;
import java.util.ArrayList;


public class CompactDisc extends Disc implements Playable {
    //Attributes
    private String artist; //artist of the CD
    private List<Track> tracks = new ArrayList<>(); //List of tracks in the CD

    //Constructor
    public CompactDisc(int id, String title, String category, float cost,
    String director, int length, String artist){
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String artist, float cost){
        super(title, category, artist, cost);
    }


    //Getter and Setter
    public String getArtist() {return artist;}
    public void setArtist(String artist){this.artist = artist;}

    //Method to add a track to the CD
    public void addTrack(Track track){
        int indexOfTrack = tracks.indexOf(track);
        if (indexOfTrack == -1){
            System.out.println("Track is already in the list");
            return;
        }
        tracks.add(track);
        System.out.println("Add track successfully");
    }

    //Method to remove a track
    public void removeTrack(Track track){
        int indexOfTrack = tracks.indexOf(track);
        if(indexOfTrack == -1){
            System.out.println("Track is absent in the list");
            return;
        }
        tracks.remove(indexOfTrack);
        System.out.println("Remove track successfully");
    }

    public List<Track> getTracks(){
        return tracks;
    }
    public void setTracks(ArrayList<Track> tracks){
        this.tracks = tracks;
    }

    //Method to get the total length of the CD by summing the lengths of all tracks
    @Override
    public int getLength(){
        int length = 0;
        for (Track track: tracks){
            length += track.getLength();
        }
        setLength(length);
        return length;
    }

    //Method to play the CD and its tracks
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + artist);
        System.out.println("CD length: " + this.getLength());
        for (Track track: tracks){
            track.play();
        }
    }

    //Method to print details of the CD
    @Override
    public void print(){
        System.out.println(getId() + ". CD - "
        +getTitle() + " - "
        + getCategory() + " - "
        + getDirector() + " - "
        + artist + " - "
        + getLength() + ": "
        +getCost() + "$");
    }
    
}
