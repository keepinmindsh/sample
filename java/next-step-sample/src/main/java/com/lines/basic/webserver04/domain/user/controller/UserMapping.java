package com.lines.basic.webserver04.domain.user.controller;

import com.lines.basic.webserver04.core.code.StatusCode;
import com.lines.basic.webserver04.core.mapper.Mapping;
import com.lines.basic.webserver04.domain.user.model.User;
import com.lines.basic.webserver04.domain.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class UserMapping implements Mapping {

    private final String parameter;

    @Override
    public Object map() {

        UserDto.Result resultDto = null;

        try{
            String[] paramBySplit = parameter.split("&");

            User.UserBuilder userBuilder = User.builder();

            for (int i = 0; i < paramBySplit.length; i++) {

                String[] parameters = paramBySplit[i].split("=");

                for (int j = 0; j < parameters.length; j++) {
                    switch (parameters[0]){
                        case "name" :
                            userBuilder.name(parameters[1]);
                            break;
                        case "email" :
                            userBuilder.email(parameters[1]);
                            break;
                        case "password" :
                            userBuilder.password(parameters[1]);
                            break;
                        case "userId" :
                            userBuilder.userId(parameters[1]);
                            break;
                    }
                }
            }

            resultDto = UserDto.Result.builder()
                    .result(userBuilder.build())
                    .statusCode(StatusCode.SUCCESS).build();
        }catch (Exception exception){
            log.error("Error : " + exception.getMessage());

            resultDto = UserDto.Result.builder()
                    .result(exception.getMessage())
                    .statusCode(StatusCode.ERROR).build();
        }

        return resultDto;
    }
}
