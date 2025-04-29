package chapter13.exercise.advanced.exam02;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Board> list = new LinkedList<>();

        Board board1 = new Board("주제", "내용", "저자");
        Board board2 = new Board("주제2", "내용2", "저자2");
        Board board3 = new Board("주제3", "내용3", "저자3");
        Board board4 = new Board("주제4", "내용4", "저자4");
        Board board5 = new Board("주제5", "내용5", "저자5");

        list.add(board1);
        list.add(board2);
        list.add(board3);
        list.add(board4);
        list.add(board5);

        System.out.println(list.size());
        System.out.println(list.get(2));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.remove(2);
        list.remove(2);

        for (Board board : list) {
            System.out.println(board);
        }
    }
}
