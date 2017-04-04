/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class UserSessionBean implements ModeloUsuario {

    @PersistenceContext(unitName = "userJPAPU")
    protected EntityManager em;

    @Override
    public int contarUsuarios() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            throw e;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Usuarios buscarUsuarioId(Integer id) {
        try {
            return em.find(Usuarios.class, id);
        } catch (Exception e) {
            throw e;
        }

    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        try {
            return findUsuariosEntities(false, maxResults, firstResult);
        } catch (Exception e) {
            throw e;
        }

    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {

        try {

            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<Usuarios> listaUsuarios() {
        try {
            return findUsuariosEntities(true, -1, -1);
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void crearUsuario(Usuarios usuarios) {
        try {
            em.persist(usuarios);
        } catch (Exception e) {
            throw e;
        }

    }

}
