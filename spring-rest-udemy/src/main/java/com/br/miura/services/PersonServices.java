package com.br.miura.services;

import com.br.miura.exceptionmodels.ResourceNotFoundException;
import com.br.miura.models.Person;
import com.br.miura.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {


        return repository.findAll();

       /* mock
       List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
           Person person = MockPerson(i);
           persons.add(person);
       }
        */
    }


    public Person findById(Long id) {

        logger.info("Finding One Person");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id! "));

        /*Isso é um mock, linhas de codigos para ajustar na sustentação inicial do projeto
        private Person MockPerson(int i) {
        logger.info("Finding all people!");
        Person person = new Person();
        person.setFirstName("person name " +  i);
        person.setLastName("Last name" +  i);
        person.setAddress("Some addres in Brazil" +  i);
        person.setGender("M");
       return person;
        */
    }


    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating a person!");

         var entity = repository.findById(person.getId())
                 .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }
    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }


}
