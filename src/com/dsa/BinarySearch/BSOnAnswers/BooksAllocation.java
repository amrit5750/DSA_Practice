package com.dsa.BinarySearch.BSOnAnswers;

public class BooksAllocation {

    public static void main(String[] args) {

        int[] books = { 25, 46, 28, 49, 24 };
        int students = 4;

        System.out.println(getMaximumPages(books, students));

    }

    public static int getMaximumPages(int[] books, int students) {

        if (students > books.length)
            return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < books.length; i++) {
            low = Math.max(books[i], low);
            high += books[i];

        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBooksAllocated(books, mid, students)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static boolean canBooksAllocated(int[] books, int pages, int students) {

        int studentCount = 1;
        int lastbookPages = books[0];

        for (int i = 1; i < books.length; i++) {

            if (lastbookPages + books[i] <= pages) {
                lastbookPages += books[i];

            } else {
                studentCount++;
                lastbookPages = books[i];
            }

        }

        return studentCount <= students;

    }

}
