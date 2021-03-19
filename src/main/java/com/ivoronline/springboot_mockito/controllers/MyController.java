package com.ivoronline.springboot_mockito.controllers;

import com.ivoronline.springboot_mockito.entities.Person;
import com.ivoronline.springboot_mockito.repositories.PersonRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/GetPerson")
  public String getPerson(@RequestParam Integer id) {

    //GET PERSON
    PersonRepository personRepository = new PersonRepository();  //@Autowired not working for JUnit Test
    Person           person           = personRepository.getPersonById(id);

    //GREET PERSON
    return "Hello " + person.name;

  }

}
