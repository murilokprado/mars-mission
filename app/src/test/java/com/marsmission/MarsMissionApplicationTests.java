package com.marsmission;

import com.marsmission.MarsMissionApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MarsMissionApplication.class)
public class MarsMissionApplicationTests {

    @Test
    public void shouldRunApplication() {
        assertThat(true).isTrue();
    }
}