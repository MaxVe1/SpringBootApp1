package net.javaguides.spring_boot_testing.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ParamsTests {
    @ParameterizedTest
    @MethodSource
    void checkAge(int age) {
    Assertions.assertThat(age).isGreaterThan(18);
}
    private static Stream<Arguments>checkAge(){
          return Stream.of(
                  Arguments.of(21),
                  Arguments.of(28),
                  Arguments.of(64)
                  //,Arguments.of(13)
              );
    }


        @ParameterizedTest
        @MethodSource
        void testWithMethodSource(String input, int expectedLength) {
            Assertions.assertThat(expectedLength).isEqualTo( input.length());
        }

        private static Stream<Arguments>testWithMethodSource() {
            return Stream.of(
                    Arguments.of("hello", 5),
                    Arguments.of("world", 5)//,
                    //Arguments.of("JUnit", 6)
            );
        }
}

