# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다. 
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 예시
```text
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
pobi,crong,honux
시도할 회수는 몇회인가요?
5

실행 결과
pobi : -
crong : -
honux : -

pobi : --
crong : -
honux : --

pobi : ---
crong : --
honux : ---

pobi : ----
crong : ---
honux : ----

pobi : -----
crong : ----
honux : -----

pobi : -----
crong : ----
honux : -----

pobi, honux가 최종 우승했습니다.
```

## Todo

- [x] 이름을 가진 자동차를 생성할 수 있다.
  - [x] 이름은 5자 이하만 가능하다.
  - [x] 사용자로부터 자동차 이름을 입력받아야 한다.
  - [x] 이름은 쉼표(,)를 기준으로 구분한다.
- [x] 사용자로부터 시도할 횟수를 입력받아야 한다.
- [x] 자동차는 전진 혹은 정지할 수 있다.
  - [x] 0에서 9 사이의 랜덤 숫자를 생성한다.
  - [x] 생성한 숫자가 4 이상일 경우 전진한다.
  - [x] 생성한 숫자가 3 이하일 경우 정지한다.
- [x] 자동차의 상태를 출력한다.
- [x] 누가 우승했는지를 결정하고 출력한다.
  - [x] 우승자는 1명 이상일 수 있다.


# 문자열 계산기
## 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
  - (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
  - 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 
  - 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 기능 요구사항 분리 및 힌트
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
- 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
- 숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
- 구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
- “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
- 음수를 전달하는 경우 RuntimeException 예외 처리를 한다. (예 : "-1,2,3")