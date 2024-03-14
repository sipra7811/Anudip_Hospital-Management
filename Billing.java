package anudip_project;

import java.sql.Date;

public class Billing {
	private int billingId;
    private Patient patient; // Assuming a Billing belongs to a Patient
    private int amount;
    private Date billingDate;
    private String paymentStatus;

    // Getters and setters
}
