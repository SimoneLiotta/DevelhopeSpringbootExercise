package co.develhope.esercizio7.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
    private String authCode;
    private String devName;
}
