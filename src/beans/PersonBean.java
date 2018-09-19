package beans;

import dao.PersonDAO;
import tables.Person;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PersonBean implements Serializable {
    @EJB
    PersonDAO personDAO;

    private Person tmpPerson = new Person();

    public List<Person> getPeople() {
        return personDAO.findAll();
    }

    public void add() {
        personDAO.add(tmpPerson);
        tmpPerson = new Person();
    }

    public Person getTmpPerson() {
        return tmpPerson;
    }

    public void setTmpPerson(Person tmpPerson) {
        this.tmpPerson = tmpPerson;
    }
}
