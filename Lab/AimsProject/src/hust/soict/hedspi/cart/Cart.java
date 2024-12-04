package Lab.AimsProject.src.hust.soict.hedspi.cart;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Lab.AimsProject.src.hust.soict.hedspi.aims.media.Media;

public class Cart {
    // Hằng số cho số lượng DVD tối đa có thể đặt trong giỏ hàng
    public static final int MAX_NUMBERS_ORDERED = 20;
    

    //Attribute
    private List<Media> itemsOrdered = new ArrayList<>(); //List to store ordered Media items

    //Constructor
    public Cart(){

    }

    //Method to add a new media to the cart
    public void addMedia(Media media){
        itemsOrdered.add(media);
        System.out.println("Ho Tuan Huy 20225856 - Added successfully");
    }

    //Method to remove a media from the cart
    public void removeMedia(Media media){
        //Search for media
        int indexOfRemoved = itemsOrdered.indexOf(media);
        //If not found
        if(indexOfRemoved == -1){
            System.out.println("Ho Tuan Huy 20225856 - Not found media!");
            return;
        }
        //Remove
        itemsOrdered.remove(indexOfRemoved);
        //Notify
        System.out.println("Ho Tuan Huy 20225856 - Removed successfully");
    }

    //Method to calculate the total cost of all items in the cart
    public double totalCost(){
        float cost = 0;
        for (Media media: itemsOrdered){
            cost += media.getCost();
        }
        return Math.round(cost * 100.0)/100.0;
    }

    //Method to print the list of ordered items in the cart,
    //including the details of each item and the total cost
    public void printCart(){
        System.out.println("********************CART********************");
        System.out.println("Ho Tuan Huy 20225856 - Ordered Items:");
        for(Media media: itemsOrdered){
            media.print();
        }
        System.out.println("Ho Tuan Huy 20225856 - Total cost: " + totalCost());
        System.out.println("********************************************");
    }

    //Method to search for media in the cart by ID and display the search results
    public Media searchByID(int id){
        return itemsOrdered.stream()
        .filter(disc -> disc.getId() == id)
        .findFirst()
        .orElse(null);
    }

    //Method to search for DVDs in the cart by title and print the results
    public Media searchByTitle(String title){
        return itemsOrdered.stream()
        .filter(disc -> disc.getTitle().contains(title))
        .findFirst()
        .orElse(null);
    }

    public void emptyCart(){
        itemsOrdered.clear();
    }

    public List<Media> getItemsOrdered() {return itemsOrdered;}

    public void searchById(int inputId){
        System.out.println("********************CART********************");
        Scanner scanner = new Scanner(System.in);

        //Hien thi thong bao yeu cau nhap xau
        System.out.println("Ho Tuan Huy 20225856 - Enter the title:");

        //Doc xau tu user
        String inputTitle = scanner.nextLine();

        int checkItemFound = 0;
        for(Media media: itemsOrdered){
            if(media.getTitle().equals(inputTitle)){
                System.out.println(media.toString() + " found!");
                checkItemFound = 1;
            }
        }
        if(checkItemFound == 0){
            System.out.println(inputTitle + " not found!");
        }
        System.out.println("********************************************");
        scanner.close();
    }

    public void sortByTitleCost(){
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByCostTitle(){
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }

    public Media findMedia(String title){
        return itemsOrdered.stream()
        .filter(media -> media.getTitle().contains(title))
        .findFirst()
        .orElse(null);
    }


}