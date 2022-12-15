package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        assertThatThrownBy(() -> user.purchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1000", "5000"})
    @ParameterizedTest
    void 로또_발행하기(String input) throws Exception{
        //given
        User user = new User();
        user.purchase(input);

        //when

        //then
        assertThat(user.getLottos().size()).isEqualTo(user.getPurchased() / 1000);
        user.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(o->assertThat(o).isSorted());
    }
}