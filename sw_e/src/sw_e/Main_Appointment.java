package sw_e;

import java.util.Scanner;
public class Main_Appointment {
	static Scanner scanner = new Scanner(System.in);
	static class appointment{
		String title;
		int date[] = new int[5];
		String persons;
		String location;
		public appointment() {
		}
	}
	
	static int number = 0;
	static appointment ap[] = new appointment[100];
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		int a = 0;
			while (a != 5 ) {
				System.out.println("\n1�� : Create\n2�� : View\n3�� : Update\n4�� : Delete\n5�� : ���� �޴��� �̵�");
				System.out.print("���Ͻô� ����� ���ڷ� �Է����ּ��� : ");
					a = scanner.nextInt();
				
				switch(a) {
				case 1:
					create();
					break;
				case 2:
					view();
					break;
				case 3:
					update();
					break;
				case 4:
					delete();
					break;
				case 5:
					System.out.println("Appointment ����� �����մϴ�.");
					break;
				default:
					System.out.print("�߸��� ���ڸ� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
					break;
				}
			}
		//scanner.close();
	}
	
	public static void create() {
		//Scanner scanner = new Scanner(System.in);
		ap[number] = new appointment();
		
		System.out.print("Appointment�� Title�� �Է��ϼ���(�ɼ� �������� ���ư����� back�� �Է��ϼ���): ");
		scanner.nextLine();
		String title = scanner.nextLine();
		if(!(title.equals("back"))) {
			ap[number].title = title;
			System.out.print("Appointment�� Date�� �Է��ϼ���(2019�� 01�� 23�� 17�� 23���� ��� 2019 01 23 17 23�� ����) : ");
			int date = scanner.nextInt();
			ap[number].date[0] = date;
			date = scanner.nextInt();
			ap[number].date[1] = date;
			date = scanner.nextInt();
			ap[number].date[2] = date; 
			date = scanner.nextInt();
			ap[number].date[3] = date;
			date = scanner.nextInt();
			ap[number].date[4] = date;
			System.out.print("Appointment�� ������ �Բ��ϴ��� �Է��ϼ��� : ");
			scanner.nextLine();
			String persons = scanner.nextLine();
			ap[number].persons =persons;
			System.out.print("Appointment�� ����� �Է��ϼ��� : ");
			String  location = scanner.nextLine();
			ap[number].location = location;
			System.out.println(ap[number].title + " appointment�� ���������� ����Ǿ����ϴ�.");
			number++;
		}	
	}
	public static void view() {
		if (number == 0)
			System.out.println("Appointment�� �������� �ʽ��ϴ�.");
		else {
			System.out.println("\nAppointment�� ����Ʈ �Դϴ�.");
			for(int i = 0;  i < number; i++) {
				System.out.println(i+1 + "�� : " + ap[i].title);
				System.out.println("Date : "+ap[i].date[0] + "�� "+ap[i].date[1] + "�� "+ap[i].date[2] + "�� "+ap[i].date[3] + "�� " +ap[i].date[4] + "��");
				System.out.println("persons : " + ap[i].persons);
				System.out.println("location : " + ap[i].location);
				System.out.println("\n");
			}
		}
	}

	public static void update() {
		//Scanner scanner = new Scanner(System.in);
		int count = -1;
		int answer = 0;
		while(count == -1) {
			System.out.print("�����ϰ� ���� Appointment�� title�� �Է��ϼ���(�ɼ� �������� ���ư����� back�� �Է��ϼ���) : ");
			scanner.nextLine();
			String title = scanner.nextLine();
			if(title.equals("back"))
				break;
			for(count = 0; count < number; count++) {
				if(ap[count].title.equals(title)) {
					while(answer != 1 && answer != 2 && answer != 3 && answer != 4) {
						System.out.print("�����ϰ� ���� �׸��� �Է��ϼ���.(1:title, 2:date, 3: persons, 4:location) : ");
						answer = scanner.nextInt();
						switch(answer) {
						case 1:
							System.out.print("title�� �����մϴ�. ������ �Է��ϼ��� : ");
							scanner.nextLine();
							String ans = scanner.nextLine();
							ap[count].title = ans;
							break;
						case 2:
							System.out.print("date�� �����մϴ�. ������ �Է��ϼ���(2019�� 01�� 23�� 17�� 23���� ��� 2019 01 23 17 23�� ����) : ");
							int date = scanner.nextInt();
							ap[count].date[0] = date;
							date = scanner.nextInt();
							ap[count].date[1] = date;
							date = scanner.nextInt();
							ap[count].date[2] = date; 
							date = scanner.nextInt();
							ap[count].date[3] = date;
							date = scanner.nextInt();
							ap[count].date[4] = date;
							break;
						case 3:
							System.out.print("persons��  �����մϴ�. ������ �Է��ϼ��� : ");
							scanner.nextLine();
							String ans2 = scanner.nextLine();
							ap[count].persons = ans2;
							break;
						case 4:
							System.out.print("location�� �����մϴ�. ������ �Է��ϼ��� : ");
							scanner.nextLine();
							String ans3 = scanner.nextLine();
							ap[count].location = ans3;
							break;
						default:
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
							break;
						}
					}
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					break;
				}
			}
			if(number == count) {
				System.out.println("���� title�Դϴ�. �ٽ� �Է��ϼ��� : ");
				count = -1;
			}
		}		
	}
	public static void delete() {
		//Scanner scanner = new Scanner(System.in);
		int count = -1;
		int lastdelete = 0;
		while(count == -1) {
			System.out.print("�����ϰ� ���� Appointment�� title�� �Է��ϼ���(�ɼ� �������� ���ư����� back�� �Է��ϼ���) : ");
			scanner.nextLine();
			String title = scanner.nextLine();
			if(title.equals("back"))
				break;
			for(count = 0; count < number; count++) {
				if(ap[count].title.equals(title)) {
					for(int i = count; i<number - 1; i++)
						ap[count] = ap[count + 1];
					number--;
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
					lastdelete = 1;
					break;
				}
			}
			if(number == count && lastdelete != 1) {
				System.out.println("���� title�Դϴ�. �ٽ� �Է��ϼ��� : ");
				count = -1;
			}
		}		
	}

}