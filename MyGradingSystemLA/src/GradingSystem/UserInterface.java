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
	public UserInterface(){
		gradingSystem = new GradingSystem();
		
	}
	
	
	/* method  checkID  ----------------------------------------------------------------------------------                                                                                                    
	* �ΨӽT�{���d�ߪ�ID�O�_�s�b��GradeSystems�t�Τ�
	*
	* @param ID     �ΨӬd�ߪ�ID
	* @return �@�ӥ��L�ȡA�Y��true�h�N��GradeSystems���o����ơA�Yfalse�h�_
	*
	* @throws NoSuchIDExceptions �V 
	*			�Y�ϥΪ̿�J��ID���bGradeSystems���h�ߥXNoSuchIDExceptions
	*Pseudo code:
	*1.�naGradeSystem ��containsID(ID) �� ID �O�_�t�b aGradeSystem�� 
	*2.if not, throw an object of NoSuchIDExceptions
	*3.�^�� true
    *
	* Time estimate :
	* Example: 
	----------------------------------------------------------------------------------------------------------*/

	private boolean checkID(int id){
		return gradingSystem.containsID(id);
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
	
	public void promptCommand(){
		System.out.println("��J���O ");
		System.out.println("1) G ��ܦ��Z (Grade)");
		System.out.println("2) R ��ܱƦW (Rank)");
		System.out.println("3) A ��ܥ��� (Average)");
		System.out.println("4) W ��s�t�� (Weight)");
		System.out.println("5) E ���}��� (Exit)");
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

	public int executeCommand(String command){
		int commandType = 0;
		if(command.compareTo("G")==0) gradingSystem.showGrade(userID);
		else if(command.compareTo("R")==0) gradingSystem.showRank(userID);
		else if(command.compareTo("A")==0) gradingSystem.showAverage();
		else if(command.compareTo("W")==0) gradingSystem.updateWeights();
		else if(command.compareTo("E")==0) return 5;
		else System.out.println("�A�b����å����O!");
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
	private void showFinishMsg(){
		System.out.println("�T�T! "+userName);
	}
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
	private void showWelcomeMsg() throws IOException{
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�A�n��! "+userName);
    	while(true){
    		promptCommand();
    		if(executeCommand(bufferRead.readLine()) == 5){
				showFinishMsg();
				break;
			}
    	}
	}
	//UI() �غc�l �غc aGradeSystem
	
	
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

	
	public void start() throws IOException{
		while(true){
			System.out.println("��JID�� Q (�����ϥ�)�H");
			String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			if(s.compareTo("Q")==0) break;
			try {int id = Integer.parseInt(s);
				if(checkID(id)){
					userID = id;
		        	userName=new String(gradingSystem.getGrades().getName(userID));	 
		        	showWelcomeMsg();
		        }   
	     	} catch(NumberFormatException e ) { 
				  System.out.println("��J���~�A�ЦA��J�@���I");
			}
		}		
	}

	public static void main(String[] argvs) throws IOException{
		UserInterface UI = new UserInterface();
		UI.start();
		System.out.println("���¨ϥΡA�Y���w�ڭ̪��{���Ш쯻���M���u�_�誺���K���v���g><");

	}
	
	
	
	
	
	
}