package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CreateTaskResDTO {
    private String status;
    private Task task;

    @AllArgsConstructor
    @Data
    public class TypeModel {
        private int id;
        private String title_ua;
        private String title_ru;
        private String title_en;
        private int order;
        private Object created_at;
        private Object updated_at;
        private String title;
    }

    @AllArgsConstructor
    @Data
    public class Organization {
        private int id;
        private String name;
        private Object email;
        private Object phone;
        private Object url;
        private double coefficient_offline;
        private double coefficient_online;
        private double coefficient_module_in_course;
        private Object facebook;
        private Object linkedin;
        private Object twitter;
        private String logo;
        private Object created_at;
        private Date updated_at;
        private int status;
        private Object description;
        private int services_count;
    }

    @AllArgsConstructor
    @Data
    public class Task {
        private String name;
        private String body;
        private int type;
        private int priority;
        private Object expected_time;
        private String startTask;
        private String endTask;
        private int created_by;
        private int organization_id;
        private Date updated_at;
        private Date created_at;
        private int id;
        private String typeName;
        private String organizationName;
        private TypeModel type_model;
        private Organization organization;
    }
}
