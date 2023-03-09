package ru.mrSergey.DAO;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.mrSergey.models.Person;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    @Autowired
    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNPlus1(){
        Session session = entityManager.unwrap(Session.class);

        Set<Person> people = new HashSet<Person>(session.createQuery("select p from Person p left join fetch p.items", Person.class).getResultList());
        for(Person person:people) System.out.println("Person: " + person.getName() + " has: " + person.getItems());
    }
}
