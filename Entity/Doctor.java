package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
