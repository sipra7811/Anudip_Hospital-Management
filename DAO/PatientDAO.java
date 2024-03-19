package DAO;

import javax.persistence.EntityManager;

import Entity.Patient;

import java.util.List;

public class PatientDAO {
    private EntityManager entityManager;

    public PatientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
    }

    public Patient getPatientById(int patientId) {
        return entityManager.find(Patient.class, patientId);
    }

    public void updatePatient(Patient patient) {
        entityManager.getTransaction().begin();
        entityManager.merge(patient);
        entityManager.getTransaction().commit();
    }

    public void deletePatient(int patientId) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(patient);
            entityManager.getTransaction().commit();
        }
    }

    public List<Patient> getAllPatients() {
        return entityManager.createNativeQuery("SELECT p FROM Patient p", Patient.class).getResultList();
    }
}

