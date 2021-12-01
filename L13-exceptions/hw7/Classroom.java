package hw7;

public class Classroom {
    private

    class Teacher {

        private Journal journal;

         public void startLesson() {
            System.out.println("Please take your seats and let's begin our lesson");
        }

        public void putMarksInJournal(int mark, Student student) {

        }
    }

    class Journal {

    }

    class Student {
        GroupOfStudents group;
        public void comeToClassroom() {
            System.out.println("I am in the classroom");
        }
    }

    class GroupOfStudents {
        private int numberOfStudents;
        public boolean isEveryoneInTheClassroom;

        public GroupOfStudents(int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
        }

        public int getNumberOfStudents() {
            return numberOfStudents;
        }
    }
}
