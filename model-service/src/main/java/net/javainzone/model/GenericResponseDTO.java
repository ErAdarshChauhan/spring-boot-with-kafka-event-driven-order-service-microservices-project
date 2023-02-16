package net.javainzone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponseDTO<T> {

    private String status;
    private String errors;
    private T result;

    public static <T> GenericResponseDTO<T> ok(T result) {
        GenericResponseDTO<T> genericResponseDTO = new GenericResponseDTO<>();
        genericResponseDTO.setStatus("SUCCESS");
        genericResponseDTO.setResult(result);
        return genericResponseDTO;
    }
}
