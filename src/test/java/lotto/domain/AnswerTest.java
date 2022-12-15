package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerTest {

    @Test
    void 당첨번호_입력받기() throws Exception{
        //given
        Answer answer= new Answer();

        //when
        answer.readAnswerNumber("1,2,3,4,5,6");
        answer.readAnswerNumber("1,2,3,4,5,45");

        //then
    }

    @ValueSource(strings = {"1,2,3,3,4,5", "fae", "0,1,2,3,4,5", "1,2,3,4,5,46"})
    @ParameterizedTest
    void 잘못된_당첨번호_입력받기(String input) throws Exception{
        //given
        Answer answer = new Answer();

        //when

        //then
        Assertions.assertThatThrownBy(() -> answer.readAnswerNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_입력받기() throws Exception{
        //given
        Answer answer= new Answer();
        answer.readAnswerNumber("1,2,3,4,5,6");

        //when
        answer.readBonusNumber("7");
        answer.readBonusNumber("45");

        //then
    }

    @ValueSource(strings = {"6", "f"})
    @ParameterizedTest
    void 잘못된_보너스_번호_입력(String input) throws Exception{
        //given
        Answer answer= new Answer();
        answer.readAnswerNumber("1,2,3,4,5,6");

        //when

        //then
        Assertions.assertThatThrownBy(() -> answer.readBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}