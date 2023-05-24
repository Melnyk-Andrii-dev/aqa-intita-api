package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class GetTaskResDTO {

    private Task task;

    @AllArgsConstructor
    @Data
    @Builder
    public static class Task{
        private int id;
        private String name;
        private String body;
        private int type;
        private int priority;
        private String startTask;
    }

}
