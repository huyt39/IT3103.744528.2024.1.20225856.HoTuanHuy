package HuyHT_DeXX_20241_20225856;
import java.util.ArrayList;

public class DistrictManagement {
    private ArrayList<Person_20225856> Persons;
    public DistrictManagement() {
        Persons = new ArrayList<>();
    }
    
    //addPerson de them mot nhan khau vao danh sach
    public void addPerson_20225856(Person_20225856 person) {
        Persons.add(person);
    }

    //displayAll de hien thi danh sach tat ca nhan khau
    public void displayAll_20225856() {
        for (Person_20225856 person : Persons) {
            person.displayInfo_20225856();
        }
    }
    
    //searchByName de tim kiem nhan khau theo ten
    public void searchByName_20225856(String name) {
        for (Person_20225856 person : Persons) {
            if (person.getName_20225856().equalsIgnoreCase(name)) {
                person.displayInfo_20225856();
                return;
            }
        }
        System.out.println("Not found!");
    }
}
