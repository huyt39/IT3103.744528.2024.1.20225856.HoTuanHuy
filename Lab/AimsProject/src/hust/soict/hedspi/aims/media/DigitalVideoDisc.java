package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    //Constructors
    //Constructor for a DVD with id and title
    public DigitalVideoDisc(int id, String title){super(id, title);}
    //Constructor for a DVD with ID, title, category, and cost
    public DigitalVideoDisc(int id, String title, String category, float cost){
        this(id, title);
        this.setCategory(category);
        this.setCost(cost);
    }

    //Constructor for a DVD with ID, title, category, director, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, float cost){
        this(id, title, category, cost);
        this.setDirector(director);
    }

    //Constructor for a DVD with ID, title, category, director, length, and cost
    public DigitalVideoDisc(int id, String title, String category, String director, float cost, int length){
        this(id, title, category, director, cost);
        this.setLength(length);
    }

    //Method to print details of a DVD
    @Override
    public void print(){
        System.out.println(getId() + ". DVD - "
        +getTitle() + " - "
        + getCategory() + " - "
        + getDirector() + " - "
        + getLength() + ": "
        +getCost() + "$");
    }

    //Method to play a DVD
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: "+ this.getLength());
    }


    
} 
