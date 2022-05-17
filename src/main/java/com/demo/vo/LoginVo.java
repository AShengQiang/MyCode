package com.demo.vo;

import com.demo.validator.IsMobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {
  @NotNull
  @IsMobile
  String mobile;
  @NotNull
  @Length(min = 32)
  String password;
}
