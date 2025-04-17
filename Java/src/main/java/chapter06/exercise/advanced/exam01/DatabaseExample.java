package chapter06.exercise.advanced.exam01;

public class DatabaseExample {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.connect();
        System.out.println("데이터베이스: " + database.getConnection());
        database.close();
    }
}
