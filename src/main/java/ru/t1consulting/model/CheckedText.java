package ru.t1consulting.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CheckedText {

    @NotNull(message = "поле \"text\" должно быть заполнено")
    @Size(max = 1000, message = "длина поля \"text\" не должна привышать 1000 символов")
    private final String text;
}
