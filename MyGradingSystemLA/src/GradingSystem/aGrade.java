package GradingSystem;

public class aGrade {
	
	public int Id;
	public String name; 
	public int lab1, lab2, lab3, midTerm, finalExam,totalGrade; 
	public int rank;
	/* method  aGrade ----------------------------------------------------------------------------------                                                                                                    
	* save the input and calculate totalGrade
	*
	* @param int Id,String name,int lab1,int lab2,int lab3,int midTerm,int finalExam
	* @return void 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.save the inputs by variables
	*2.calculate totalGrade
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public aGrade(int Id,String name,int lab1,int lab2,int lab3,int midTerm,int finalExam){
		this.Id=Id;
		this.name=name;
		this.lab1=lab1;
		this.lab2=lab2;
		this.lab3=lab3;
		this.midTerm=midTerm;
		this.finalExam=finalExam;
		int[] weight_set = Grades.getWeight();
		totalGrade = (int) ((float)lab1*weight_set[0]/100)+
					+(int) ((float)lab2*weight_set[1]/100)
					+(int) ((float)lab3*weight_set[2]/100)
					+(int) ((float)midTerm*weight_set[3]/100)
					+(int) ((float)finalExam*weight_set[4]/100);
	}
	
	/* method  getId ----------------------------------------------------------------------------------                                                                                                    
	* get the id saved in the global variable. 
	*
	* @param none
	* @return Id 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return Id
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getId(){
		return Id;
	}
	
	/* method  getName ----------------------------------------------------------------------------------                                                                                                    
	* get the Name saved in the global variable. 
	*
	* @param none
	* @return name 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return name 
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public String getName(){
		
		return name;
	}
	/* method  getLab1 ----------------------------------------------------------------------------------                                                                                                    
	* get the lab1 score saved in the global variable. 
	*
	* @param none
	* @return lab1 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return lab1
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getLab1(){
		return lab1;
	}
	
	/* method  getLab2 ----------------------------------------------------------------------------------                                                                                                    
	* get the lab2 score saved in the global variable. 
	*
	* @param none
	* @return lab2 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return lab2
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getLab2(){
		
		return lab2;
	}
	/* method  getLab3 ----------------------------------------------------------------------------------                                                                                                    
	* get the lab3 score saved in the global variable. 
	*
	* @param none
	* @return lab3 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return lab3
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getLab3(){
		
		return lab3;
	}
	/* method  getMidterm ----------------------------------------------------------------------------------                                                                                                    
	* get the Midterm score saved in the global variable. 
	*
	* @param none
	* @return midterm 
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return midterm
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getMidTerm(){
		return midTerm;
	}
	/* method  getFinalExam ----------------------------------------------------------------------------------                                                                                                    
	* get the FinalExam score saved in the global variable. 
	*
	* @param none
	* @return finalExam
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return finalExam
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getFinalExam(){
		return finalExam;
	}
	
	/* method  getRank ----------------------------------------------------------------------------------                                                                                                    
	* get the rank saved in the global variable. 
	*
	* @param none
	* @return rank
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return rank
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getRank(){
		return rank;
	}
	/* method  geTotalGrade ----------------------------------------------------------------------------------                                                                                                    
	* get the TotalGrade saved in the global variable. 
	*
	* @param none
	* @return totalGrade
	*
	* @throws 
	* 
	*Pseudo code:
	*1.return totalGrade
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public int getTotalGrade(){
		return totalGrade;
	}
	
	/* method  setTotalRank----------------------------------------------------------------------------------                                                                                                    
	* set the new totalRank by giving an input 
	*
	* @param totalRank
	* @return void
	*
	* @throws 
	* 
	*Pseudo code:
	*1.set totalRank to new value
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public void setRank(int rank){
		this.rank = rank;
	}
	/* method  setTotalGrade----------------------------------------------------------------------------------                                                                                                    
	* set the new totalGrage by giving an input 
	*
	* @param totalGrade
	* @return void
	*
	* @throws 
	* 
	*Pseudo code:
	*1.set totalGrade to new value
    *
	* Time estimate : 
	* Example: 
	----------------------------------------------------------------------------------------------------------*/
	public void setTotalGrade(int totalGrade){
		this.totalGrade = totalGrade;
	}


}
