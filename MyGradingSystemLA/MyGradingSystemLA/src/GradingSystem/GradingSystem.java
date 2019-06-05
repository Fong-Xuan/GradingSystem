package GradingSystem;

import java.awt.datatransfer.StringSelection;
import java.util.Scanner;

public class GradingSystem {
    Grades grades;

    /* method  checkID  ----------------------------------------------------------------------------------
    * 用來確認欲查詢的ID是否存在於GradeSystems系統內
    *
    * @param ID     用來查詢的ID
    * @return 一個布林值，若為true則代表GradeSystems有這筆資料，若false則否
    *
    * @throws NoSuchIDExceptions –
    *			若使用者輸入的ID不在GradeSystems內則拋出NoSuchIDExceptions
    *Pseudo code:
    *1.要aGradeSystem 做containsID(ID) 看 ID 是否含在 aGradeSystem內
    *2.if not, throw an object of NoSuchIDExceptions
    *3.回傳 true
    *
    * Time estimate : O (n)
    * Example: UI物件.checkID(962001044) ; 傳回結果為 true
    ----------------------------------------------------------------------------------------------------------*/
    public GradingSystem (){
        grades = new Grades();
    }

    /* method  containsID  ----------------------------------------------------------------------------------
    * 	用來確認欲查詢的ID是否存在於GradeSystems系統內
    *
    * @param ID     用來查詢的ID
    * @return 一個布林值，若為true則代表GradeSystems有這筆資料，若false則否
    *
    * @throws NoSuchIDExceptions –
    *			若使用者輸入的ID不在GradeSystems內則拋出NoSuchIDExceptions
    *Pseudo code:
    *1.go through Grades to find the disered ID
    *2.if found, return true;
    *3.else return false;
    *
    * Time estimate : O (n)
    * Example: UI物件.checkID(962001044) ; 傳回結果為 true
    ----------------------------------------------------------------------------------------------------------*/
    boolean	containsID(int id){
        int target = 0;
        if((target = grades.containsID(id)) != -1)
            return true;
        return false;
    }

    /* method  showGrade  ----------------------------------------------------------------------------------
    *	 show the Grade of the user
    *
    * @param ID     用來查詢的ID
    * @return void
    *
    * @throws
    *
    *Pseudo code:
    *1. use Grades do getGrade;
    *2. return;
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    void showGrade(int id){
        int grades_tmp[] = grades.getGrade(id);
        System.out.println(
                grades.getName(id) +
                        "成績："+
                        "\n      lab1:       "+grades_tmp[0]+
                        "\n      lab2:       "+grades_tmp[1]+
                        "\n      lab3:       "+grades_tmp[2]+
                        "\n      mid-term:   "+grades_tmp[3]+
                        "\n      final exam: "+grades_tmp[4]+
                        "\n      total grade:"+grades_tmp[5]);
    }

    /* method  showRank  ----------------------------------------------------------------------------------
    * 	show the rank of the user
    *
    * @param ID    ID for looking up
    * @return void
    *
    * @throws
    *
    *Pseudo code:
    *1. let Grades do getRank()
    *2. return;
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    void showRank(int id){
        System.out.println(grades.getRank(id));
    }

    /* method  showAverage  ----------------------------------------------------------------------------------
    * 	show the average of each subject
    *
    * @param void
    * @return void
    *
    * @throws
    *
    *Pseudo code:
    *1.use Grades to do getAverage()
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    void showAverage(){
        int averageGrade[] = grades.getAverage();
        System.out.println(
                "各項平均："
                        +"\n      lab1:       " + averageGrade[0]
                        +"\n      lab2:       " + averageGrade[1]
                        +"\n      lab3:       " + averageGrade[1]
                        +"\n      mid-term:   " + averageGrade[1]
                        +"\n      final exam: " + averageGrade[1]);
    }


    /* method  updateWeights  ----------------------------------------------------------------------------------
    * 	update the new weights of each exam that the user type in,
    *	and let Grades to recalculate all properties
    *
    * @param void
    * @return void
    *
    * @throws none
    *
    *
    *Pseudo code:
    *1.show the original weight set by showOldWeights()
    *2.call inputNewWeights(),witch ask user to type in the new weight set
    *3.call checkToSetWeight(),let user to decide if the new weight is correct or not.
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    public void updateWeights (){
        showOldWeights(grades.getWeight());
        int[] new_weights = inputNewWeights();
        System.out.println("輸入新配分:");
        System.out.println("      lab1:       "+new_weights[0]);
        System.out.println("      lab2:       "+new_weights[1]);
        System.out.println("      lab3:       "+new_weights[2]);
        System.out.println("      mid-term:   "+new_weights[3]);
        System.out.println("      final exam: "+new_weights[4]);
        System.out.println("以上正確嗎? Y (Yes) 或 N (No)");
        checkToSetWeight(new_weights);

    }

    /* method  checkToSetWeight  ----------------------------------------------------------------------------------
    * 	check if the new weight is correct or not
    *
    * @param void
    * @return none
    *
    * @throws
    *
    *Pseudo code:
    *
    *1. type 'Y' for correct, 'N' for no
    *   if correct, call grades.set_Weight() ;
    *   else return without any change
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    private void checkToSetWeight(int[] new_weights){
        Scanner scanner = new Scanner(System.in);
        String reply = scanner.next();
        if(reply.equals("Y") || reply.equals("y"))
            grades.setWeight(new_weights);

    }

    /* method  checkToSetWeight  ----------------------------------------------------------------------------------
    * 	ask user to type in the new weight set
    *
    * @param void
    * @return int[] new_weight
    *
    * @throws
    *
    *Pseudo code:
    *
    *1. ask user to type in the new weight set
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    private int[] inputNewWeights(){
        Scanner scanner = new Scanner(System.in);
        int[] new_weight = {0,0,0,0,0};
        System.out.println("輸入新配分:");
        System.out.print("      lab1:       ");
        new_weight[0] = scanner.nextInt();
        System.out.print("      lab2:       ");
        new_weight[1] = scanner.nextInt();
        System.out.print("      lab3:       ");
        new_weight[2] = scanner.nextInt();
        System.out.print("      mid-term:   ");
        new_weight[3] = scanner.nextInt();
        System.out.print("      final exam: ");
        new_weight[4] = scanner.nextInt();
        return new_weight;
    }
    /* method  showOldWeights  ----------------------------------------------------------------------------------
    * 	print the old weights set
    *
    * @param void
    * @return void
    *
    * @throws
    *
    *Pseudo code:
    *
    *1. print it out
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    private void showOldWeights(int[] old_weights){
        System.out.println("舊配分:");
        System.out.println("      lab1:       "+old_weights[0]);
        System.out.println("      lab2:       "+old_weights[1]);
        System.out.println("      lab3:       "+old_weights[2]);
        System.out.println("      mid-term:   "+old_weights[3]);
        System.out.println("      final exam: "+old_weights[4]);

    }
    /* method  getGrades ----------------------------------------------------------------------------------
    * 	give the access to  grades
    *
    * @param void
    * @return Grades grades
    *
    * @throws
    *
    *Pseudo code:
    *
    *1. return it
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    public Grades getGrades(){
        return grades;
    }


}