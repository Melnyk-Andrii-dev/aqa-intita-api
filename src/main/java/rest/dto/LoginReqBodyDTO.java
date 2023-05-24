package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginReqBodyDTO {
    private LoginBody loginBody;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class LoginBody{
        private String email;
        private String password;
    }

}
