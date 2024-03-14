package anudip_project;
import java.util.Date;

public class Appointment {
	private int appointmentId;
    private Date appointmentDate;
    private String status;
    private String prescription;
    private Patient patient; // Assuming an Appointment belongs to a Patient
    private Doctor doctor; // Assuming an Appointment is assigned to a Doctor

    // Getters and setters
}
