package com.example.demo.controller;

import com.example.demo.model.Experience;
import com.example.demo.model.Person;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {
    //@Autowired used to make all Repos avaiable in Controller
    @Autowired
    PersonRepo personRepo;


  @Autowired
    EducationRepo educationRepo;

    @Autowired
    ExperienceRepo experienceRepo;

    @Autowired
    SkillRepo   skillRepo;

    @Autowired
    ReferenceRepo referenceRepo;

    //Below will be map of pathing for web app
    @GetMapping("/")
    public String showIndex() {return "index";}

    @GetMapping("/addPerson")
    public String personForm(Model model){

       Person person = new Person();

       model.addAttribute("person", person);

        return "personForm";
    }

//    When compolete with resume create getmsp class for all models from repo and print our theirs list
//    kinda like this

//@GetMapping("/completeresume")
//    public String completeresume(Model model){
//    model.addAttribute("personlist",personRepo.findAll());
//model.addAttribute("skilslist",skillRepo.findAll());
//
//return "completedresume";
//}

    @PostMapping("/addPerson")
    public String addPerson(@Valid @ModelAttribute("person") Person person,Model model, BindingResult result){
        if(result.hasErrors()){
            return "personForm";
        }
        personRepo.save(person);
        model.addAttribute("personlist",personRepo.findAll());

        return "personlist";
    }

    @GetMapping("/addEducation")
    public String addEducation(){return "educationForm";}

    @GetMapping("/summary")
    public String showSummary() {return "summary";}

    @GetMapping("/logo")
    public String showLogo() {return "logo";}

    @GetMapping("/contactInfo")
    public String showContactInfo() {return "contactInfo";}

    @GetMapping("/education")
    public String showEducation() {return "education";}

    @GetMapping("/skills")
    public String showSkills() {return "skills";}

    @GetMapping("/experience")
    public String showExperience() {return "experience";}

    @GetMapping("/view")
    public String showView() {return "view";}

    @RequestMapping("/completedResume")
    public String showResume(Model model) {
        model.addAttribute("persons", personRepo.findAll());
        return "completedResume";

    }

    /*@RequestMapping("/bookList")
    public String listBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }*/

    @GetMapping("/coverLetter")
    public String showCoverLetter() {return "coverLetter";}

    @RequestMapping("/update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepo.findOne(id));
        return "resumeForm";
    }







}
