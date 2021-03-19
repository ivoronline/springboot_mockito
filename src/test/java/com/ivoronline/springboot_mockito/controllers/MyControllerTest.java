package com.ivoronline.springboot_mockito.controllers;

import com.ivoronline.springboot_mockito.entities.Person;
import com.ivoronline.springboot_mockito.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

  @Test
  void getPerson() {

    //MOCK CLASS: PersonRepository
    PersonRepository personRepositoryMock = Mockito.mock(PersonRepository.class);

    //MOCK METHOD: getPersonById(1)
    Mockito.when(personRepositoryMock.getPersonById(1)).thenReturn(new Person(1, "John", 20));

    //TEST CONTROLLER'S ENDPOINT
    MyController myController = new MyController();        //@Autowired not working
    String       result       = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Hello John", result);

  }

}

