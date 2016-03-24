package GradingSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class Grades {
	ArrayList<aGrade> gradeList;
	int idNum;
	static int[] weight_set = {10, 10, 10, 30, 40} ;
	int lab1_avg, lab2_avg, lab3_avg, midTerm_avg, finalExam_avg;
	
	/* method  Grades  ----------------------------------------------------------------------------------                                                                                                    
	* build class Grades
	*
	* @param none
	* @return none
	*
	*Pseudo code:
	*1.load the information from gradeinput.txt
	*2.save the information in ArrayList<aGrade> gradeList
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/

	public Grades(){
		idNum  = 0;
		gradeList = new ArrayList<aGrade>();
		loadGradeFile();
		recalculate();

	}
	private void loadGradeFile(){
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader (new FileInputStream("gradeinput.txt"),"UTF-8"));
			String Orig_Line = "";
			while((Orig_Line=br.readLine()) != null){
				Vector tmp = new Vector();
		//		String name = null;
				String[] afterSplit = Orig_Line.split(" ");
				for(int i=0; i<7; i++){
				//	if(i == 1) name = afterSplit[i];
				//	else tmp.add(Integer.parseInt(afterSplit[i]));
					tmp.add(afterSplit[i]);
				}
//				gradeList.add(new aGrade(tmp.get(0), name, tmp.get(1), 
//						tmp.get(2), tmp.get(3), tmp.get(4), tmp.get(5)));
				gradeList.add(new aGrade(Integer.parseInt((String) tmp.get(0)),
						(String)tmp.get(1), 
						Integer.parseInt((String) tmp.get(2)), 
						Integer.parseInt((String) tmp.get(3)), 
						Integer.parseInt((String) tmp.get(4)), 
						Integer.parseInt((String) tmp.get(5)),
						Integer.parseInt((String) tmp.get(6))));
				idNum++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* method  getGrade  ----------------------------------------------------------------------------------                                                                                                    
	* use input Id to get corresponding info from gradeList
	*
	* @param Id  Id for looking for the infomation
	* @return boolean true if id exist
	* 				  false if id doesn't exist
	*
	* @throws NoSuchIDExceptions ¡V 
	*			
	*Pseudo code:
	*1.use Id to look for the information in gradeList
	*2.if Id exist print out the info and return true
	*  else return false
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/

	public int[] getGrade(int id){
		int target;
		if((target =  containsID(id)) != -1){
		aGrade aGrade_tmp = gradeList.get(target);
			return new int[]{
					aGrade_tmp.getLab1(), aGrade_tmp.getLab2(), 
					aGrade_tmp.getLab3(), aGrade_tmp.getMidTerm(),
					aGrade_tmp.getFinalExam(), aGrade_tmp.getTotalGrade()};
		}
		System.out.println("!!");
		return null;	
	}
	/* method  getRank  ----------------------------------------------------------------------------------                                                                                                    
	* use Id to get the corresponding rank
	*
	* @param Id 	Id for looking for the infomation
	* @return int    if id doesn't exist, return -1
	* 				otherwise, return the rank;
	* 				  
	*
	* @throws NoSuchIDExceptions ¡V 
	*			
	*Pseudo code:
	*1.use Id to look for the infomation in gradeList
    *2.if Id exist print out the info and return true
	*  else return false
	*  
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/

	public int getRank(int id){
		int target;
		if((target =  containsID(id)) != -1)
			return gradeList.get(target).getRank();
		return -1;
	}
	/* method  getAverage  ----------------------------------------------------------------------------------                                                                                                    
	* 	get the corresponding avg score
	*
	* @param no
	* @return String   one string contains all average grade
	* 
	* @throws NoSuchIDExceptions ¡V 
	*			
	*Pseudo code:
	*1. return every average
	*  
	* Time estimate : 
	* Example: 
	* 
	* Last modified: 2016/3/23 23:13
	*
	----------------------------------------------------------------------------------------------------------*/

	int[] getAverage(){
		
		return new int[]{lab1_avg, lab2_avg, lab3_avg, midTerm_avg, finalExam_avg};
	}
	/* method  recalculate ----------------------------------------------------------------------------------                                                                                                    
	* recalculate the scores such as the avg score,ranking..etc.
	*
	* @param none
	* @return void
	*
	* @throws void
	*
	*Pseudo code:
	*1.use the info in gradeList to recalculate the avg scores and the rankings.
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/

	private void recalculate(){
		//calculating the avg;
		
		calculateAverage();
		resetAllTotalGrades();
		sortGrades();
		setRank();
	}
	
	private void calculateAverage(){
		for(int i=0; i<idNum; i++){
			lab1_avg += gradeList.get(i).getLab1();
			lab2_avg += gradeList.get(i).getLab2();
			lab3_avg += gradeList.get(i).getLab3();
			midTerm_avg += gradeList.get(i).getMidTerm();
			finalExam_avg += gradeList.get(i).getFinalExam();
		}
		lab1_avg /=idNum;
		lab2_avg /=idNum;
		lab3_avg /=idNum;
		midTerm_avg /=idNum;
		finalExam_avg /=idNum;	
	}
	
	
	
	/* method  resetAllTotalGrades ----------------------------------------------------------------------------------                                                                                                    
	* recalculate all the totalGrades.
	*
	* @param none
	* @return void
	*
	* @throws void
	*
	*Pseudo code:
	*1.use the info in gradeList and weight_set to recalculate the total grades.
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	
	private void resetAllTotalGrades(){
		for(int i=0; i<idNum; i++){
			gradeList.get(i).setTotalGrade(
					(int) ((float)gradeList.get(i).getLab1()*weight_set[0]/100)+
					(int) ((float)gradeList.get(i).getLab2()*weight_set[1]/100)+
					(int) ((float)gradeList.get(i).getLab3()*weight_set[2]/100)+
					(int) ((float)gradeList.get(i).getMidTerm()*weight_set[3]/100)+
					(int) ((float)gradeList.get(i).getFinalExam()*weight_set[4]/100));
		}
		
	}
	/* method  sortGrades ----------------------------------------------------------------------------------                                                                                                    
	* use Collections.sort to sort gradeList
	*
	* @param none
	* @return void
	*
	* @throws void
	*
	*Pseudo code:
	*1.pick the total grades in gradeList and sort them by Collection.sort
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	private void sortGrades(){
		Collections.sort(gradeList, new Comparator<aGrade>() {
		    public int compare(aGrade o1,aGrade o2) {
		        return  ((aGrade) o2).getTotalGrade() -((aGrade) o1).getTotalGrade();
		    }
		});
	}
	/* method  setRank ----------------------------------------------------------------------------------                                                                                                    
	* rank all the people by their totalgrade
	*
	* @param none
	* @return void
	*
	* @throws void
	*
	*Pseudo code:
	*1.rank them by the info in gradeList
	*2.people with the same totalGrade should have the same rank
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	private void setRank(){
		int currentGrade=0,rank=1;
		for(int i=0;i<idNum;i++){
			if (gradeList.get(i).getTotalGrade() == currentGrade){
				gradeList.get(i).setRank(rank);	
			}
			else{
				rank = i+1;
				gradeList.get(i).setRank(rank);
				currentGrade=gradeList.get(i).getTotalGrade();
			}
		}
	}


	/* method  getWeight ----------------------------------------------------------------------------------                                                                                                    
	* return the weight_set
	*
	* @param none
	* @return weight_set 
	*
	* @throws void
	*
	*Pseudo code:
	*1.return weight_set
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public static int[] getWeight(){
		return weight_set;
	}
	/* method  setWeight ----------------------------------------------------------------------------------                                                                                                    
	* reset the weight_set
	*
	* @param int[] newWeight 
	* @return void 
	*
	* @throws void
	*
	*Pseudo code:
	*1.set the newWeight to weight_set
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public void setWeight(int[] newWeight){
		for(int i=0; i<5; i++)
			weight_set[i] = newWeight[i];
		recalculate();
	}
	
	/* method  containsID ----------------------------------------------------------------------------------                                                                                                    
	* to know is the ID in the gradeList
	*
	* @param int ID
	* @return int 
	* 				return  -1 if the id isn't exist
	* 				otherwise, return the index of the id in the gradeList
	*
	* @throws void
	*
	*Pseudo code:
	*1.check if the id is in gradeList 
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int containsID(int ID){
		for(int i=0; i<idNum; i++)
			if(gradeList.get(i).getId() == ID)
				return i;
		
		return -1;
	}
	/* method getName ----------------------------------------------------------------------------------                                                                                                    
	* to know the name with the id
	*
	* @param int Id 
	* @return int 
	* 				return  null if the id isn't exist
	* 				otherwise, return the name
	*
	* @throws void
	*
	*Pseudo code:
	*1.check if the id is in gradeList  then return the name from gradelist
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public String getName(int id){
		int target = containsID(id);
		if(target != -1)
			return gradeList.get(target).getName();
		return null;
		
	}
	
	
}
