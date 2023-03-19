package com.lsi.demoProject.Controller;


import com.lsi.demoProject.DAO.FormDataDAO;
import com.lsi.demoProject.Model.FormData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FormDataController {

    private final FormDataDAO formDataDAO;

    public FormDataController(FormDataDAO formDataDAO){
        this.formDataDAO = formDataDAO;
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public List<FormData> showAllFormData(){
        return formDataDAO.findAllData();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public FormData addToFormData(@RequestBody FormData formData) {
        return formDataDAO.addFormData(formData);
    }
}
