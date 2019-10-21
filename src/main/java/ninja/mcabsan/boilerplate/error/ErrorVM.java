package ninja.mcabsan.boilerplate.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorVM implements Serializable {

    private static final long serialVersionUID = -634934861625906956L;

    private String message;
    private String code;
    private List<String> params;
}
