package DAO;

import javax.persistence.EntityManager;

import Entity.Billing;

import java.util.List;

public class BillingDAO {
    private EntityManager entityManager;

    public BillingDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addBilling(Billing billing) {
        entityManager.getTransaction().begin();
        entityManager.persist(billing);
        entityManager.getTransaction().commit();
    }

    public Billing getBillingById(int billingId) {
        return entityManager.find(Billing.class, billingId);
    }

    public void updateBilling(Billing billing) {
        entityManager.getTransaction().begin();
        entityManager.merge(billing);
        entityManager.getTransaction().commit();
    }

    public void deleteBilling(int billingId) {
        Billing billing = getBillingById(billingId);
        if (billing != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(billing);
            entityManager.getTransaction().commit();
        }
    }

    public List<Billing> getAllBillings() {
        return entityManager.createNativeQuery("SELECT b FROM Billing b", Billing.class).getResultList();
    }
}

