## Synchronization (동기화)

동기화(Synchronization)는 여러 실행 흐름(프로세스/스레드)이 동시에 공유 자원에 접근할 때, 실행 순서를 제어해 안전하게 동작하도록 만드는 기법이다.

### 왜 동기화를 사용할까?

- 데이터의 일관성(Consistency)을 유지하기 위해
- 경쟁 상태(Race Condition)를 방지하기 위해
- 데이터 무결성(Integrity)을 보장하기 위해

### 동기화를 실현하는 방법

- Synchronized Method
    - 메서드 전체를 동기화하여, 한 번에 하나의 스레드만 해당 메서드를 실행할 수 있도록 한다.
- Synchronized Block
    - 메서드 전체가 아니라, 필요한 코드 구간만 동기화한다. 
- Static Synchronization
    - 인스턴스가 아니라 클래스 단위로 락을 걸어, 해당 클래스의 모든 객체에 대해 동기화가 적용되도록 한다. 

### Synchronization 구현

- Process Synchronization
    - 프로세스 간 공유 자원 접근을 제어하는 동기화
- Thread Synchronization in Java
    - Java에서 `synchronized` 등을 사용해 동기화를 구현할 수 있으며, 다음을 보장한다. 
        - Mutual Exclusion(상호 배제): 동시에 접근 불가
        - Cooperation(협력/순서 제어): 올바른 순서로 실행되도록 조정

### 예시 시나리오 (Ticket Booth)

- 티켓부스에서 `ticket1`은 한 번에 2장씩, `ticket2`는 한 번에 3장씩 판매된다고 가정한다.
- `ticket1`과 `ticket2`는 동시에 판매되더라도 정확한 수량이 유지되어야 한다.
- 티켓 판매 메서드에 synchronized method를 적용해, 판매 로직이 끊기지 않고 실행되도록 한다.
- `ticket1`, `ticket2` 각각을 별도의 스레드로 실행해도, 최종 판매 수량이 정확히 맞는지 확인한다.
