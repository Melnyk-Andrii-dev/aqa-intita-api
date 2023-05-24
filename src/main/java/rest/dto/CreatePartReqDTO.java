package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePartReqDTO {

    Body body;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {
        public Part part;

        @Data
        @Builder
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Part {
            private String title;
            private int lesson_id;
        }
    }

}
