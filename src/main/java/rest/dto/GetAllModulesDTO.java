package rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
public class GetAllModulesDTO {
    private ArrayList<Row> rows;
    private int count;

    @Data
    @Builder
    public static class CourseModule {
        private int id;
        private int id_course;
        private int id_module;
        private int order;
        private Object mandatory_modules;
        private Object price_in_course;
        private Date created_at;
        private Date updated_at;
    }

    @Data
    @Builder
    public static class Lesson {
        private int id;
        private String title;
        private String slug;
        private int order;
        private int module_id;
        private int is_free;
        private int status;
        private Date created_at;
        private Date updated_at;
    }

    @Data
    @Builder
    public static class Row {
        private int module_ID;
        private String alias;
        private String language;
        private String module_price;
        private Object for_whom;
        private Object what_you_learn;
        private Object what_you_get;
        private String module_img;
        private int level;
        private int hours_in_day;
        private int days_in_week;
        private Object module_number;
        private int cancelled;
        private int status_online;
        private Object id_module_revision;
        private int id_organization;
        private Object understand_rating;
        private Object interesting_rating;
        private Object accessibility_rating;
        private int status_offline;
        private Date created_at;
        private Date updated_at;
        private String title;
        private Object rating;
        private ArrayList<CourseModule> course_modules;
        private ArrayList<Lesson> lessons;
    }
}
