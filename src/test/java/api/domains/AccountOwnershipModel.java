package api.domains;

public class AccountOwnershipModel {
    private int id;
    private String code;
    private String name;
    public AccountOwnershipModel() {

    }
    public AccountOwnershipModel(int id, String code, String individual) {
        this.id = id;
        this.code = code;
        this.name = individual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String individual) {
        this.name = individual;
    }
}
