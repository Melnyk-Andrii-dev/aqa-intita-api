package rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddTextReqDTO {

    Body body;

    @Data
    @Builder
    public static class Body {
        public Block block;

        @Data
        @Builder
        public static class Block {
            private String html;
            private int type;
            private int part_id;
            private boolean isEditor;
            private long tempUid;
        }
    }
}
