package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeleteTaskBodyDTO {
    private DeleteTaskBody deleteTaskBody;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class DeleteTaskBody {
        private int id;
    }

}
