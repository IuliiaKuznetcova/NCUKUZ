package API.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidUserCredentials {
    private String full_name;
    private String email;
    private String password;
    private boolean generate_magic_link;
}
