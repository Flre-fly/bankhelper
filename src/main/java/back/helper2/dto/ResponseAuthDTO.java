package back.helper2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAuthDTO {
    private String scope;
    private String code;
    private String client_info;
    private String state;
}
