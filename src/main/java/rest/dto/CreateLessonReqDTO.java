package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateLessonReqDTO {
    Body body;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {
        public Lesson lesson;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Lesson {
            public String title;
            public String slug;
            public String module_id;
            public String is_free;
            public String status;
        }
    }
}
