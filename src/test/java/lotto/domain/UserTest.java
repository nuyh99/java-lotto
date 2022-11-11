package lotto.domain;

import lotto.exception.Input;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void 유저_금액_입력_받기() throws Exception {
        //given
        User user = new User();

        //when
        user.inputPurchaseAmount("5000");

        //then
        assertThat(user.getPurchaseAmount()).isEqualTo(5000);
    }

    @Test
    void 잘못된_금액_입력() throws Exception {
        //given
        User user = new User();

        //when
        String wrongUnit = "5100";
        String notNumeric = " 123123 ";

        //then
        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmount(wrongUnit))
                .getMessage().equals(Input.WRONG_UNIT_OF_WON.getErrorMessage());

        assertThrows(IllegalArgumentException.class,
                () -> user.inputPurchaseAmount(notNumeric))
                .getMessage().equals(Input.NOT_NUMERIC.getErrorMessage());
    }

    @Test
    void 로또_발행하기() throws Exception {
        //given
        User user = new User();
        user.inputPurchaseAmount("50000");

        //when
        user.createLottos();

        //then
        assertThat(user.getLottos().size()).isEqualTo(50);
        assertThat(user.getLottos().get(0).getNumbers()).isSorted();
    }
}