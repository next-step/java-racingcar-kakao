# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# 레이싱 게임

## 기능 목록

- [x] 자동차의 이름은 5글자 이하
- [x] 자동차는 전진 가능
- [x] 자동차의 상태를 파악

# 문자열 덧셈 계산기

## 기능 목록

- [x] Numbers는 일급 콜렉션으로 정수 값들을 보유
- [x] Adder는 Numbers를 입력받아 총합을 계산
- [x] Parser는 입력 값을 적절히 파싱
    - [x] Default인지 Custom인지 판별
    - [x] 파싱 후 Numbers를 반환
    - [x] 입력 값의 Blank 여부를 파악하여 예외 처리
    - [x] 파싱 후 정수 값으로의 변환에서의 예외 처리
- [x] Calculator는 sum 로직을 제공
    - [x] 입력 값의 Blank 여부를 파악하여 예외 처리
    - [x] 입력 값이 정수가 아닌 경우와 음수인 경우 예외 처리
