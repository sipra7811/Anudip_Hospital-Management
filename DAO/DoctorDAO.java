package DAO;

import javax.persistence.EntityManager;

import Entity.Doctor;

import java.util.List;

public class DoctorDAO {
    private EntityManager entityManager;

    public DoctorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addDoctor(Doctor doctor) {
        entityManager.getTransaction().begin();
        entityManager.persist(doctor);
        entityManager.getTransaction().commit();
    }

    public Doctor getDoctorById(int doctorId) {
        return entityManager.find(Doctor.class, doctorId);
    }

    public void updateDoctor(Doctor doctor) {
        entityManager.getTransaction().begin();
        entityManager.merge(doctor);
        entityManager.getTransaction().commit();
    }

    public void deleteDoctor(int doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(doctor);
            entityManager.getTransaction().commit();
        }
    }

    public List<Doctor> getAllDoctors() {
        return entityManager.createNativeQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
    }
}

