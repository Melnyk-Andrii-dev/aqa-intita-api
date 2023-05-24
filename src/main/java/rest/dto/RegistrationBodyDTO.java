package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationBodyDTO {
    private RegistrationBodyDTO registrationBody;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class RegistrationBody{
        private String email;
        private String password;
    }

}
