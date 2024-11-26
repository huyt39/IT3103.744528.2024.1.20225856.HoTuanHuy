package Lab02.AimsProject;

import java.util.Objects;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    //Constructor 1: tao DVD chi voi title
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs+=1;
        this.id = nbDigitalVideoDiscs;
    }

    //Constructor 2: tao DVD voi title, category, cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs+=1;
        this.id = nbDigitalVideoDiscs;
    }

    //Constructor 3: tao DVD voi title, catefory, director, cost
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs+=1;
        this.id = nbDigitalVideoDiscs;
    }

    //Constructor 4: tao DVD voi title, category, director, length, cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs+=1;
        this.id = nbDigitalVideoDiscs;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalVideoDisc that = (DigitalVideoDisc) o;
        return length == that.length &&
                Float.compare(that.cost, cost) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(category, that.category) &&
                Objects.equals(director, that.director);
    }
}
