package com.br.miura.services;

import com.br.miura.controllers.PersonController;
import com.br.miura.data.vo.v1.PersonVO;
//import com.br.miura.data.vo.v2.PersonVOV2;
import com.br.miura.exceptionmodels.ResourceNotFoundException;
import com.br.miura.mapper.ModelMapping;
import com.br.miura.mapper.custom.PersonMapper;
import com.br.miura.models.Person;
import com.br.miura.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper mapper ;
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<PersonVO> findAll() {
        logger.info("Finding All Persons!");
        var persons = ModelMapping.parseListObjects(repository.findAll(), PersonVO.class);
        persons
                .stream()
                .forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey() )).withSelfRel()));
        return persons;

    }


    public PersonVO findById(Long id) {

        logger.info("Finding One Person");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id! "));
        var vo = ModelMapping.parseObject(entity, PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return vo;

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


    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");
        var entity = ModelMapping.parseObject(person, Person.class);
            var vo = ModelMapping.parseObject(repository.save(entity), PersonVO.class);
            vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
            return vo;
    }
//    public PersonVOV2 createV2(PersonVOV2 person) {
//        logger.info("Creating one person with V2!");
//        var entity = mapper.convertVoToEntity(person);
//            var vo = mapper.convertEntityToVo(repository.save(entity));
//            return vo;
//    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating a person!");

         var entity = repository.findById(person.getKey())
                 .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = ModelMapping.parseObject(repository.save(entity), PersonVO.class);
        vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());
        return vo;
    }
    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        repository.delete(entity);
    }


}
