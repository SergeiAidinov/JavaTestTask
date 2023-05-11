package ru.yandex.incoming34;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MainClass {

	private static final int MAX_NUMBER = 5;
	private static final int LIST_SIZE = 10;
	private static final Random random = new Random();

	private static List<Integer> createList() {

		List initialList = new ArrayList<>();
		for (int i = 0; i < LIST_SIZE; i++) {
			initialList.add(random.nextInt(MAX_NUMBER + 1));
		}
		System.out.println("Origin list: " + initialList);
		return initialList;
	}

	private static final Map<Integer, Long> countFigures(List<Integer> integers) {

		return integers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
	}

	private static void showResult(Map<Integer, Long> map) {

		String resultString = map.toString().replace('=', ':');
		System.out.println("Result: " + resultString);
	}

	public static void main(String[] args) {
		showResult(countFigures(createList()));

	}

}
