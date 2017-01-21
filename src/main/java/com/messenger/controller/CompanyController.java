package com.messenger.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.messenger.model.Company;



@Controller
public class CompanyController {
	private static DataStore dataStore = new DataStore();

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
    	Company userForm = new Company();
        return new ModelAndView("company", "companyForm", userForm);
    }

    @RequestMapping(value = "/get_ceos_list",
                    method = RequestMethod.GET,
                    headers="Accept=*/*")
    public @ResponseBody List<String> getCountryList(@RequestParam("term") String query) {
        List<String> countryList = dataStore.getCeosList(query);
        return countryList;
    }

    @RequestMapping(value = "/get_co_list",
                    method = RequestMethod.GET,
                    headers="Accept=*/*")
    public @ResponseBody List<String> getCoList(@RequestParam("term") String query) {
        List<String> countryList = dataStore.getCeosList(query);
        return countryList;
    }
}