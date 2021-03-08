package com.lines.sql.messages;

import com.lines.sql.model.UserDTO;
import com.lines.sql.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@MapperScan(basePackages="com.lines.sql.dao")//탐색할 패키시 설정
public class User {

    private final UserDao userDAO;//UserDAO bean을 자동으로 주입

    @RequestMapping("/users")
    public List<UserDTO> users(@RequestParam(value="country", defaultValue = "")String country) throws Exception { //query String으로 county를 받도록 설정
        final UserDTO param = new UserDTO(0, null, country);//전달 받은 country를 받은 UserDTO 객체 생성 이 객체는 MyBatis에 파라미터로 전달
        final List<UserDTO> userList = userDAO.selectUsers(param);// 22번 째 줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
        return userList;
    }
}
