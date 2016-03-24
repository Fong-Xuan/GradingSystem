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
	* @throws NoSuchIDExceptions – 
	*			若使用者輸入的ID不在GradeSystems內則拋出NoSuchIDExceptions
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
	* @throws NoSuchIDExceptions – 
	*			若使用者輸入的ID不在GradeSystems內則拋出NoSuchIDExceptions
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
	* 	update the new weights of each exam the user type in, 
	*	and let Grades to recaluculate all properties
	*
	* @param void
	* @return ture or not, sucess or not
	*
	* @throws No100Exceptions – 
	*			 No100Exceptions
	*
	*Pseudo code:
	*1.show the original weight set
	*2.ask user to type in the new weight set in the order of the subject
	*3.print the new weight set to ask user re-check it, Correct or Not?
	*4. type 'Y' for correct, 'N' for no
	*   if correct, use Grades do recalculate() to reset new properties and return ; 
	*   else return without any change
    *
	* Time estimate : O ()
	* Example: UI物件.checkID(962001044) ; 傳回結果為 true
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
	private void checkToSetWeight(int[] new_weights){
		Scanner scanner = new Scanner(System.in);
		String reply = scanner.next();
		if(reply.equals("Y") || reply.equals("y"))
				grades.setWeight(new_weights);
		
	}
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
	
	private void showOldWeights(int[] old_weights){
		System.out.println("舊配分:");
		System.out.println("      lab1:       "+old_weights[0]);
		System.out.println("      lab2:       "+old_weights[1]);
		System.out.println("      lab3:       "+old_weights[2]);
		System.out.println("      mid-term:   "+old_weights[3]);
		System.out.println("      final exam: "+old_weights[4]);
		
	}
	
	public Grades getGrades(){
		return grades;
	}
	

}
