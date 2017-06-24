package moonwonkim;
import java.io.*;
import java.util.*;

public class WordSelection{
	public WordSelection(){}
	
	public String selection(){ //단어선택하기
		
		System.out.println("단어 주제를 선택하시오: [1.과일  2.음식 3.채소]");
		Scanner sc = new Scanner(System.in);
		int num;
		while(true){
			num = sc.nextInt();
			if(num == 1){
				System.out.println("선택하신 주제는 과일입니다~");
				Random A = new Random();
				int Fruit = A.nextInt(10); //10개의 과일중 랜덤으로 뽑는다.
				if(Fruit == 0){
					return "apple";
				} else if (Fruit == 1){
					return "banana";
				} else if (Fruit == 2){
					return "pineapple";
				} else if (Fruit == 3){
					return "manggo";
				} else if (Fruit == 4){
					return "watermelon";
				}else if (Fruit == 5){
					return "melon";
				}else if (Fruit == 6){
					return "strawberry";
				}else if (Fruit == 7){
					return "grape";
				}else if (Fruit == 8){
					return "lemon";
				}else if (Fruit == 9){
					return "tomato";
				}
			}else if(num == 2){
				System.out.println("선택하신 주제는 음식입니다~");
				Random B = new Random();
				int Food = B.nextInt(10); //10개의 음식중 랜덤으로 뽑는다.
				if(Food == 0){
					return "pizza";
				}else if(Food == 1){
					return "chicken";
				}else if(Food == 2){
					return "hambugger";
				}else if(Food == 3){
					return "potato";
				}else if(Food == 4){
					return "ramen";
				}else if(Food == 5){
					return "sausage";
				}else if(Food == 6){
					return "pasta";
				}else if(Food == 7){
					return "taco";
				}else if(Food == 8){
					return "cake";
				}else if(Food == 9){
					return "cheese";
				}
			}else if(num == 3){
				System.out.println("선택하신 주제는 채소입니다~");
				Random C = new Random();
				int Vegetable = C.nextInt(5); //5개의 채소중 랜덤으로 뽑는다.
				if(Vegetable == 0){
					return "cabbage";
				}else if(Vegetable == 1){
					return "lettuce";
				}else if(Vegetable == 2){
					return "cucumber";
				}else if(Vegetable == 3){
					return "pepper";
				}else if(Vegetable == 4){
					return "bean";
				}
			}else{
				System.out.println("Error Input!!");
				continue;
			}
		}
	}
}
	
	

