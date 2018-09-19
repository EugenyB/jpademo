package dao;

import tables.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDAO {
    @PersistenceContext
    EntityManager em;

    public List<Person> findAll() {
        return em.createQuery("select p from Person p", Person.class).getResultList();
    }

    public void add(Person p) {
        em.persist(p);
    }
}
