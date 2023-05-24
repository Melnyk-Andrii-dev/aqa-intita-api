package rest.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
public class CreatePartResDTO {
    public Part part;

    @Data
    @Builder
    public static class Part {
        private int id;
        private String title;
        private int order;
        private int lesson_id;
        private Object video;
        private Date created_at;
        private Date updated_at;
        private ArrayList<Object> part_blocks;
        private ArrayList<Object> part_quizzes;
        private ArrayList<Object> part_open_response_exercises;
        private ArrayList<Object> part_interpreter_exercises;
        private ArrayList<Object> part_gap_exercises;
    }
}
