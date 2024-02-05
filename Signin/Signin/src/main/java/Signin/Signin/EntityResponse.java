package Signin.Signin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityResponse<T> {
    private String message;
    private Integer statusCode;
     private T entity;
}
