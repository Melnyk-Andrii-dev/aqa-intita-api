package rest.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
public class SearchCoursesAsClientDTO {

    private ArrayList<Service> services;
    private int total;

    @Data
    public static class CourseLevel {
        private int id;
        private String title_ua;
        private String title_ru;
        private String title_en;
        private Object created_at;
        private Object updated_at;
        private String title;
    }

    @Data
    public static class Organization {
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

    @Data
    public static class Translates {
        private String title;
        private String currencySymbol;
        private String discount;
        private String payment;
        private String month;
    }

    @Data
    public static class SchemaOnline {
        private int id;
        private int payCount;
        private String discount;
        private String name;
        private String loanValue;
        private int contract;
        private int duration;
        private Object start_date;
        private String loan;
        private int paymentsCount;
        private int type;
        private Translates translates;
        private String fullPrice;
        private String price;
        private int approxMonthPayment;
        private String educForm;
        private int schemeId;
        private int inCourse;
    }

    @Data
    public static class PriceOnline {
        private int basePrice;
        private int actualPrice;
    }

    @Data
    public static class SchemaOffline {
        private int id;
        private int payCount;
        private String discount;
        private String name;
        private String loanValue;
        private int contract;
        private int duration;
        private Object start_date;
        private String loan;
        private int paymentsCount;
        private int type;
        private Translates translates;
        private String fullPrice;
        private String price;
        private int approxMonthPayment;
        private String educForm;
        private int schemeId;
        private int inCourse;
    }

    @Data
    public static class PriceOffline {
        private int basePrice;
        private int actualPrice;
    }

    @Data
    public static class ModuleLevel {
        private int id;
        private String title_ua;
        private String title_ru;
        private String title_en;
        private Object created_at;
        private Object updated_at;
        private String title;
    }

    @Data
    public static class Service {
        private int course_ID;
        private String alias;
        private String language;
        private int level;
        private String start;
        private int status_online;
        private String course_img;
        private Object rating;
        private int cancelled;
        private Object course_number;
        private int id_organization;
        private int status_offline;
        private Object course_price;
        private Object modules_count;
        private int status;
        private Date created_at;
        private Date updated_at;
        private int internship;
        private String title;
        private String for_whom;
        private String what_you_learn;
        private String what_you_get;
        private CourseLevel course_level;
        private Organization organization;
        private ArrayList<Object> modules;
        private SchemaOnline schema_online;
        private PriceOnline price_online;
        private SchemaOffline schema_offline;
        private PriceOffline price_offline;
        private double offline_coefficient;
        private double online_coefficient;
        private int module_ID;
        private String module_price;
        private String module_img;
        private int hours_in_day;
        private int days_in_week;
        private Object module_number;
        private Object id_module_revision;
        private Object understand_rating;
        private Object interesting_rating;
        private Object accessibility_rating;
        private ModuleLevel module_level;
        private ArrayList<Object> lectures;
    }

}
