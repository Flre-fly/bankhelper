package back.helper2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {
    private String response_type;
    private String client_id;
    private String redirect_uri;
    private String scope;
    private String state;
    private String auth_type;
}
