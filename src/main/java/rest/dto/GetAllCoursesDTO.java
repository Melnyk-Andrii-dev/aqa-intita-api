package rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
public class GetAllCoursesDTO {
    private ArrayList<Row> rows;
    private int count;

    @Data
    @Builder
    public static class CourseModule {
        private int id;
        private int id_course;
        private int id_module;
        private int order;
        private int mandatory_modules;
        private Object price_in_course;
        private Date created_at;
        private Date updated_at;
    }

    @Data
    @Builder
    public static class Pivot {
        private int id_course;
        private int id_module;
    }

    @Data
    @Builder
    public static class Module {
        private int module_ID;
        private String alias;
        private String language;
        private String module_price;
        private String for_whom;
        private String what_you_learn;
        private String what_you_get;
        private String module_img;
        private int level;
        private int hours_in_day;
        private int days_in_week;
        private int module_number;
        private int cancelled;
        private int status_online;
        private int id_module_revision;
        private int id_organization;
        private Object understand_rating;
        private Object interesting_rating;
        private Object accessibility_rating;
        private int status_offline;
        private Date created_at;
        private Date updated_at;
        private String title;
        private Object rating;
        private Pivot pivot;
    }

    @Data
    @Builder
    public static class Row {
        private int course_ID;
        private String alias;
        private String language;
        private int level;
        private String start;
        private int status_online;
        private String course_img;
        private Object rating;
        private int cancelled;
        private long course_number;
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
        private ArrayList<CourseModule> course_modules;
        private ArrayList<Module> modules;
    }
}
