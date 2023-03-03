package ru.mrSergey.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mrSergey.models.Person;
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {

}
