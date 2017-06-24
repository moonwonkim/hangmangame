package moonwonkim; //2016125006
import java.io.*;
import java.util.*;
//행맨게임 만들기
//예외처리 - 공백,중복
//출력 - 랜덤단어, 교수대 그림
// 추가하고 싶은점 - 단어주제를 선택해서 뽑기, 플레이어 수를 두기
// 6/24 Hangman 생성자내에 단어를 선택하는 WordSelection을 추가하였다.
public class Hangman{
	int remain; // 남은 문자열
	int fail; //실패 횟수
	String hidden; //숨겨진 문자열
	//StringBuffer은 가변의 속성을 가짐 StringBuilder와 다르게 동기화보장
	StringBuffer output; //출력 문자열
	StringBuffer input; //입력 문자열
	//IOException = 입출력 예외처리
	public Hangman() throws IOException{ //생성자에 단어를 선택하는것을 넣엇다
		WordSelection ws = new WordSelection();
		hidden = ws.selection();
	} //행맨 생성자 
	
	
	public char readString() throws IOException{ //입력받은 문자열의 첫번째를 반환
		//BufferedReader는 readLine을 통한 문장별로 읽어줌 
		//InputStreamReader는 바이트스트림을 문자스트림으로 읽어줌
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String user;
		
		System.out.println("문자를 입력해주세요: ");
		user = in.readLine();
		if(user.length()==0){
			System.out.println("null을 입력하셨습니다\n시도회수:-1 ");
			return 0;
		}
		return user.charAt(0);
	}

	
	public void CheckString(char userInput){ //입력받은 문자열 체크 userInput는 사용자 입력
		boolean already = false; //already는 이미 입력한 문자열
		for (int i = 0; i < input.length(); i++){
			//charAt(index) = index에있는 문자 출력
			if (input.charAt(i) == userInput){ // 사용자가 똑같은 문자열을 입력했을경우 fail에서 차감 x
				System.out.println("\n중복된 문자입니다. \nTry Again~");
				already = true; //already를 true값으로
			}
		}
		if (!already){
			input.append(userInput); //입력된 문자열에 추가
			
			boolean correct = false; //correct는 맞춘 문자열
			for(int i = 0; i < hidden.length(); i++){
				if(hidden.charAt(i) == userInput){ //문제의 문자열에 있는 문자열인지 비교
					//setCharAt(a,b) a에 b를 넣는다는 개념
					output.setCharAt(i,userInput); //해당하는 문자열이 있는경우 '-'를 입력한 문자로 변경
					remain--; //남아있는 문자수 감소
					correct = true; //입력한 문자가 문제에 있을경우 true 반환
				}
			}
			if(!correct){ //입력된 문자가 없을경우 실패횟수 1회씩 증가
				fail++;
			}
		}
	}
	
	public int playGame() throws IOException{ //행맨게임시작
		
		output = new StringBuffer();
		
		for (int i = 0; i < hidden.length(); i++){
			output.append('-'); //문자열의 길이만큼 '-'로 출력한다
		}
		input = new StringBuffer();
		
		remain = hidden.length(); //남아있는 맞출 문제의 문자수
		fail = 0;
		
		System.out.println("단어 " + hidden.length() + "글자 \n"
				+ "[" + output + "]");
		System.out.println("시도가능한 횟수: " + (6-fail) +"입니다"); 
		
		drawPicture(); //그림 그리기
		do{
			CheckString(readString());
			System.out.println("단어 " + hidden.length() + "글자 \n"
					+"[" + output + "]");
			System.out.println("시도가능한 횟수: " + (6-fail) +"번 입니다"); 
			if((6-fail) == 1){
				System.out.println("마지막 기회입니다 신중하세요!"); 
			}
			
			drawPicture(); //틀린 횟수에 따른 그림 출력
		}while((remain > 0) && (fail < 6)); //실패기회는 6번 
		
		return fail;
	}
	

	
	
	
	public void drawPicture(){
		System.out.println("   \n\n   ");
		System.out.println("   |----------------|   ");
	
		switch(fail){ //실패 횟수만큼 그림그리기
		
		case 0:
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("   \n  ");
			break;	
			
		case 1:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 2:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 3:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	

		case 4:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("          |   |");
			System.out.println("            |  ");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 5:
			System.out.println("            |  ");
			System.out.println("            ○  ");
			System.out.println("          -----  ");
			System.out.println("          |   |  ");
			System.out.println("            |  ");
			System.out.println("          |   |");
			System.out.println("       ===========  ");
			System.out.println("   \n  ");
			break;	
		case 6:
			System.out.println("           X-X  ");
			System.out.println("       ===========  ");
			System.out.println("| -------You are DIE ----- |  ");
			break;
		}
	}

	
}