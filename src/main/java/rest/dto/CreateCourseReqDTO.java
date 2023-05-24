package rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateCourseReqDTO {
    CreateCourseBody createCourseBody;

    @Data
    @Builder
    public static class CreateCourseBody {
        private String language;
        private String alias;
        private String course_number;
        private int level;
        private String start;
        private String status_online;
        private String status_offline;
        private String title;
        private String for_whom;
        private String what_you_learn;
        private String what_you_get;
        private String internship;
        private Object course_img;
    }
}
