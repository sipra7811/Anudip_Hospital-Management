package DAO;

import javax.persistence.EntityManager;

import Entity.Appointment;

import java.util.List;

public class AppointmentDAO {
    private EntityManager entityManager;

    public AppointmentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addAppointment(Appointment appointment) {
        entityManager.getTransaction().begin();
        entityManager.persist(appointment);
        entityManager.getTransaction().commit();
    }

    public Appointment getAppointmentById(int appointmentId) {
        return entityManager.find(Appointment.class, appointmentId);
    }

    public void updateAppointment(Appointment appointment) {
        entityManager.getTransaction().begin();
        entityManager.merge(appointment);
        entityManager.getTransaction().commit();
    }

    public void deleteAppointment(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(appointment);
            entityManager.getTransaction().commit();
        }
    }

    public List<Appointment> getAllAppointments() {
        return entityManager.createNativeQuery("SELECT a FROM Appointment a", Appointment.class).getResultList();
    }
}

