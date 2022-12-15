package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserTest {

    @ValueSource(strings = {"1000", "5000", "2000000000"})
    @ParameterizedTest
    void 제대로된_금액_입력(String input) throws Exception{
        //given
        User user = new User();

        //when
        user.purchase(input);

        //then
    }

    @ValueSource(strings = {"1005", "d5000", "-341"})
    @ParameterizedTest
    void 잘못된_금액_입력(String input) throws Exception{
        //given
        User user = new User();

        //when

        //then
        Assertions.assertThatThrownBy(() -> user.purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}