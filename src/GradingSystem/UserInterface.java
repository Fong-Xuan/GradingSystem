package GradingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
    ///////////////////
    //2016 3/22 20:43~22:51//
    ///////////////////
    private int userID;
    private String userName;
    private GradingSystem gradingSystem;

    /* method UserInterface ----------------------------------------------------------------------------------
    * build grading system
    *
    * @param ID    none
    * @return void
    *
    *Pseudo code:
    *1. new GradingSystem() and save it
    *
    ----------------------------------------------------------------------------------------------------------*/
    public UserInterface() {
        gradingSystem = new GradingSystem();

    }


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
	* Time estimate :
	* Example:
	----------------------------------------------------------------------------------------------------------*/

    public static void main(String[] argvs) throws IOException {
        UserInterface UI = new UserInterface();
        UI.start();
        System.out.println("謝謝使用，若喜歡我們的程式請到粉絲專頁「起剛的秘密花園」按讚><");

    }

	/* method  promptcommand  ----------------------------------------------------------------------------------
	* print the command list
	*
	* @param ID    none
	* @return void
	*
	*Pseudo code:
	*1.print the command list
    *
	----------------------------------------------------------------------------------------------------------*/

    private boolean checkID(int id) {
        return gradingSystem.containsID(id);
    }
	/* method  executeCommand  ----------------------------------------------------------------------------------
	* execute the command user type in
	*
	* @param command    command want to execute
	* @return 1 if user are not leave yet
	* @return 5 Exit
	*
	*
	* @throws
	*
	*Pseudo code:
	*1.decode the command string to decide the type of command and call corresponding functions
	*2.return the number 1 or 5
    *
	* Time estimate :
	* Example:
	----------------------------------------------------------------------------------------------------------*/

    public void promptCommand() {
        System.out.println("輸入指令 ");
        System.out.println("1) G 顯示成績 (Grade)");
        System.out.println("2) R 顯示排名 (Rank)");
        System.out.println("3) A 顯示平均 (Average)");
        System.out.println("4) W 更新配分 (Weight)");
        System.out.println("5) E 離開選單 (Exit)");
    }

    public int executeCommand(String command) {
        int commandType = 0;
        if (command.compareTo("G") == 0) gradingSystem.showGrade(userID);
        else if (command.compareTo("R") == 0) gradingSystem.showRank(userID);
        else if (command.compareTo("A") == 0) gradingSystem.showAverage();
        else if (command.compareTo("W") == 0) gradingSystem.updateWeights();
        else if (command.compareTo("E") == 0) return 5;
        else System.out.println("你在那邊亂打指令!");
        return 1;
    }

    /* method  showFinishMsg  ----------------------------------------------------------------------------------
    * show Finish Msg
    *
    * @param none
    * @return none
    *
    * @throws
    *
    *Pseudo code:
    *1.print it
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    private void showFinishMsg() {
        System.out.println("掰掰! " + userName);
    }
    //UI() 建構子 建構 aGradeSystem


	/* method  start  ----------------------------------------------------------------------------------
	* to start the User Interface and the whole system.
	*
	* @param ID void
	* @return void
	*
	*Pseudo code:
	*1. turn to Login mode, print Login words
	*2. ask user to enter user's ID or 'Q'
	*3. let UserInterface do checkID() to check if ID correct,
	*   if correct,showWelcomeMessage() and turn to user mode,
		if not, ask user to login again
    *
	* ----------------------------------------------------------------------------------------------------------*/

    /* method  showWelcomeMsg  ----------------------------------------------------------------------------------
    * control the flow of user interface
    *
    * @param none
    * @return none
    *
    * @throws
    *
    *Pseudo code:
    *1.call promptCommand to show command
    *2. if user wants to exit , call showFinishMsg() and break from loop
    *
    * Time estimate :
    * Example:
    ----------------------------------------------------------------------------------------------------------*/
    private void showWelcomeMsg() throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("你好啊! " + userName);
        while (true) {
            promptCommand();
            if (executeCommand(bufferRead.readLine()) == 5) {
                showFinishMsg();
                break;
            }
        }
    }

    public void start() throws IOException {
        while (true) {
            System.out.println("輸入ID或 Q (結束使用)？");
            String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (s.compareTo("Q") == 0) break;
            try {
                int id = Integer.parseInt(s);
                if (checkID(id)) {
                    userID = id;
                    userName = new String(gradingSystem.getGrades().getName(userID));
                    showWelcomeMsg();
                }
            } catch (NumberFormatException e) {
                System.out.println("輸入有誤，請再輸入一次！");
            }
        }
    }


}