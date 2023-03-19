package com.lsi.demoProject.DAO;


import com.lsi.demoProject.Model.FormData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class jdbcFormDataDAO implements FormDataDAO {

    private final JdbcTemplate jdbcTemplate;

    public jdbcFormDataDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public  List<FormData> findAllData() {
        List<FormData> allFormData = new ArrayList<>();

        String sql = "SELECT name, age, title, hometown FROM formdata";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        System.out.println(results);
        while(results.next()){
            allFormData.add(mapRowToForm(results));
        }
        return allFormData;
    }

    @Override
    public FormData addFormData(FormData entry) {
        String sql = "INSERT INTO formdata (name, age, title, hometown) " +
                "VAlUES (?, ?, ?, ?)";
        jdbcTemplate.queryForObject(sql, String.class, entry.getName(),entry.getAge(), entry.getTitle(), entry.getHometown());

        return entry;
    }

    private FormData mapRowToForm(SqlRowSet row) {
        FormData formData = new FormData();
        try{
            formData.setName(row.getString("name"));
            formData.setAge(row.getInt("age"));
            formData.setTitle(row.getString("title"));
            formData.setHometown(row.getString("hometown"));
            return formData;
        }catch (Exception e){
            System.out.println( "DataAccessException");
        }
        return formData;
    }
}
