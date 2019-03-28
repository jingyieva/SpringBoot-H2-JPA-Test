package com.eva.SpringPractice.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.eva.sp.SpringInitApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringInitApplication.class})
@WebAppConfiguration
public class AppSpringTest<T> {

	@Test
	public void test() {
		System.out.println("Run Spring Test Success.");
	}
}
