package sw_all;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main_Todolist {
		static Scanner scanner = new Scanner(System.in);
		public static int listIndex = 0;
		public static newTodolist [] todolists= new newTodolist[100];	
		
		static class newTodolist{
			private String createDate;
			private String dueDate;
			private String title;
			private String[] description;
			private String remainingTime;
			
			public newTodolist(String createDate, String dueDate, String title, String[] description, String remainingTime) {
				this.createDate = createDate;
				this.dueDate = dueDate;
				this.title = title;
				this.description = description;
				this.remainingTime = remainingTime;
			}
			
			private void showDescription() {
				for(int i=0; i<this.description.length; i++) {
					System.out.println(description[i]);
				}
			}
		}
		
		static void CreateTodolist() {
			String createDate = GetCurrentDate();
			
			System.out.println("������ todolist�� ������ �Է����ּ���: ");
			String title = scanner.next();
			
			System.out.println("������ todolist�� ������ �Է����ּ���\n(�Է��� �����ϰ� �����ø� ������ �� ������ �ٿ� �׸��̶�� ���� enter�� �����ּ���)");
			String description[] = SaveDescription();
			
			System.out.println("������ todolist�� ���� ��¥�� �Է����ּ���(�⵵ �� �� �� ��): ");
			String dueDate = scanner.nextLine();
			
			String remainingTime = CalculateRemainingTime(createDate, dueDate);
			
			todolists[listIndex++]= new newTodolist(createDate, dueDate, title, description, remainingTime);
		}


		static String GetCurrentDate() {
			GregorianCalendar today = new GregorianCalendar();
			int year = today.get(today.YEAR);
			int month = today.get(today.MONTH) + 1;
			int day = today.get(today.DATE);
			int hour = today.get(today.HOUR_OF_DAY);
			int minute = today.get(today.MINUTE);
			String createDate = year + " " + month + " " + day + " " + hour + " " + minute;
			return createDate;
		}
		
		
		static String[] SaveDescription() {
			String lines[] = new String[100];
			String line="";
			int n=0;
			while(!(line = scanner.nextLine()).equals("�׸�")) 
				lines[n++]=line;
			
			return lines;
		}
		
		
		static String CalculateRemainingTime(String createDate, String dueDate) {
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
					if (remainDays != 0) {
						remainHours = (remain % remainDays) / 60*60*1000;
						if (remainHours != 0) {
							remainMinutes = (remainDays % remainHours) / 60*1000;
						}
					}	
				}	
				remainingTime = "�������� " + remainDays + "�� " + remainHours + "�ð� " + remainMinutes + "�� ���ҽ��ϴ�.";
			}
			catch(ParseException e) {
				System.out.println(e);
			}
			return remainingTime;
		}
		
		
		static void ViewTodolistsFull() {
			System.out.println("--------Todolist ��ü ���---------");
			for(int i=0; i<todolists.length; i++) {
				System.out.print("����: ");
				System.out.println(todolists[i].title);
				System.out.print("����: ");
				todolists[i].showDescription();
				System.out.print("\n���� ��¥: ");
				System.out.println(todolists[i].createDate);
				System.out.print("���� ��¥: ");
				System.out.println(todolists[i].dueDate);
				System.out.print("���� �Ⱓ: ");
				System.out.println(todolists[i].remainingTime);
				System.out.print("\n\n");
				}
			}
		
		
		static void ViewTodolistsTitle() {
			System.out.println("--------Todolists---------");
			for(int i=0; i<todolists.length; i++) {
				System.out.print("����: ");
				System.out.println(todolists[i].title); }
		}
		
		
		static void ViewDetails(String title) {
			int searchResult = SearchTodolist(title);
			System.out.print("����: ");
			System.out.println(todolists[searchResult].title);
			System.out.print("����: ");
			todolists[searchResult].showDescription();
			System.out.print("\n���� ��¥: ");
			System.out.println(todolists[searchResult].createDate);
			System.out.print("���� ��¥: ");
			System.out.println(todolists[searchResult].dueDate);
			System.out.print("���� �Ⱓ: ");
			System.out.println(todolists[searchResult].remainingTime);
			System.out.print("-----------------------------");
		}
		
		static int SearchTodolist(String title) {
			if (todolists.length == 0) 
				return 0;
			else {
				for(int i=0; i<todolists.length; i++) 
					if (todolists[i].equals(title))
						return i;
				
				return -1;
			}
		}
		
		
		static void UpdateTodolist() {
			
		}
		
		
		static void DeleteTodolist() {
			
		}
		
		
		public static void main(String args[]) {
			int menuNum=0;
			
			while(menuNum!=5) {
				System.out.println("\n1��: Todolist �����ϱ�\n2��: Todolist ����"
						+ "\n3��: Todolist �����ϱ�\n4��: Todolist �����ϱ�\n5��: ���� �޴��� �̵�");
				System.out.print("���Ͻô� ��ɿ� �ش��ϴ� ���ڸ� �Է����ּ���: ");
				menuNum = scanner.nextInt();
				
				switch(menuNum) {
				case 1:
					CreateTodolist();
					break;
				case 2:
					ViewTodolistsFull();
					break;
				case 3:
					UpdateTodolist();
					break;
				case 4:
					DeleteTodolist();
					break;
				case 5:
					System.out.println("Todolist ����� �����մϴ�.");
					break;
				}
			}
		}
	}
