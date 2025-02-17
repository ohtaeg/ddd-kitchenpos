package camp.nextstep.edu.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("이름을 부여한 자동차 객체 생성")
    @ValueSource(strings = {"jason", "pobi", "me", "ypi"})
    void create(final String name) {
        final Car car = new Car(name, 1);
        assertThat(car.isInPosition(1)).isTrue();
    }

    @Test
    @DisplayName("자동차 위치 확인")
    @ValueSource(ints = {1, 2, 3, 100, 10000})
    void isInPosition(final int position) {
        final Car car = new Car("name", position);
        assertThat(car.isInPosition(position)).isTrue();
    }

    @Test
    void move() {
        final Car car = new Car("name", 0);
        car.move(new TestMovingStrategy());
        assertThat(car.isInPosition(1)).isTrue();
    }

    class TestMovingStrategy implements  MovingStrategy {
        @Override
        public boolean movable() {
            return true;
        }
    }
}