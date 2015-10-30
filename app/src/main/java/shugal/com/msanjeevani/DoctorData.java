package shugal.com.msanjeevani;

/**
 * Created by abhishek on 31/10/15.
 */
public class DoctorData {
    private int id;
    private String name;
    private String hospital;

    public DoctorData() {

    }

    public DoctorData(String name, String hospital) {
        this.name = name;
        this.hospital = hospital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
