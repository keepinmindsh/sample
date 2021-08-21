package com.lines.basic.webserver04.domain.user.controller;

import com.lines.basic.webserver04.core.code.StatusCode;
import com.lines.basic.webserver04.core.mapper.Mapping;
import com.lines.basic.webserver04.domain.user.model.User;
import com.lines.basic.webserver04.domain.user.model.UserDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserMapping implements Mapping {

    private final String parameter;

    @Override
    public Object map() {

        UserDto.Result.ResultBuilder resultBuilder = null;

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

            resultBuilder.result(userBuilder.build());
            resultBuilder.statusCode(StatusCode.SUCCESS);
        }catch (Exception exception){
            resultBuilder.result(exception.getMessage());
            resultBuilder.statusCode(StatusCode.ERROR);
        }

        return resultBuilder.build();
    }
}
