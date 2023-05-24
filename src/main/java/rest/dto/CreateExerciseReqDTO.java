package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class CreateExerciseReqDTO {

    @Builder
    @Data
    @AllArgsConstructor
    public static class Body {
        public Exercise exercise;
        public String type;

        @Builder
        @Data
        @AllArgsConstructor
        public static class Exercise {
            private String description;
            private boolean isEditor;
            private int part_id;
        }
    }
}
