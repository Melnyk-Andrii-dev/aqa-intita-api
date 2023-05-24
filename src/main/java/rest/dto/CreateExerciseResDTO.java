package rest.dto;

import groovy.transform.builder.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateExerciseResDTO {

    private Exercise exercise;

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
    public static class Part {
        private int id;
        private String title;
        private int order;
        private int lesson_id;
        private Object video;
        private Date created_at;
        private Date updated_at;
        private Lesson lesson;
    }

    @Data
    @Builder
    public static class Exercise {
        private String description;
        private int part_id;
        private Date updated_at;
        private Date created_at;
        private int id;
        private int type;
        private Part part;
    }

}
