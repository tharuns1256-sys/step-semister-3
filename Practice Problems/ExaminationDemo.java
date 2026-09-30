abstract class Question {

    protected String questionText;
    protected int points;

    public Question(String questionText, int points) {
        this.questionText = questionText;
        this.points = points;
    }

    public abstract boolean evaluate(String answer);

    public int getPoints() {
        return points;
    }
}

class MultipleChoiceQuestion extends Question {

    private String correctAnswer;

    public MultipleChoiceQuestion(
        String questionText,
        int points,
        String correctAnswer
    ) {
        super(questionText, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(
        String questionText,
        int points,
        boolean correctAnswer
    ) {
        super(questionText, points);
        this.correctAnswer = correctAnswer;
    }

    public boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Examination {

    private String name;
    private Question[] questions;

    public Examination(
        String name,
        Question[] questions
    ) {
        this.name = name;
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public Question[] getQuestions() {
        return questions;
    }
}

class Attempt {

    private Student student;
    private Examination exam;
    private String[] answers;
    private boolean submitted;

    public Attempt(
        Student student,
        Examination exam
    ) {
        this.student = student;
        this.exam = exam;

        answers =
            new String[exam.getQuestions().length];

        submitted = false;
    }

    public void answerQuestion(
        int questionNumber,
        String answer
    ) {

        if (submitted) {
            System.out.println(
                "Cannot change answers for a submitted examination."
            );
            return;
        }

        answers[questionNumber - 1] = answer;

        System.out.println(
            "Answer recorded for Question " +
            questionNumber + "."
        );
    }

    public void submit() {

        if (submitted) {
            return;
        }

        submitted = true;

        System.out.println(
            exam.getName() +
            " submitted by " +
            student.getName() + "."
        );

        int totalScore = 0;
        int totalPoints = 0;

        Question[] questions = exam.getQuestions();

        for (int i = 0; i < questions.length; i++) {

            totalPoints += questions[i].getPoints();

            boolean correct =
                questions[i].evaluate(answers[i]);

            int score =
                correct ? questions[i].getPoints() : 0;

            totalScore += score;

            System.out.println(
                "Question " + (i + 1) + ": " +
                (correct ? "Correct" : "Incorrect") +
                " (" + score + " points)"
            );
        }

        System.out.println(
            "Total score: " +
            totalScore + "/" + totalPoints
        );
    }
}

public class ExaminationDemo {

    public static void main(String[] args) {

        Student student =
            new Student("Student 1");

        Question q1 =
            new MultipleChoiceQuestion(
                "Choose the correct option.",
                5,
                "C"
            );

        Question q2 =
            new TrueFalseQuestion(
                "Java is object oriented.",
                5,
                false
            );

        Question[] questions = {q1, q2};

        Examination exam =
            new Examination(
                "Exam A",
                questions
            );

        Attempt attempt =
            new Attempt(student, exam);

        System.out.println(
            "Exam A started by Student 1."
        );

        attempt.answerQuestion(1, "C");
        attempt.answerQuestion(2, "True");

        attempt.submit();

        attempt.answerQuestion(1, "A");
    }
}