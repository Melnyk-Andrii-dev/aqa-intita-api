package rest.dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
public class CourseInfoDTO {

    public Service service;

    @AllArgsConstructor
    @Data
    public class Organization{
        public int id;
        public String name;
        public double coefficient_offline;
        public double coefficient_online;
        public double coefficient_module_in_course;
        public int services_count;
    }
    @AllArgsConstructor
    @Data
    public class CourseLevel{
        public int id;
        public String title_ua;
        public String title_ru;
        public String title_en;
        public Object created_at;
        public Object updated_at;
        public String title;
    }
    @AllArgsConstructor
    @Data
    public class CourseModule{
        public int id;
        public int id_course;
        public int id_module;
        public int order;
        public int mandatory_modules;
        public Object price_in_course;
        public Object created_at;
        public Object updated_at;
    }
    @AllArgsConstructor
    @Data
    public class Pivot{
        public int id_course;
        public int id_module;
    }
    @AllArgsConstructor
    @Data
    public class ActiveModule{
        public int module_ID;
        public int days_in_week;
        public int hours_in_day;
        public String module_price;
        public int lessons_count;
        public Object rating;
        public Pivot pivot;
    }
    @AllArgsConstructor
    @Data
    public class SchemaOnline{
        public int id;
        public int payCount;
        public String discount;
        public String name;
        public String loanValue;
        public int contract;
        public int duration;
        public Object start_date;
    }
    @AllArgsConstructor
    @Data
    public class PriceOnline{
        public int basePrice;
        public double actualPrice;
    }
    @AllArgsConstructor
    @Data
    public class SchemaOffline{
        public int id;
        public int payCount;
        public String discount;
        public String name;
        public String loanValue;
        public int contract;
        public int duration;
        public Object start_date;
    }
    @AllArgsConstructor
    @Data
    public class PriceOffline{
        public int basePrice;
        public double actualPrice;
    }
    @AllArgsConstructor
    @Data
    public class Service{
        public int course_ID;
        public String alias;
        public String language;
        public int level;
        public String start;
        public int status_online;
        public String course_img;
        public int rating;
        public int cancelled;
        public Object course_number;
        public int id_organization;
        public int status_offline;
        public Object course_price;
        public int modules_count;
        public int status;
        public Object created_at;
        public Date updated_at;
        public Object internship;
        public String title;
        public String for_whom;
        public String what_you_learn;
        public String what_you_get;
        public Organization organization;
        public CourseLevel course_level;
        public ArrayList<CourseModule> course_modules;
        public ArrayList<ActiveModule> active_modules;
        public int lessons_count;
        public String lecture_duration;
        public SchemaOnline schema_online;
        public PriceOnline price_online;
        public SchemaOffline schema_offline;
        public PriceOffline price_offline;
        public String payment_status;
        public Object user_agreement_request;
    }

}
