package api.steps.dataTransformers;

import api.domains.*;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public UserProfile userEntry(Map<String, String> entry) {
        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        String dob = entry.get("dob");
        String ssn = entry.get("ssn");
        String emailAddress = entry.get("emailAddress");
        String password = entry.get("password");
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String homePhone = entry.get("homePhone");
        String mobilePhone = entry.get("mobilePhone");
        String workPhone = entry.get("workPhone");

        return new UserProfile(title, firstName, lastName, gender, dob, ssn, emailAddress, password, address, locality, region, postalCode, country, homePhone, workPhone, mobilePhone);
    }

    @DataTableType
    public AccountModel accountModelEntry(Map<String, String> entry) {
        String accountName;
        if(entry.get("accountName")== null){
            accountName = "";
        } else {
            accountName = entry.get("accountName");
        }
        String accountTypeCode = entry.get("accountTypeCode");
        double openingDeposit = Double.parseDouble(entry.get("openingDeposit"));
        String ownerTypeCode = entry.get("ownerTypeCode");
        if(entry.get("accountStandingName")!=null){
            String accountStandingName = entry.get("accountStandingName");
            return new AccountModel(accountName, accountTypeCode, openingDeposit, ownerTypeCode, accountStandingName);
        }
        return new AccountModel(accountName, accountTypeCode, openingDeposit, ownerTypeCode);
    }

    @DataTableType
    public ErrorResponse errorResponseEntry(Map<String, String> entry){
        String timestamp = entry.get("timestamp");
        int status = Integer.parseInt(entry.get("status"));
        String error =  entry.get("error");
        String message =  entry.get("message");
        String path =  entry.get("path");
        return new ErrorResponse(timestamp, status, error, message, path);
    }

    @DataTableType
    public User userResponseEntry(Map<String, String> entry){
         long id = Long.parseLong(entry.get("id"));
         String username = entry.get("username");
         boolean enabled = Boolean.parseBoolean(entry.get("enabled"));
         boolean accountNonExpired = Boolean.parseBoolean(entry.get("accountNonExpired"));
         boolean accountNonLocked = Boolean.parseBoolean(entry.get("accountNonLocked"));
         boolean credentialsNonExpired = Boolean.parseBoolean(entry.get("credentialsNonExpired"));
         long profile_id = Long.parseLong(entry.get("profile_id"));
        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        String dob = entry.get("dob");
        String dom = entry.get("dom");
        String ssn = entry.get("ssn");
        String emailAddress = entry.get("emailAddress");
        String password = entry.get("password");
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String homePhone = entry.get("homePhone");
        String mobilePhone = entry.get("mobilePhone");
        String workPhone = entry.get("workPhone");

        UserProfile userProfile = new UserProfile(profile_id, title, firstName, lastName, gender, dob, dom, ssn, emailAddress, password, address, locality, region, postalCode, country, homePhone, workPhone, mobilePhone);
        return new User(id, username, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired, userProfile);
    }

    @DataTableType
    public UserProfileModel userProfileModelEntry(Map<String, String> entry) {
        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        String dob = entry.get("dob");
        String ssn = entry.get("ssn");
        String emailAddress = entry.get("emailAddress");
        String password = entry.get("password");
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String homePhone = entry.get("homePhone");
        String mobilePhone = entry.get("mobilePhone");
        String workPhone = entry.get("workPhone");

        return new UserProfileModel(title, firstName, lastName, gender, dob, ssn, emailAddress, password, address, locality, region, postalCode, country, homePhone, workPhone, mobilePhone);
    }
}
