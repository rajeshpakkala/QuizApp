
import java.util.Scanner;

public class QuizQuot {
    Questions questions[] = new Questions[5];
    public QuizQuot() {
        questions[0] = new Questions("What is the process of combining data and functions into a single unit called?", "1.Polymorphism", "2.Inheritance", "3.Abstraction", "4.Encapsulation");
        questions[1] = new Questions("When a subclass provides a specific implementation of a method that is already defined in its superclass, it is called?", "1.Polymorphism", "2.Overriding", "3.Overloading", "4.Encapsulation");
        questions[2] = new Questions("A Java interface can contain:", "1.Instance Variables", "2.Static Methods", "3.Constructors", "4.Abstract Methods");
        questions[3] = new Questions("Which of the following is NOT a Java primitive data type?", "1.int", "2.double", "3.String", "4.char");
        questions[4] = new Questions("In Java, a class can inherit from multiple classes. This is known as:", "1.Multiple Inheritance", "2.Multilevel Inheritance", "3.Hierarchical Inheritance", "4.Single Inheritance");
    }

    public char[] answers = {'4', '2', '4', '3', '1'};
    public int score = 0;

    public void startQuiz() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("=========================================================");
            System.out.println("\t\tQuiz Application");
            System.out.println("=========================================================");
            System.out.println("Time will be 20 Seconds To each Question");
            System.out.println("Score is calculated\nCorrect Answer (+2) Wrong Answer (-1) Skip (0)");
            System.out.println("--------------------------------------");
            System.out.println("\t1.Mentor");
            System.out.println("\t2.Player");
            System.out.print("\tEnter Your Choice: ");
            char choice = sc.next().charAt(0);
            System.out.println("---------------------------------------");

            if (choice == '1' || choice == '2') {
                playQuiz();
            } else {
                System.out.println("\tEnter Valid Choice (1 or 2)");
            }
        }
    }

    public void playQuiz() {
        Scanner sc = new Scanner(System.in);
        char userAns[] = new char[5];

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question: " + (i + 1));
            System.out.println(questions[i].getQuestion());
            System.out.println(questions[i].getOption1());
            System.out.println(questions[i].getOption2());
            System.out.println(questions[i].getOption3());
            System.out.println(questions[i].getOption4());

            while (true) {
                System.out.print("\nDo You Want to Skip The Question (Y/N): ");
                char skip = sc.next().charAt(0);
                if (skip == 'n' || skip == 'N') {
                    break;
                } else if (skip == 'y' || skip == 'Y') {
                    userAns[i] = '0'; // Indicate skipped question with '0'
                    break;
                } else {
                    System.out.println("Invalid input, please enter Y or N.");
                }
            }

            if (userAns[i] == '0') { // Skip further processing if question is skipped
                continue;
            }

            long start_time = System.currentTimeMillis();
            long end_time = start_time + 20000;
            System.out.print("\nPlayer Answer: ");
            userAns[i] = sc.next().charAt(0);

            long playerAnsTime = System.currentTimeMillis();
            if (playerAnsTime > end_time) {
                System.out.println("Sorry, Timed Out");
                System.out.println("--------------------------------------");
                userAns[i] = '0'; // Indicate timeout with '0'
            } else if (userAns[i] == answers[i]) {
                this.score += 2;
                System.out.println("\n\tRight Answer");
                System.out.println("\tScore: " + this.score);
                System.out.println("--------------------------------------");
            } else {
                this.score -= 1;
                System.out.println("\n\tWrong Answer\n\tCorrect Answer is: " + answers[i]);
                System.out.println("\tScore: " + this.score);
                System.out.println("--------------------------------------");
            }
        }

        System.out.println("Total Score Obtained: " + this.score + "/10");
        int percentage = (this.score * 100) / (questions.length * 2); // each question is worth 2 points
        System.out.println("Percentage: " + Math.max(percentage, 0) + "%"); // ensure percentage is not negative
        System.out.println("---------------------------------------");
        System.out.print("\nDo You Want to Play Again (Y/N): ");
        char ch = sc.next().charAt(0);
        if (ch == 'n' || ch == 'N') {
            System.exit(0);
        } else {
            this.score = 0;
            playQuiz();
        }
    }

    public static void main(String[] args) {
        QuizQuot quiz = new QuizQuot();
        quiz.startQuiz();
    }
}

/*

    import java.util.Scanner;
    class QuizQuot {

        Scanner sc = new Scanner(System.in);
        char userAns[] = new char[5];

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question: " + (i + 1));
            System.out.println(questions[i].getQuestion());
            System.out.println(questions[i].getOption1());
            System.out.println(questions[i].getOption2());
            System.out.println(questions[i].getOption3());
            System.out.println(questions[i].getOption4());

            while (true) {
                System.out.print("\nDo You Want to Skip The Question (Y/N): ");
                char skip = sc.next().charAt(0);
                if (skip == 'n' || skip == 'N') {
                    break;
                } else if (skip == 'y' || skip == 'Y') {
                    userAns[i] = '0'; // Indicate skipped question with '0'
                    break;
                } else {
                    System.out.println("Invalid input, please enter Y or N.");
                }
            }

            if (userAns[i] == '0') { // Skip further processing if question is skipped
                continue;
            }

            long start_time = System.currentTimeMillis();
            long end_time = start_time + 5000;
            System.out.print("\nPlayer Answer: ");
            userAns[i] = sc.next().charAt(0);

            long playerAnsTime = System.currentTimeMillis();
            if (playerAnsTime > end_time) {
                System.out.println("Sorry, Timed Out");
                System.out.println("--------------------------------------");
                userAns[i] = '0'; // Indicate timeout with '0'
            } else if (userAns[i] == answers[i]) {
                this.score += 2;
                System.out.println("\n\tRight Answer");
                System.out.println("\tScore: " + this.score);
                System.out.println("--------------------------------------");
            } else {
                this.score -= 1;
                System.out.println("\n\tWrong Answer\n\tCorrect Answer is: " + answers[i]);
                System.out.println("\tScore: " + this.score);
                System.out.println("--------------------------------------");
            }
        }

        System.out.println("Total Score Obtained: " + this.score + "/10");
        int percentage = (this.score * 100) / (questions.length * 2); // each question is worth 2 points
        System.out.println("Percentage: " + Math.max(percentage, 0) + "%"); // ensure percentage is not negative
        System.out.println("---------------------------------------");
        System.out.print("\nDo You Want to Play Again (Y/N): ");
        char ch = sc.next().charAt(0);
        if (ch == 'n' || ch == 'N') {
            System.exit(0);
        } else {
            this.score = 0;
            playQuiz();
        }
        Questions questions[]=new Questions[5];
        public QuizQuot()
        {
            questions[0]=new Questions("What is the process of combining data and fuctions in to single unit called ?","1.Polymorphism","2.Inheritance","3.Abstraction","4.Encapsulation");
            questions[1]=new Questions("When a subclass provides a specific implementation of a method that is already defined in its superclass, it is called ?","1.Polymorphism","2.Overriding","3.Overloading","4.Encapsulation");
            questions[2]=new Questions("A Java interface can contain :","1.Instance Variables","2.Static Methods","3.Constructors","4.Abstract Methods");
            questions[3]=new Questions("Which of the following is NOT a Java primitive data type?","1.int","2.double","3.String","4.char");
            questions[4]=new Questions(" In Java, a class can inherit from multiple classes. This is known as:","1.Multiple Inheritance","2.Multilevel Inheritance","3.Hierarchical Inheritance","4.Single Inheritance");
        }

        public  char[] answers={'4','2','4','3','1'};
        public  int score=0;

        public void startQuiz()
        {
            Scanner sc=new Scanner(System.in);
            while(true)
            {
                System.out.println("=========================================================");
                System.out.println("\t\tQuiz Application");
                System.out.println("=========================================================");
                System.out.println("Time will be 5 Seconds To each Question");
                System.out.println("Score is calculated\nCorrect Answer (+2) Wrong Answer (-1) Skip (0)");
                System.out.println("--------------------------------------");
                System.out.println("\t1.Mentor");
                System.out.println("\t2.Player");
                System.out.print("\tEnter Your Choice:");
                char choice=sc.next().charAt(0);
                System.out.println("---------------------------------------");

                if(choice=='1')
                    playQuiz();
                else if(choice=='2')
                    playQuiz();
                else
                    System.out.println("\tEnter Valid Choice(1 or 2)");
            }
        }
        public void playQuiz()
        {
            int i=0;
            dispQuestions(i);
        }
        public void dispQuestions(int i)
        {
            char userans[]=new char[5];
            Scanner sc=new Scanner(System.in);
            while(i<questions.length)
            {
                System.out.println("Question : "+(i+1));
                System.out.println(questions[i].getQuestion());
                System.out.println(questions[i].getOption1());
                System.out.println(questions[i].getOption2());
                System.out.println(questions[i].getOption3());
                System.out.println(questions[i].getOption4());
                while(true)
                {
                    System.out.print("\nDo You Want to Skip The Question (Y/N):");
                    char skip=sc.next().charAt(0);
                    if(skip=='n'||skip=='N')
                        break;
                    else
                    {
                        i++;
                        dispQuestions(i);
                    }
                }
                long start_time=System.currentTimeMillis();
                long end=start_time+5000;
                System.out.print("\nPlayer Ans :");
                userans[i]=sc.next().charAt(0);
                int status=0;
                long playeranstime=System.currentTimeMillis();
                if(playeranstime<end)
                {
                    if(userans[i]==answers[i])
                        status=1;
                    else
                        status=2;
                }
                if(status==1)
                {
                    this.score+=2;
                    System.out.println("\n\tRight Answer ");
                    System.out.println("\tScore : "+this.score);
                    System.out.println("--------------------------------------");
                    i++;
                }
                else if(status==2)
                {
                    this.score+=-1;
                    System.out.println("\n\tWrong Answer\n\tCorrect Answer is : "+answers[i]);
                    System.out.println("\tScore : "+this.score);
                    System.out.println("--------------------------------------");
                    i++;
                }
                else if(status==0)
                {
                    System.out.println("Sorry Timed Out " );
                    System.out.println("--------------------------------------");
                    i++;
                }
            }
            System.out.println("Total Score Obtained :"+this.score+"/10");
            if(this.score > 0)
                System.out.println("Percentage           : "+(this.score*100/10)+"%");
            else if(this.score<=0)
                System.out.println("Percentage         : 0%");
            System.out.println("---------------------------------------");
            System.out.print("\nDo You Want to Play Again(Y/N):");
            char ch=sc.next().charAt(0);
            if(ch=='n'||ch=='N')
                System.exit(0);
            else
            {
                this.score=0;
                startQuiz();
            }
        }
    }
*/
