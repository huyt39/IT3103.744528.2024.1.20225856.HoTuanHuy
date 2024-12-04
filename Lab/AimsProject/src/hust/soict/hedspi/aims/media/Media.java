package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import Lab.AimsProject.src.hust.soict.hedspi.aims.media.*;


public abstract class Media {
    //Attributes
    private int id; //Unique identifier for the media
    private String title; //Title of the media
    private String category; //Category of the media
    private float cost; //Cost of the media

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    //Constructors
    public Media(int id, String title){
        this.id = id;
        this.title = title;
    }

    public Media(String title, String category, float cost){
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public Media(int id, String title, String category, float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    //Method to print details of the media
    public void print(){
        //Implementation specific to each subclass
    }
    //Method to check if the title matches the media
    //Getters and Setters
    public int getId(){return id;}
    public void setId(int id){this.id = id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}
    public float getCost(){return cost;}
    public void setCost(float cost){this.cost = cost;}

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title); // So sánh không phân biệt chữ hoa/thường
    }

    @Override
    public String toString(){
        return "Media{" + "id=" + id + ", title='" + title + '\'' +
        ", category='" + category + '\'' + ", cost=" + cost + '}';
    }

    @Override
    public boolean equals(Object o){
        Media media = (Media) o;
        try{
            String title = media.getTitle();
            return title.equals(this.getTitle());
        } catch (NullPointerException e){
            return false;
        }
    }
}

