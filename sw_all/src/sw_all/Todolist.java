package sw_all;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Todolist {
	static Scanner scanner = new Scanner(System.in);
	public static int listIndex = 1;
	public static int searchResult=0;
	//public static boolean titleOverlap=true;
	public static newTodolist [] todolists= new newTodolist[100];	
	static class newTodolist{
		private String createDate;
		private String dueDate;
		private String title;
		private List<Object> descriptions;
		private String remainingTime;
		
		public newTodolist(String createDate, String dueDate, String title, List<Object> descriptions, String remainingTime) {
			this.createDate = createDate;
			this.dueDate = dueDate;
			this.title = title;
			this.descriptions = descriptions;
			this.remainingTime = remainingTime;
		}
		
		private void showDescription() {
			for(int i=0; i<this.descriptions.size(); i++) {
				System.out.println(descriptions.get(i));
			}
		}
		
	}
	
	
	static int menuNum;
	public static void main(String args[]) {
		menuNum=0;
		
		while(menuNum!=5) {
			System.out.println("\n1��: Todolist �����ϱ�\n2��: Todolist ����"	+ "\n3��: Todolist �����ϱ�\n4��: Todolist �����ϱ�\n5��: ���� �޴��� �̵�");
			System.out.print("���Ͻô� ��ɿ� �ش��ϴ� ���ڸ� �Է����ּ���: ");
			menuNum = scanner.nextInt();
			
			switch(menuNum) {
			case 1:
				createTodolist();
				break;
			case 2:
				viewTodolistsFull();
				break;
			case 3:
				updateTodolist();
				break;
			case 4:
				deleteTodolist();
				break;
			case 5:
				back();
				break;
			}
		}
	}
	
	
	static void createTodolist() {
		String createDate = getCurrentDate();
		System.out.println("������ todolist�� ������ �Է����ּ���.");
		String title = saveandcheckTitleOverlap();
		System.out.println("������ todolist�� ������ �Է����ּ���.\n(�Է��� �����ϰ� �����ø� ������ �� ������ �ٿ� �׸��̶�� ���� enter Ű�� �����ּ���)");
		List<Object> descriptions = saveDescriptions();
		System.out.println("������ todolist�� ���� ��¥�� �Է����ּ���.\n(yyyy MM dd hh mm ��������): ");
		String dueDate = scanner.nextLine();
		String remainingTime = calculateRemainingTime(createDate, dueDate);
		
		todolists[listIndex++]= new newTodolist(createDate, dueDate, title, descriptions, remainingTime);
	}
	

	static String getCurrentDate() {
		GregorianCalendar today = new GregorianCalendar();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DATE);
		int hour = today.get(Calendar.HOUR_OF_DAY);
		int minute = today.get(Calendar.MINUTE);
		String createDate = year + " " + month + " " + day + " " + hour + " " + minute;
		return createDate;
	}
	
	
	static List<Object> saveDescriptions() {
		List<Object> lines = new ArrayList<Object>();
		Object line;
		while(!(line = scanner.nextLine()).equals("�׸�")) 
			lines.add(line);
		return lines;
	}
	
	
	static String calculateRemainingTime(String createDate, String dueDate) {
		long remainDays = 0;
		long remainHours = 0;
		long remainMinutes = 0;
		String remainingTime="";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd hh mm");
			Date create = format.parse(createDate);
			Date due = format.parse(dueDate);
			long remain = due.getTime() - create.getTime();
			if (remain != 0) {
				remainDays = remain / (24*60*60*1000);
				remainHours = (remain - remainDays*24*60*60*1000) / (60*60*1000);
				remainMinutes = (remain - remainDays*24*60*60*1000 - remainHours*60*60*1000) / (60*1000);	
			}
			remainingTime = "�������� " + remainDays + "�� " + remainHours + "�ð� " + remainMinutes + "�� ���ҽ��ϴ�.";
			}
		catch(ParseException e) { System.out.println(e);  }
		return remainingTime;
	}

	
	static String saveandcheckTitleOverlap() {
		String title = scanner.next();
		if(listIndex>1) {
			boolean titleOverlap=checkTitleOverlap(title);
			while(titleOverlap) {
				title=scanner.next();
				titleOverlap=checkTitleOverlap(title);
			}
		}
		return title;
	}
	
	 static boolean checkTitleOverlap(String title) {
		searchTodolist(title);
		if (searchResult < 1) {
			return false;
		}
		else {
			System.out.println("���� �Է��Ͻ� title�� �̹� �ִ� title�Դϴ�. �ٽ� �Է����ּ���.");
			return true;
		}
	}
	
	static void viewTodolistsFull() {
		if (listIndex==1)
			System.out.println("���� ������ todolist�� �����ϴ�. todolist�� ���� �������ּ���");
		else {
			System.out.println("=========Todolist ��ü ���=========");
			for(int index=1; index<listIndex; index++) {
				viewTodolistDetails(index);
				System.out.print("\n");
				}
		}
	}
	
	
	static void viewTodolistsTitle() {
		System.out.println("=========Todolists=========");
		for(int i=1; i<listIndex; i++) {
			System.out.print("����: ");
			System.out.println(todolists[i].title); }
		System.out.println("===========================");
	}
	
	
	static void viewTodolistDetails(int index) {
		System.out.print("����: ");
		System.out.println(todolists[index].title);
		System.out.print("����: ");
		todolists[index].showDescription();
		System.out.print("���� ��¥: ");
		System.out.println(todolists[index].createDate);
		System.out.print("���� ��¥: ");
		System.out.println(todolists[index].dueDate);
		System.out.print("���� �Ⱓ: ");
		System.out.println(todolists[index].remainingTime);
		System.out.println("----------------------------------------------------------");
	}

	
	static void updateTodolist() {
		if (listIndex==1) {
			System.out.println("���� ������ todolist�� �����ϴ�. todolist�� ���� �������ּ���");
		}
		else {
			viewTodolistsTitle();
			System.out.print("���� ��Ͽ��� �����ϰ� ���� todolist�� ������ �Է����ּ��� : ");
			scanner.nextLine();
			String title = scanner.nextLine();
			searchTodolist(title);
			if (searchResult<=0) {
				System.out.println("�Է��Ͻ� ���� �ش��ϴ� todolist�� �����ϴ�. ������ �����մϴ�.");
				return;
			}
			viewTodolistDetails(searchResult);
			System.out.print("�����ϰ� ���� �׸��� �Է����ּ��� : ");
			String DetailToUpdate = scanner.nextLine();
			dealUpdateDetails(searchResult, DetailToUpdate);
		}
	}
	
	
	static void searchTodolist(String title) {
		for(int i=1; i<listIndex; i++) {
			if (todolists[i].title.equals(title)) {
				searchResult=i;
				return;
				}
		}
		searchResult=-1;
	}
	
	
	static void dealUpdateDetails(int searchResult, String DetailToUpdate) {
		if(DetailToUpdate.equals("����")) {
			System.out.print("�����ϰ� ���� ������ �Է����ּ��� : ");
			todolists[searchResult].title = scanner.nextLine();
			}
		else if(DetailToUpdate.equals("����")) {
			System.out.print("�����ϰ� ���� ������ �Է����ּ��� : ");
			System.out.println("(�Է��� �����ϰ� �����ø� ������ �� ������ �ٿ� �׸��̶�� ���� enter Ű�� �����ּ���)");
			todolists[searchResult].descriptions = saveDescriptions();
		}
		else if(DetailToUpdate.equals("���� ��¥")) {
			System.out.print("�����ϰ� ���� ������ �Է����ּ��� : ");
			System.out.println("\n(yyyy MM dd hh mm �������� �Է����ּ���)");
			todolists[searchResult].createDate = scanner.nextLine();
			todolists[searchResult].remainingTime = calculateRemainingTime(todolists[searchResult].createDate, todolists[searchResult].dueDate);
		}
		else if(DetailToUpdate.equals("���� ��¥")) {
			System.out.print("�����ϰ� ���� ������ �Է����ּ��� : ");
			System.out.println("\n(yyyy MM dd hh mm �������� �Է����ּ���)");
			todolists[searchResult].dueDate = scanner.nextLine();
			todolists[searchResult].remainingTime = calculateRemainingTime(todolists[searchResult].createDate, todolists[searchResult].dueDate);
		}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ������ �����մϴ�.");
			return;
		}
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}
	

	static void deleteTodolist() {
		if (listIndex==1) 
			System.out.println("���� ������ todolist�� �����ϴ�. todolist�� ���� �������ּ���");
		
		else {
			viewTodolistsTitle();
			System.out.print("���� ��Ͽ��� �����ϰ� ���� todolist�� ������ �Է����ּ��� : ");
			scanner.nextLine();
			String title = scanner.nextLine();
			searchTodolist(title);
			if (searchResult==-1)
				return;
			viewTodolistDetails(searchResult);
			System.out.println("�� todolist�� ������ �����Ͻðڽ��ϱ�? (y/n)");
			String answer = scanner.nextLine();
			if(answer.equals("y")) {
				for(int i=searchResult; i<listIndex; i++) {
					todolists[i]=todolists[i+1];
				}
				listIndex--;
			}
			else {
				System.out.println("���� �۾��� ����ϰ� Todolist����� �������� ���ư��ϴ�.");
				return;
				}
		}
	}
	
	
	static void back() {
		System.out.println("������ Todolist ����� �����Ͻðڽ��ϱ�? (y/n)");
		String answer = scanner.next();
		if (answer.equals("y"))
			System.out.println("Todolist ����� �����մϴ�.");
		else {
			System.out.println("Todolist�� �������� ���ư��ϴ�.");
			menuNum=0;
		}
	}
}
