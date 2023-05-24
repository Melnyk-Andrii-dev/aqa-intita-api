package rest.dto;

import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCourseReqDTO {
    public Body body;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {
        private int course_ID;
        private Object course_img;
        private String title;
    }
}
