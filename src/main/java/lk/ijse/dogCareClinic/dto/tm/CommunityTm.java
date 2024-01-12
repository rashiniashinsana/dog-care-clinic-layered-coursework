package lk.ijse.dogCareClinic.dto.tm;

public class CommunityTm {
    private String projectId;
    private String name;
    private String date;
    private String location;

    public CommunityTm() {

    }

    public CommunityTm(String projectId, String name, String date, String location) {
        this.projectId = projectId;
        this.name = name;
        this.date = date;
        this.location = location;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
