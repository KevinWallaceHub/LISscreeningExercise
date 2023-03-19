package com.lsi.demoProject.DAO;

import java.util.List;
import com.lsi.demoProject.Model.FormData;

public interface FormDataDAO {

    List<FormData> findAllData();

    FormData addFormData(FormData entry);
}
