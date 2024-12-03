package Lab.AimsProject.src.hust.soict.hedspi.aims.media;
//Track class represents a music track and implements the Playable interface
public class Track implements Playable {
    //Attributes
    private String title; //title of the track
    private int length; //length of the track in seconds

    //Constructor
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    //Getters and Setters
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public int getLength(){return length;}
    public void setLength(int length){this.length = length;}

    //Method to play the track
    public void play(){
        System.out.println("Playing track: "+title);
        System.out.println("Track length: " + length + " seconds");
    }

    @Override
    public boolean equals(Object obj){
        Track track = (Track) obj;
        return track.getTitle().equals(this.getTitle()) && track.getLength() == this.getLength();
    }
}
