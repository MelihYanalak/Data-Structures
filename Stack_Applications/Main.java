package com.company;

import java.io.*;



public class Main {

    public static void main(String[] args)throws Exception {

        countComponents("C:\\Users\\Dell\\IdeaProjects\\HW03\\test_file_part1.txt"); // FUNCTION THAT COUNTS COMPONENTS
        calculateInfix("C:\\Users\\Dell\\IdeaProjects\\HW03\\test_file_part2.txt"); // FUNCTION THAT CALCULATES THE EXPRESSION



    }
    public static boolean isOperator(char a){ // FUNCTON THAT CHECKS IF THE CHARACTER IS AN OPERATOR
        if (a == '*' || a == '-' || a == '/' || a == '+'){
            return true;
        }
        else return false;
    }
    public static boolean higherPre(char a,char b){ // FUNCTION THAT CONTROLS IF THE LEFT OPERAND HAS HIGHER PRECEDENCE THAN RIGHT OPERATOR
        if (a == 's' || a == 'c' || a == 'a'){
            return true;
        }
        else if ((a == '*' || a == '/') && (b == '+' || b == '-')){
            return true;
        }
        return false;

    }

    public static int countComponents(String fileName)throws Exception {
        int count = 0;
        myStack<Integer> stackI = new myStack<Integer>(); // STACK TO KEEP ONE INDEX OF ELEMENT
        myStack<Integer> stackJ = new myStack<Integer>(); // STACK TO KEEP ONE INDEX OF ELEMENT
        FileInputStream fstream = new FileInputStream(fileName); // OPENING FILE
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream)); // READER
        String strLine;
        String strLine2;
        int m = 0;
        int n = 0;
//Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            strLine = strLine.replaceAll(" ", ""); // READ THE LINE AND COUNT THE SIZE
            n = strLine.length();
            m++;
        }
//Close the input stream
        fstream.close();
        int k = 0;
        char[][] matrix = new char[m][n];
        fstream = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader(fstream));
        while ((strLine2 = br.readLine()) != null) {

            int i = 0;
            int j = 0;
            strLine2 = strLine2.replaceAll(" ", "");
            while (j < n) {
                matrix[k][j] = strLine2.charAt(j); // FILLING THE MATRIX
                j++;
            }
            k++;
        }

        int i = 0;
        int j = 0;
        for (i = 0;i < m ; i++){
            for (j = 0; j < n; j++) {
                if (matrix[i][j] == '1') { // IF ELEMENT IS 1 ADDS TO THE STACK
                    count++;
                    stackI.push(i);
                    stackJ.push(j);
                    while (!stackI.empty()) {
                        int temp = stackI.pop();
                        int temp2 = stackJ.pop();
                        if (matrix[temp][temp2] == '1') {
                            //count++;
                            // CONTROLS THE RIGHT NEIGHBOUR
                            matrix[temp][temp2] = (char)(count+64);
                            if ((temp+1) >= 0 && (temp+1)<= (m-1) && temp2>= 0 && temp2 <= (n-1) && matrix[temp+1][temp2] == '1'){
                                stackI.push(temp+1);
                                stackJ.push(temp2);
                            }
                            // CONTROLS THE DOWN NEIGHBOUR
                            if ((temp) >= 0 && (temp)<= (m-1) && (temp2+1)>= 0 && (temp2+1) <= (n-1) && matrix[temp][temp2+1] == '1'){
                                stackI.push(temp);
                                stackJ.push(temp2+1);
                            }
                            // CONTROLS THE LEFT NEIGHBOUR
                            if ( (temp-1) >= 0 && (temp-1)<= (m-1) && temp2>= 0 && temp2 <= (n-1) && matrix[temp-1][temp2]== '1'){
                                stackI.push(temp-1);
                                stackJ.push(temp2);
                            }
                            // CONTROLS THE UP NEIGHBOUR
                            if ((temp) >= 0 && (temp)<= (m-1) && (temp2-1) >= 0 && (temp2-1) <= (n-1) && matrix[temp][temp2-1]== '1'){
                                stackI.push(temp);
                                stackJ.push(temp2-1);
                            }
                        }
                    }
                }
            }
        }





        System.out.println("Count of Components for given file is : "+count);
        return count;
    }
    public static double calculateInfix(String fileName) throws Exception{
        FileInputStream fstream = new FileInputStream(fileName); // OPENING FILE WITH INPUT NAME
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String infix;
        myStack<Character> s = new myStack<Character>();
        myStack<Double> s2 = new myStack<Double>();          // STACKS TO KEEP OPERATORS AND NUMBERS
        String strLine,strLine2;
        int count = 0;
        while ((strLine = br.readLine()) != null && !strLine.equals(""))  {

            count++;  // COUNTS THE INPUT SIZE
        }
        int i = 0;
        fstream.close();
        double values[] = new double[count]; // ARRAY TO KEEP VARIABLES VALUES
        char variables[] = new char[count]; // TO KEEP VARIABLE NAMES
        fstream = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader(fstream));
        while ((strLine2 = br.readLine()) != null && !strLine2.equals("")){
            strLine2 = strLine2.replaceAll(" ",""); // DELETING WHITE SPACES
            variables[i] = strLine2.charAt(0);
            values[i] = Double.parseDouble(strLine2.substring(2)); // CONVERTING TO DOUBLE
            i++;
        }
        infix = br.readLine();
        fstream.close();
        char postfix[] = new char[infix.length()]; // ARRAY TO COPY THE POSTFIX VERSION OF EXPRESSION
        i = 0;
        int j = 0;
        while (i < postfix.length){

            if(infix.charAt(i) == '('){
                s.push(infix.charAt(i));
            }
            else if (infix.charAt(i) == ')'){
                while (!s.empty() && s.peek() != '('){
                    if (s.peek() == 's'){
                        postfix[j] = s.pop();

                        postfix[j+1] = 'i';
                        postfix[j+2] = 'n';
                        postfix[j+3] = ' ';
                        j = j + 4;
                    }
                    else if (s.peek() == 'c'){
                        postfix[j] = s.pop();
                        postfix[j+1] = 'o';
                        postfix[j+2] = 's';
                        postfix[j+3] = ' ';
                        j = j + 4;
                    }
                    else if (s.peek() == 'a'){
                        postfix[j] = s.pop();
                        postfix[j+1] = 'b';
                        postfix[j+2] = 's';
                        postfix[j+3] = ' ';
                        j = j + 4;
                    }
                    else{
                        postfix[j] = s.pop();
                        postfix[j + 1] = ' ';
                        j = j + 2;
                    }
                }
                s.pop();

            }
            else if (!isOperator(infix.charAt(i)) && infix.charAt(i) != '(' && infix.charAt(i) != ')' && infix.charAt(i) != ' '){
                if (infix.charAt(i) == 's' && infix.charAt(i+1) == 'i'){
                    s.push(infix.charAt(i));
                    i = i + 2;
                }
                else if (infix.charAt(i) == 'c' && infix.charAt(i+1) == 'o'){
                    s.push(infix.charAt(i));
                    i = i + 2;
                }
                else if (infix.charAt(i) == 'a' && infix.charAt(i+1) == 'b'){
                    s.push(infix.charAt(i));
                    i = i + 2;
                }
                else {
                    while (infix.charAt(i) != ' ') {
                        postfix[j] = infix.charAt(i);
                        j++;
                        i++;
                    }
                    postfix[j] = ' ';
                    j++;

                }
            }
            else if (isOperator(infix.charAt(i))) {
                if ((infix.charAt(i) == '-' || infix.charAt(i) == '+')  && infix.charAt(i+1) != ' ') {
                    s.push(infix.charAt(i));
                    postfix[j] = '0';
                    postfix[j+1] = ' ';
                    j = j + 2;
                }
                else {
                    while (!s.empty() && higherPre(s.peek(), infix.charAt(i)) && (s.peek() != '(')) {
                        if (s.peek() == 's' || s.peek() == 'c' || s.peek() == 'a') {
                            if (s.peek() == 's') {
                                postfix[j] = s.pop();

                                postfix[j + 1] = 'i';
                                postfix[j + 2] = 'n';
                                postfix[j + 3] = ' ';
                                j = j + 4;
                            } else if (s.peek() == 'c') {
                                postfix[j] = s.pop();
                                postfix[j + 1] = 'o';
                                postfix[j + 2] = 's';
                                postfix[j + 3] = ' ';
                                j = j + 4;
                            } else if (s.peek() == 'a') {
                                postfix[j] = s.pop();
                                postfix[j + 1] = 'b';
                                postfix[j + 2] = 's';
                                postfix[j + 3] = ' ';
                                j = j + 4;
                            }
                        } else {
                            postfix[j] = s.pop();
                            postfix[j + 1] = ' ';
                            j = j + 2;
                        }

                    }
                    s.push(infix.charAt(i));
                }
            }
            i++;

        }
        while (!s.empty()){
            if (s.peek() == 's'){
                postfix[j] = s.pop();
                postfix[j+1] = 'i';
                postfix[j+2] = 'n';
                postfix[j+3] = ' ';
                j = j + 4;
            }
            else if (s.peek() == 'c'){

                postfix[j] = s.pop();
                postfix[j+1] = 'o';
                postfix[j+2] = 's';
                postfix[j+3] = ' ';
                j = j + 4;

            }
            else if (s.peek() == 'a'){
                postfix[j] = s.pop();
                postfix[j+1] = 'b';
                postfix[j+2] = 's';
                postfix[j+3] = ' ';
                j = j + 4;

            }
            else {
                postfix[j] = s.pop();
                postfix[j+1] = ' ';
                j = j + 2;
            }
        }
        String postString = new String(postfix);
        int k = 0;
        while (k < j){
            if ((int)postString.charAt(k) >= 48 && (int)postString.charAt(k) <= 57 ){
                int c = 1;
                while (postString.charAt(k+c) != ' '){
                    c++;
                }
                s2.push(new Double(Double.parseDouble(postString.substring(k,k+c))));
                k = k + c ;
            }
            else if (postString.charAt(k) == ' '){
                k++;
            }
            else if (isOperator(postString.charAt(k)) && postString.charAt(k+1) == ' '){
                if (postString.charAt(k) == '+'){
                    double right = s2.pop();
                    double left = s2.pop();
                    s2.push(right+left);
                }
                else if (postString.charAt(k) == '-'){
                    double right = s2.pop();
                    double left = s2.pop();
                    s2.push(left-right);
                }
                else if (postString.charAt(k) == '*'){
                    double right = s2.pop();
                    double left = s2.pop();
                    s2.push(right*left);
                }
                else if (postString.charAt(k) == '/'){
                    double right = s2.pop();
                    double left = s2.pop();
                    s2.push(left/right);
                }
                k++;
            }

            else if (((int)postString.charAt(k) < 48 || (int)postString.charAt(k) > 57) && postString.charAt(k+1) == ' '){
                int m = 0;
                while (variables[m] != postString.charAt(k)){
                    m++;
                }
                s2.push(values[m]);
                k++;
            }
            else if (((int)postString.charAt(k) < 48 || (int)postString.charAt(k) > 57) && postString.charAt(k+1) != ' '){
                if (postString.charAt(k) == 's'){
                    double operand = s2.pop();
                    s2.push(myMath.sin(operand));
                    k = k + 3;
                }
                else if(postString.charAt(k) == 'c'){
                    double operand = s2.pop();
                    s2.push(myMath.cos(operand));
                    k = k + 3;
                }
                else if (postString.charAt(k) == 'a'){
                    double operand = s2.pop();
                    s2.push(myMath.abs(operand));
                    k = k + 3;
                }
            }


        }
        System.out.println("The result of given infix expression is : "+s2.peek());
        return s2.peek();
    }

}
