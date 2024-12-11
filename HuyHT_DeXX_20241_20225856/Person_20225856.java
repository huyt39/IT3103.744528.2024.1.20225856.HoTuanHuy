package HuyHT_DeXX_20241_20225856;
public class Person_20225856 {

    private String name_20225856;
    private int age_20225856;
    private String address_20225856;

    // Constructor
    public Person_20225856(String name_20225856, int age_20225856, String address_20225856) {
        this.name_20225856 = name_20225856;
        this.age_20225856 = age_20225856;
        this.address_20225856 = address_20225856;
    }
    public Person_20225856() {}

    // Getters
    public String getName_20225856() {
        return name_20225856;
    }
    public int getAge_20225856() {
        return age_20225856;
    }
    public String getAddress_20225856() {
        return address_20225856;
    }
    // Setters
    public void setName_20225856(String name_20225856) {
        this.name_20225856 = name_20225856;
    }
    public void setAge_20225856(int age_20225856) {
        this.age_20225856 = age_20225856;
    }

    public void setAddress_20225856(String address_20225856) {
        this.address_20225856 = address_20225856;
    }

    //toString
    public String toString() {
        return " Name: " + getName_20225856() + ", age: " + getAge_20225856() + ", address: " + getAddress_20225856() + ", ";
    }
    public void displayInfo_20225856() {
        System.out.println(toString());
    }
}
