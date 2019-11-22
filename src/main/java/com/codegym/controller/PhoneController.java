package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import com.codegym.service.CategoryService;
import com.codegym.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/phone")
    public ModelAndView shoWListPhone(@SortDefault Optional<String> s, @PageableDefault(size = 10) Pageable pageable) {
        Page<Phone> phones;

        if (s.isPresent()) {
            phones = phoneService.findAllByName(s.get(), pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    @GetMapping("/create-phone")
    public ModelAndView showCreatePhone() {
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @PostMapping("/create-phone")
    public ModelAndView savePhone(@ModelAttribute Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("phone/create");
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("message", "Create phone successfully");
        return modelAndView;
    }

    @GetMapping("/edit-phone/{id}")
    public ModelAndView showEditPhone(@PathVariable int id) {
        Phone phone = phoneService.findById(id);
        ModelAndView modelAndView = null;

        if (phone != null) {
            modelAndView = new ModelAndView("phone/edit");
            modelAndView.addObject("phone", phone);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-phone")
    public ModelAndView editPhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("phone/edit");
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("message", "Edit phone successfully");
        return modelAndView;
    }

    @GetMapping("/delete-phone/{id}")
    public ModelAndView delete(@PathVariable("id") int id) {
        phoneService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/phone");
        return modelAndView;
    }
}
