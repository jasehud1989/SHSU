/*    Dots.java    Title:          Dots    Author:         Laura Toma based on code from Eric Chown based on code from Northeastern University    Description:    This program can be used to draw geometric puzzles                    through the use of loop structures. *//////////////////////////////////////////////////////////////////////////////////  Lab:    Dot Patterns//  Goals:  Learn Standard Patterns of Single, Double, or Triple Looping//          Complexity analysis of loop structures//  STUDENT NAME: Cameron Green//  DATE: 09/07/2016///////////////////////////////////////////////////////////////////////////////import java.io.*;import java.util.Scanner;public class Dots{public static final int MAXPATTERN = 16;             // maximun number of patternspublic static final int STARTX = 0;           // X location of drawing windowpublic static final int STARTY = 0;           // Y location of drawing windowpublic static final int SOLX = 401;           // X location of solution windowpublic static final int SOLY = STARTY;        // Y location of solution windowprivate DrawingBoard board;                   // the drawing windowprivate DrawingBoard solutionBoard;           // solution windowprivate SolutionDots solution;                // the object that knows how to draw the solutionScanner reader;                               // object for reading from userprivate int pattern = 0;                      // the pattern we are currently on/** the constructor: creates the boards, and opens stdin for reading from user */public Dots(){        board = new DrawingBoard(STARTX, STARTY);        solutionBoard = new DrawingBoard(SOLX, SOLY);        solution = new SolutionDots(solutionBoard);        reader = new Scanner(System.in);}/** Method which makes drawing calls.  Your code goes in here.  Do   not add any variables! */public void drawPattern(int pattern){        int row;         // loop variable        int col;         // loop variable        int k;           // extra loop variable        int COLS = 8;    // constant        int ROWS = 8;    // constant        board.clear();        //set title        board.setTitle("Your pattern " + pattern);        //draw the correct pattern        solution.draw(pattern);        // draw your pattern        // assume maximum number of dots in each row or col is 8        switch (pattern) {        case 1:                for (row = 0; row < ROWS; row++)                        for (col = 0; col < COLS; col++)                                board.bigDot(row, col);                break;        case 2:                for (row = 0; row < ROWS; row++)                        for (col = 0; col < COLS; col++)                                board.bigDot(col, row);                break;        case 3:                for (row = 0; row < ROWS; row++) {                        for (col = 0; col < row; col++) {                                board.bigDot(row, col);                        }                }                break;        case 4:                for (row = 0; row < ROWS; row++) {                        for (col = row; col < COLS; col++ ) {                                board.bigDot(row, col);                        }                }                break;        case 5:                for (col = 0; col < COLS; col++, ROWS-=1) {                        for (row = 0; row < ROWS; row++) {                                board.bigDot(col, row);                        }                }                break;        case 6:                for(row = 0; row < ROWS; row++)                        for(col = COLS; col >= COLS - row; col--)                                board.bigDot(row,col);                break;        case 7:                for (row = 0; row <= ROWS; row++)                        board.bigDot(row, row);                break;        case 8:                for (row = 0; row <= ROWS; row++) {                        board.bigDot(row, row);                };                for (col = COLS, row=0; col>=0; col--,row++) {                        board.bigDot(row,col);                };                break;        case 9:                for (col = 0; col < 4; col++,ROWS--,row++ ) {                        for(row = col; row < ROWS; row++) {                                board.bigDot(row, col);                        }                }                break;        case 10:                for (col = 0; col < COLS; col++,ROWS--,row++ ) {                        for(row = col; row < ROWS; row++) {                                board.bigDot(row, col);                        }                        for(row = 4; row < col + 1; row++) {                                row -=1;                                board.bigDot(row, col);                        }                }                break;        default:                System.out.println("This one hasn't been done yet.");                break;        }}/**  Metho to read in from user which pattern to do next.  If the *  user enters an integer between 1 and MAXPATTERN this value is *  returned; if the user enters q it returns -1; if the user *  enters something else it returns the current pattern; */public int getPattern(){        //set the default pattern, in case its needed        int defaultPattern = ++pattern;        if (defaultPattern > MAXPATTERN) defaultPattern = 1;        int newPattern = defaultPattern;        System.out.print("What Pattern? [" + defaultPattern + " default, q to quit]: ");        //read user input        String answer = reader.nextLine();        //if user did not enter RETURN        if (answer.length() != 0) {                // a temporary scanner just to read the line                Scanner lineReader = new Scanner(answer);                //if an integer                if (lineReader.hasNextInt()) {                        newPattern= lineReader.nextInt();                        if (newPattern < 1 || newPattern > MAXPATTERN) {                                System.out.println("Pattern out of range---set to default=" + defaultPattern);                                newPattern = defaultPattern;                        }                } else { //not an integer                        if (answer.charAt(0) == 'q') newPattern = -1;                        //else newPattern = pattern;                }        }        //correctness check        assert ((newPattern == -1)  || (newPattern >= 1 && newPattern <= 16)) : "invalid pattern";        return newPattern;}/**  Main loop.  Check if user wants pattern, then execute it. */public void UserLoop(){        //System.out.println("Dot Patterns");        //System.out.println(" ");        boolean keepPlaying = true;        while (keepPlaying)  {                // request next pattern code                pattern = getPattern();                //System.out.println("you said pattern: " + pattern);                //did the user want to quit?                if (pattern == -1)                        keepPlaying = false;                else                        drawPattern(pattern); // draw the pattern        }}public static void main(String args[]){        // OPEN THE TEXT AND DRAWING WINDOWS:        Dots d = new Dots();        System.out.println("Welcome to the dot pattern generator.");        //THE BODY OF THE MAIN FUNCTION        d.UserLoop();        //THAT'S IT. QUIT WHEN USER HITS RETURN        System.out.println("Terminating Program. Good bye.");        System.exit(1);}      // end main  public Dots()} //end class Dots