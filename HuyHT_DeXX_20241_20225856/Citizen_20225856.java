package HuyHT_DeXX_20241_20225856;
public class Citizen_20225856 extends Person_20225856 {

    private String job_20225856;

    // Constructor
    public Citizen_20225856(String name_20225856, int age_20225856, String address_20225856, String job_20225856) {
        super(name_20225856, age_20225856, address_20225856);
        this.job_20225856 = job_20225856;
    }

    // Getter
    public String getJob_20225856() {
        return job_20225856;
    }

    // Setter
    public void setJob_20225856(String job_20225856) {
        this.job_20225856 = job_20225856;
    }

    @Override
    public void displayInfo_20225856() {
        System.out.println("Citizen_20225856" + toString() + job_20225856);
    }
}
