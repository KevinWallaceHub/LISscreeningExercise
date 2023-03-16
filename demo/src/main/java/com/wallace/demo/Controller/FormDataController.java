package com.wallace.demo.Controller;

import com.wallace.demo.DAO.FormDataDAO;
import com.wallace.demo.Model.FormData;
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
    public void addToFormData(FormData formData){
        formDataDAO.addFormData(formData);
    }
}
