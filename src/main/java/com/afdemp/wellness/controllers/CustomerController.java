
package com.afdemp.wellness.controllers;

import com.afdemp.wellness.entities.Customer;
import com.afdemp.wellness.entities.Purchase;
import com.afdemp.wellness.service.AppService;
import com.afdemp.wellness.service.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.afdemp.wellness.dao.IPurchaseDao;


@Controller
@RequestMapping("/user")
@SessionAttributes("roles")
public class CustomerController {
    
    @Autowired
    AppService appService;

    @Autowired
    CustomerService customerService;
    
    @Autowired
    IPurchaseDao odao;
    
    @RequestMapping(value = {"/customers"}, method = RequestMethod.GET)
    public String getProfile(ModelMap model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
    @RequestMapping(value = {"/profile"}, method = RequestMethod.GET)
    public String getProfile2(ModelMap model) {
        model.addAttribute("loggedinuser", appService.getPrincipal());
        model.addAttribute("customer", customerService.getCustomerBySsoId(appService.getPrincipal()));
        model.addAttribute("pagetitle", "My profile");
        model.addAttribute("adminForAdmin", false);
        return "customer_profile";
    }

    @RequestMapping(value = {"/profile/update"}, method = RequestMethod.GET)
    public String updateProfile(ModelMap model) {
        model.addAttribute("customer", customerService.getCustomerBySsoId(appService.getPrincipal()));
        model.addAttribute("action","/Wellness/user/profile/save");
        model.addAttribute("cancel","../Wellness/user/profile");
        model.addAttribute("loggedinuser", appService.getPrincipal());
        model.addAttribute("pagetitle", "Edit profile");
        return "updateprofile";
    }


    
}
