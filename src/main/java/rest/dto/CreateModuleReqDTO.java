package rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateModuleReqDTO {
    Body body;

    @Data
    @Builder
    public static class Body {
        private String language;
        private String alias;
        private int level;
        private String status_online;
        private String status_offline;
        private String title;
        private Object module_img;
        private int module_price;
        private int hours_in_day;
        private int days_in_week;
    }
}
