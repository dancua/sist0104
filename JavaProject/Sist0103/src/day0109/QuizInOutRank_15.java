package day0109;

public class QuizInOutRank_15 {
   
   public static void main(String [] args) {
      String [] name = {"홍길동","이길동","삼길동","사길동"};
      int [] kor = {90,100,100,78};
      int [] eng = {100,55,100,78};
      int [] mat = {44,55,100,66};
      int [] tot = new int[4];
      double [] avg = new double[4];
      int [] rank = new int[4];
      
      //계산
      for(int i = 0; i < name.length; i++)
      {
    	  tot[i] = kor[i] + eng[i] + mat[i];
    	  avg[i] = tot[i]/3.0;
    	  
    	  rank[i] = 1;
      }
      for(int i = 0; i < name.length; i++) {
    	  for(int j = 0; j < name.length; j++) {
    		  if(tot[i] < tot[j])
    			  rank[i]++;
    	  }
    	  
      }
        
      // 1. 총점 평균 ..배열
      //등수
      for(int i =0; i<name.length; i++)
      {
         rank[i] = 1;
         
         for(int j =0; j<name.length; j++)
         {
            //비교되는 대상이 점수가 더 높으면 i번지의 등수를 1증가시킨다
            if(tot[i]<tot[j])
               rank[i]++;
         }
      }
      //출력
      System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등수");
      System.out.println("=================================================================");
      for(int i = 0; i < name.length; i++) {
         System.out.println((i+1)+"\t"+name[i]+"\t"+kor[i]+ "\t" + eng[i] + "\t" + mat[i] + "\t" + tot[i] + "\t" + avg[i] + "\t" + rank[i] );
   }
   /*
    * 각 학생들의 점수에 대한 총점 평균 등수를 구하여 출력
    * 
    * 번호    이름      국어      영어      수학      총점      평균      등수   
    * ==========================================================
    * 1   이름      90      100      44                        
    * 
    */   
   }
}