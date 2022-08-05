package com.test.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class MyController {
    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

//        @RequestMapping("/askDetails")
//    public String askEmployeeDetails() {
//        return "ask-details";
//    }
    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
       model.addAttribute("employee", new Employee());
        return "ask-details";
    }


    //    @RequestMapping("/showDetails")
//    public String showDetails(HttpServletRequest request, Model model){
//
//        String empName = request.getParameter("employeeName");
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute",empName);
//
//        return "showDetails";
//    }
    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee employee,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ask-details";
        } else {
            return "showDetails";
        }


    }
//    @RequestMapping("/showDetails")
//    public String showEmpDetails(@RequestParam("employeeName") String empName, Model model) {
//
//        empName = "Mr. " + empName;
//        model.addAttribute("nameAttribute", empName);
//
//        return "showDetails";
//    }
}
