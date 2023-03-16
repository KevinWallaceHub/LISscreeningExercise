package com.wallace.demo.DAO;

import com.wallace.demo.Model.FormData;
import org.springframework.jdbc.InvalidResultSetAccessException;

import java.util.List;

public interface FormDataDAO {

    List<FormData> findAllData();

    void addFormData(FormData entry);

}
