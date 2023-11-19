package com.greatlearning.questionNo1.services;

import java.util.Arrays;
import java.util.Stack;

public class Skyscraper {
	static boolean isLargest;

	public static void calculateFloors(int[] floorSizes) {
		Stack<Integer> floorStack = new Stack<>();

		for (int currentDay = 0; currentDay < floorSizes.length; currentDay++) {
			isLargest = true;
			int currentFloorSize = floorSizes[currentDay];

			for (int nextDay = currentDay; nextDay < floorSizes.length; nextDay++) {
				if (nextDay != currentDay) {
					int nextFloorSize = floorSizes[nextDay];

					if (currentFloorSize < nextFloorSize) {
						isLargest = false;
						floorStack.push(currentFloorSize);
						break;
					}
				}
			}

			if (isLargest) {
				try {
					Stack<Integer> tempStack = displayFloor(floorStack, currentFloorSize, currentDay, floorSizes);
					floorStack.clear();
					floorStack.addAll(tempStack);
					tempStack.clear();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Day " + (currentDay + 1) + " :");
			}
		}
	}

	public static Stack<Integer> displayFloor(Stack<Integer> floorStack, int currentFloor, int iterator,
			int[] arrayFloor) {
		int[] poppedFloors = new int[arrayFloor.length];
		int count = 0;

		System.out.print("Day " + (iterator + 1) + " : " + currentFloor);
		Stack<Integer> tempStack = new Stack<>();
		boolean isLargestInStack;

		if (iterator == arrayFloor.length - 1) {
			while (!floorStack.empty()) {
				int poppedFloor = floorStack.pop();
				poppedFloors[count++] = poppedFloor;
			}
		} else {
			while (!floorStack.empty()) {
				isLargestInStack = true;
				int poppedFloor = floorStack.pop();

				for (int i = iterator; i < arrayFloor.length; i++) {
					if (i == iterator) {
						continue;
					}

					if (poppedFloor < arrayFloor[i]) {
						tempStack.push(poppedFloor);
						isLargestInStack = false;
						break;
					}
				}

				if (isLargestInStack) {
					poppedFloors[count++] = poppedFloor;
				}
			}
		}

		Arrays.sort(poppedFloors);

		for (int i = poppedFloors.length - 1; i > 0; i--) {
			if (poppedFloors[i] != 0) {
				System.out.print(" " + poppedFloors[i]);
			}
		}

		return tempStack;
	}
}
