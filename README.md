
# [ 일정 관리 앱 (Schedule Manager) ]
<br>

## - 개요 
이 프로젝트는 사용자들이 할 일을 기록하고 관리할 수 있는 간단한 일정 관리
어플리케이션 입니다.

## - 기술 스택
- Java
- Spring Boot
- JDBC
- MySQL

## - 기능
- 일정 생성
- 일정 조회
- 일정 수정
- 일정 삭제

## - 프로젝트 구조
![diagram.png](diagram.png)
<br><br><br>
## - 사용된 메서드

###  - ScheduleController

- **createSchedule(ScheduleRequestDto requestDto)**: 새로운 일정을 생성합니다.
- **getAllSchedules()**: 모든 일정을 조회합니다.
- **getScheduleById(Long id)**: 특정 ID에 해당하는 일정을 조회합니다.
- **updateSchedule(Long id, ScheduleRequestDto requestDto, String password)**: 특정 ID에 해당하는 일정을 수정합니다.
- **deleteSchedule(Long id, String password)**: 특정 ID에 해당하는 일정을 삭제합니다.

### - ScheduleService
- **saveSchedule(Schedule schedule)**: 새 일정을 데이터베이스에 저장합니다.
- **findAllSchedules()**: 모든 일정을 데이터베이스에서 조회합니다.
- **findScheduleById(Long id)**: 특정 ID에 해당하는 일정을 데이터베이스에서 조회합니다.
- **updateSchedule(Long id,ScheduleRequestDto requestDto)**: 특정 ID에 해당하는 일정을 데이터베이스에서 수정합니다.
- **deleteSchedule(Long id)**: 특정 ID에 해당하는 일정을 데이터베이스에서 삭제합니다.

### - ScheduleRepository
- **save(Schedule schedule)**: 새 일정을 데이터베이스에 저장합니다.
- **findAll()**: 모든 일정을 데이터베이스에서 조회합니다.
- **findById(Long id)**: 특정 ID에 해당하는 일정을 데이터베이스에서 조회합니다.
- **deleteById(Long id)**: 특정 ID에 해당하는 일정을 데이터베이스에서 삭제합니다.

<br>

## - 데이터베이스 설정
- **application.properties**: 데이터베이스 연결을 위한 설정을 포함하고 있습니다. 아래와 같은 설정을 포함해야 합니다.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/scheduler
spring.datasource.username=root
spring.datasource.password=56781234
spring.jpa.hibernate.ddl-auto=update
```

## 실행 방법
1. 프로젝트를 클론합니다.
2. 'application.properties' 파일에서 데이터베이스 연결 정보를 설정합니다.
3. MySQL 서버를 실행합니다.
4. Spring Boot 애플리케이션을 실행합니다.
5. Postman을 사용하여 API를 테스트합니다.

## - API 명세
- POST /schedules: 새 일정을 생성합니다.
- GET /schedules: 모든 일정을 조회합니다.
- GET /schedules/{id}: 특정 일정을 조회합니다.
- PUT /schedules/{id}: 특정 일정을 수정합니다.
- DELETE /schedules/{id}: 특정 일정을 삭제합니다.
















