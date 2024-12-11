package HuyHT_DeXX_20241_20225856;
public class Officer_20225856 extends Person_20225856 {

    private String department_20225856;

    // Constructor
    public Officer_20225856(String name_20225856, int age_20225856, String address_20225856, String department_20225856) {
        super(name_20225856, age_20225856, address_20225856);
        this.department_20225856 = department_20225856;
    }

    // Getter
    public String getDepartment_20225856() {
        return department_20225856;
    }
    // Setter
    public void setDepartment_20225856(String department_20225856) {
        this.department_20225856 = department_20225856;
    }

    @Override
    public void displayInfo_20225856() {
        System.out.println("Officer_20225856" + toString() + department_20225856);
    }
}
