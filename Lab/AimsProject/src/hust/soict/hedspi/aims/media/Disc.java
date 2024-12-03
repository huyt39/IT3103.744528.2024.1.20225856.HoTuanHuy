package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

public class Disc extends Media {
    //Attributes
    private String director; //Director of the disc (applicable for DVDs and some CDs)
    private int length; //Length of the disc content in seconds(applicable for DVDs and some CDs)

    //Constructors
    //Constructor for a disc with ID and title
    public Disc(int id, String title){super(id, title);}

    //Constructor for a disc with ID, title, category, cost, director and length
    public Disc(int id, String title, String category, float cost, String director, int length){
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    //Getters and Setters
    //Getter for the director of the disc
    public String getDirector(){return director;}
    //Setter for the director of the disc
    public void setDirector(String director){this.director = director;}

    //Getter for the length of the disc content
    public int getLength(){return length;}
    //Setter for the length of the disc content
    public void setLength(int length){this.length = length;}
    
}
