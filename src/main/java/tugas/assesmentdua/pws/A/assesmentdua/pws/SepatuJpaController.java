/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.assesmentdua.pws.A.assesmentdua.pws;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tugas.assesmentdua.pws.A.assesmentdua.pws.exceptions.NonexistentEntityException;
import tugas.assesmentdua.pws.A.assesmentdua.pws.exceptions.PreexistingEntityException;

/**
 *
 * @author ACHI
 */
public class SepatuJpaController implements Serializable {

    public SepatuJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tugas.assesmentdua.pws_A.assesmentdua.pws_jar_0.0.1-SNAPSHOTPU");

    SepatuJpaController() {

    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sepatu sepatu) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sepatu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSepatu(sepatu.getIdsepatu()) != null) {
                throw new PreexistingEntityException("Sepatu " + sepatu + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sepatu sepatu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sepatu = em.merge(sepatu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sepatu.getIdsepatu();
                if (findSepatu(id) == null) {
                    throw new NonexistentEntityException("The sepatu with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sepatu sepatu;
            try {
                sepatu = em.getReference(Sepatu.class, id);
                sepatu.getIdsepatu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sepatu with id " + id + " no longer exists.", enfe);
            }
            em.remove(sepatu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sepatu> findSepatuEntities() {
        return findSepatuEntities(true, -1, -1);
    }

    public List<Sepatu> findSepatuEntities(int maxResults, int firstResult) {
        return findSepatuEntities(false, maxResults, firstResult);
    }

    private List<Sepatu> findSepatuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sepatu.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sepatu findSepatu(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sepatu.class, id);
        } finally {
            em.close();
        }
    }

    public int getSepatuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sepatu> rt = cq.from(Sepatu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
