package com.lines.credit.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleForDownload {

    /*

    그 전에crontab 주기설정 방법부터 알아보자.

        *           *　　　　　　*　　　　　　*　　　　　　*　　　　　　*
        초(0-59)   분(0-59)　　시간(0-23)　　일(1-31)　　월(1-12)　　요일(0-7)
        각 별 위치에 따라 주기를 다르게 설정 할 수 있다.
        순서대로 초-분-시간-일-월-요일 순이다. 그리고 괄호 안의 숫자 범위 내로 별 대신 입력 할 수도 있다.
        요일에서 0과 7은 일요일이며, 1부터 월요일이고 6이 토요일이다.


    https://sabarada.tistory.com/113

     */

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }

    /*

    // 1초에 한번 실행된다.
    @Scheduled(fixedDelay = 1000)

    @Scheduled(fixedRate = 1000)

    위 차이를 쉽게 얘기하면 fixedDelay 는 이전 수행이 종료된 시점부터 delay 후에 재 호출되고 fixedRate 는 이전 수행이 시작된 시점부터 delay 후에 재 호출된다.
    그러므로 fixedRate 로 지정 시 동시에 여러개가 돌 가능성이 존재한다.

     */
}
