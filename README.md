# massege-board_ver.interface

## Use Case
![usecase](https://user-images.githubusercontent.com/108788078/194076204-87d29692-28c1-4dbb-90bf-86724b320c06.jpg)

## API
|기능|Method|URL|Request|Response|
|----|------|---|--------|-------|
|게시물조회|GET|/api/post|-|[{"createdAt": "2022-07-25T12:43:01.226062”,<br>"modifiedAt": "2022-07-25T12:43:01.226062”,<br>"id": 1,<br>"title":"title2",<br>"content": "content2",<br>"author": "author2"},<br>{"createdAt": "2022-07-25T12:43:01.226062”,<br>"modifiedAt": "2022-07-25T12:43:01.226062”,<br>"id": 2,<br>"title": "title",<br>"content": "content",<br>"author": "author"}]|
|게시물 1개 조회|GET|/api/post/{id}|-|{"createdAt": "2022-07-25T12:43:01.226062”,<br>"modifiedAt": "2022-07-25T12:43:01.226062”,<br>"id": 1,<br>"title":"title2",<br>"content": "content2",<br>"author": "author2"}|
|게시물 작성|POST|/api/post|{"title" : "title",<br>"content" : "content",<br>"author" : "author",<br>"password" : "password"}|{"createdAt": "2022-07-25T12:43:01.226062”,<br>"modifiedAt": "2022-07-25T12:43:01.226062”,<br>"id": 1,<br>"title":"title",<br>"content": "content",<br>"author": "author"}|
|게시물 비밀번호 확인|POST|/api/post/{id}|{"password" : "password"}|true|
|게시물 수정|PUT|/api/post/{id}|{"title": "title2",<br>"content": "content2",<br>"author": "author2",<br>"password" : "password2"}|{"createdAt": "2022-07-25T12:43:01.226062”,<br>"modifiedAt": "2022-07-25T12:43:01.226062”,<br>"id": 2,<br>"title": "title2",<br>"content": "content2",<br>"author": "author2"}|
|게시물 삭제|DELETE|/api/post/{id}|-|true|


## 퀴즈
1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)
> param에 id를 담아 request
2. 어떤 상황에 어떤 방식의 request를 써야하나요?
> 생성-POST, 조회-GET, 수정-PUT, 삭제-DELETE
3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
> API를 올려둠
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)
> 적용함
5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!
> controller,service,repository
6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!
> 가이드라인에는 타입과 설명, 값의 범위등이 다 들어가있다.
