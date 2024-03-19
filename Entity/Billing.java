package Entity;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Billing")
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_id")
    private int billingId;

    @Column(name = "amount")
    private int amount;

    @Column(name = "billing_date")
    private Date billingDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}