package models;

public class Claim {
//    | coverage_type | claim_id | amount | date      | description             | supporting_documents |
private String claimId;
    private double amount;
    private String date;
    private String description;
    private String supportingDocuments;

    public Claim(String claimId, double amount, String date, String description, String supportingDocuments) {
        this.claimId = claimId;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.supportingDocuments = supportingDocuments;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(String supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

}
