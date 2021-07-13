package com.bandipo.blogapi;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.* ;




class StudentClassApiApplicationTests {

    private TestCalculator testCalculator = new TestCalculator();



    @Test
    void contextLoads() {
    }


    @Test
    void itShouldAddNumbers(){
        //Given
        int num1 = 10;
        int num2 =10;

        //When
        int result = testCalculator.add(num1,num2);

        //Then
        assertThat(result).isEqualTo(20);

    }

    class TestCalculator {
        int add(int num1, int num2){
            return num1 + num2;
        }
    }

}
