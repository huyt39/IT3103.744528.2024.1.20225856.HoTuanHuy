package Lab02.AimsProject;

public class Aims {
    public static void main(String[] args){
        Cart cart = new Cart();
        DigitalVideoDisc disc1 = new DigitalVideoDisc("The lion king","Animation","Roger Allers",87,19.95f);
        //cart.addDigitalVideoDisc(disc1);
        DigitalVideoDisc disc2 = new DigitalVideoDisc("Star Wars","Science fiction","george lucas",87,24.95f);
        //cart.addDigitalVideoDisc(disc2);
        DigitalVideoDisc disc3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        //cart.addDigitalVideoDisc(disc3);
        
        System.out.println("Ho Tuan Huy - 20225856: DVD1's id: " + disc1.getId());
        System.out.println("Ho Tuan Huy - 20225856: DVD2's id: " + disc2.getId());
        
    }
}