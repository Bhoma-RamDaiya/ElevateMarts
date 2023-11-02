package com.example.elevatemart.dto.response;

import com.example.elevatemart.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseDto {

    String name;

    String emailId;

    String mobNo;

    Gender gender;
}
