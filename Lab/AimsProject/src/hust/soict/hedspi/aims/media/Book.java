package Lab.AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    //Attribute
    private List<String> authors = new ArrayList<>();

    //Constructor
    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    //Method to add an author
    //If the author is already in the list, display a message; otherwise, add the author and display a success message
    public void addAuthor(String authorName){
        if(authors.contains(authorName)){
            System.out.println("Author is already in the list");
            return;
        }
        authors.add(authorName);
        System.out.println("Added author successfully");
    }

    //Method to remove an author
    //If the author is not in the list, display a message; otherwise, remove the author and display a success message.
    public void removeAuthor(String authorName){
        if(!authors.contains(authorName)){
            System.out.println("Author is absent in the list");
            return;
        }
        authors.remove(authorName);
        System.out.println("Removed author successfully");
    }

    //Getter and Setter
    public List<String> getAuthors(){return authors;}

    public void setAuthors(List<String> authors){this.authors = authors;}

    //Method to print details of a book
    @Override
    public void print(){
        System.out.print(getId() + ". Book - "
        + getTitle() + " - "
        + getCategory() + " - ");
        for (String author: authors){
            System.put.print(author + " - ");
        }
        System.out.println(getCost() + "$");
    }
}
