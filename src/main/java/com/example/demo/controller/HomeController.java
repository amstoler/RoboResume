package com.example.demo.controller;

import com.example.demo.model.Education;
import com.example.demo.model.Experience;
import com.example.demo.model.Person;
import com.example.demo.model.Skill;
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


    //Below will be map of pathing for web app
    @GetMapping("/")
    public String showIndex() {return "index";}

    @GetMapping("/addPerson")
    public String personForm(Model model){

       Person person = new Person();

       model.addAttribute("person", person);

        return "personForm";
    }

    @PostMapping("/addPerson")
    public String addPerson(@Valid @ModelAttribute("person") Person person,Model model, BindingResult result){
        if(result.hasErrors()){
            return "personForm";
        }
        personRepo.save(person);
        model.addAttribute("personlist",personRepo.findAll());

        return "index";
    }

    @GetMapping("/addEducation")
    public String educationForm(Model model){

        Education education = new Education();

        model.addAttribute("education", education);

        return "educationForm";
    }

    @PostMapping("/addEducation")
    public String addEducation(@Valid @ModelAttribute("education") Education education,Model model, BindingResult result){
        if(result.hasErrors()){
            return "educationForm";
        }
        educationRepo.save(education);
        model.addAttribute("educationlist",personRepo.findAll());

        return "index";
    }

  /*  @GetMapping("/addExperience")
    public String experienceForm(Model model){

        Experience experience = new Experience();

        model.addAttribute("experience", experience);

        return "experienceForm";
    }

    @PostMapping("/addExperience")
    public String addExperience(@Valid @ModelAttribute("experience") Experience experience,Model model, BindingResult result){
        if(result.hasErrors()){
            return "experienceForm";
        }
        experienceRepo.save(experience);
        model.addAttribute("experiencelist",personRepo.findAll());

        return "completedResume";
    }

    @GetMapping("/addSkill")
    public String skillForm(Model model){

        Skill skill = new Skill();

        model.addAttribute("skill", skill);

        return "skillsForm.html";
    }

    @PostMapping("/addSkill")
    public String addSkill(@Valid @ModelAttribute("skill") Skill skill,Model model, BindingResult result) {
        if (result.hasErrors()) {
            return "skillsForm";
        }
        skillRepo.save(skill);
        model.addAttribute("skilllist", personRepo.findAll());

        return "completedResume";
    }*/


//    When compolete with resume create getmsp class for all models from repo and print our theirs list
//    kinda like this

@GetMapping("/completedResume")
    public String completeresume(Model model){
    model.addAttribute("persons",personRepo.findAll());
    model.addAttribute("education",educationRepo.findAll());

return "completedResume";
}


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

    /*@RequestMapping("/completedResume")
    public String showResume(Model model) {
        model.addAttribute("persons", personRepo.findAll());
        return "completedResume";

    }*/

    /*@RequestMapping("/bookList")
    public String listBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "bookList";
    }*/

    @GetMapping("/coverLetter")
    public String showCoverLetter() {return "coverLetter";}

    @RequestMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model){
        model.addAttribute("person", personRepo.findOne(id));
        return "personForm";
    }

    @RequestMapping("/updateEducation/{id}")
    public String updateEducation(@PathVariable("id") long id, Model model){
        model.addAttribute("education", educationRepo.findOne(id));
        return "educationForm";
    }







}
