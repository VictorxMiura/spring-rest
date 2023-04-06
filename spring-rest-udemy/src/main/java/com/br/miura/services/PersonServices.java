package com.br.miura.services;

import com.br.miura.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        //outro tipo de mock
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = MockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person findById(String id) {

        //Isso é um mock, linhas de codigos para ajustar na sustentação inicial do projeto
        logger.info("Finding One Person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Marinho");
        person.setAddress("Vila Mammus");
        person.setGender("M");
        return person;
    }
    private Person MockPerson(int i) {
        logger.info("Finding all people!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("person name " +  i);
        person.setLastName("Last name" +  i);
        person.setAddress("Some addres in Brazil" +  i);
        person.setGender("M");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating a person!");
        return person;
    }
    public void delete(String id) {
        logger.info("Deleting one person!");

    }


}
