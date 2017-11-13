package com.huxl.lambda;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Calendar;

public class Person {
	public enum Gender {
		MALE,FEMALE
	}

	String name;
	Calendar birthday;
	Gender gender;
	String email;

	public int getAge() {
		return 1;
	}

	public Calendar getBirthDay() {
		return birthday;
	}

	public static int compareByAge(Person person1, Person person2) {
		return person1.getBirthDay().compareTo(person2.getBirthDay());
	}

}
