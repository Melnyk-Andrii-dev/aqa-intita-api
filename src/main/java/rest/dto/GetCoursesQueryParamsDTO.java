package rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class GetCoursesQueryParamsDTO {
    private int count;
    private int page;
    private ArrayList<Sorting> sorting;
    private Filter filter;

    @Data
    @Builder
    public static class Sorting{
        private String field;
        private String type;
    }

    @Data
    @Builder
    public static class Filter{
        private String alias;
        private String language;
        private String title;
        private String status_online;
        private String status_offline;
        private String level;
        private String cancelled;
        private String course_ID;
    }
}
