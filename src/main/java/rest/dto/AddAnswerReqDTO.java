package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AddAnswerReqDTO {

    @Data
    @Builder
    @AllArgsConstructor
    public static class Body {
        public AnswerCase answerCase;

        @Data
        @Builder
        @AllArgsConstructor
        public static class AnswerCase {
            public int quiz_id;
            public boolean is_right;
            public String title;
            public boolean isEditor;
        }
    }
}
