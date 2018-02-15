package com.example.demo.controller;

import com.example.demo.model.Experience;
import com.example.demo.model.Person;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class HomeController {
    //@Autowired used to make all Repos avaiable in Controller
    @Autowired
    PersonRepo personRepo;

 /*   @Autowired
    EducationRepo educationRepo;

    @Autowired
    ExperienceRepo experienceRepo;

    @Autowired
    SkillRepo   skillRepo;

    @Autowired
    ReferenceRepo referenceRepo;*/

    //Below will be map of pathing for web app
    @GetMapping("/")
    public String showIndex() {return "index";}

    @GetMapping("/addPerson")
    public String addPerson(Model model){

        Person person = new Person();

        model.addAttribute("person", person);

        return "personform";
    }

    @PostMapping("/addPerson")
    public String addPerson(@Valid Person person, BindingResult result){
        if(result.hasErrors()){
            return "personform";
        }
        personRepo.save(person);

        return "redirect:/";
    }

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

    @GetMapping("/resume")
    public String showResume() {return "resume";}

    @GetMapping("/coverLetter")
    public String showCoverLetter() {return "coverLetter";}

    @RequestMapping("/update/{id}")
    public String updateResume(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepo.findOne(id));
        return "resumeForm";
    }







}
