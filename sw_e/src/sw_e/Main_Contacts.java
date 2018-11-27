package sw_e;

import java.util.Scanner;

public class Main_Contacts {
	static class ContactM {
		String name, phone, email;
		public ContactM(String name, String phone, String email) {
			this.name = name;
			this.phone = phone;
			this.email = email;
		}
	}
	
	public static Scanner sc= new Scanner(System.in); 
	public static final int CREATE = 1;
	public static final int VIEW = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	public static final int MAIN_MENU = 5;
	public static int index = 0;
	public static ContactM [] contact = new ContactM[100];
	
	public static void create() {
		System.out.println("-------����ó ����-------");
		System.out.print("�̸�>> ");
		String name = sc.next();
		System.out.print("��ȭ��ȣ>> ");
		String phone = sc.next();
		System.out.print("�̸���>> ");
		String email = sc.next();
		contact[index] = new ContactM(name, phone, email);
		index++;
	}
	
	public static void view() {
		System.out.println("-------����ó ����-------");
		if(index==0) {
			System.out.println("����� ����ó�� �����ϴ�.");
		}
		else if(index>0){
			System.out.print("�̸�>> ");
			String name = sc.next();
			if(name.equals("ALL")) {
				for(int i=0; i<index; i++) {
					System.out.println("����ó["+i+"]");
					System.out.println("�̸�: "+contact[i].name);
					System.out.println("��ȭ��ȣ: "+contact[i].phone);
					System.out.println("�̸���: "+contact[i].email);
				
				}
			}
			else if(search(name)>=0) {
				System.out.println("ã���ô� "+name+ "�� ����ó");
				System.out.println("�̸�: "+contact[search(name)].name);
				System.out.println("��ȭ��ȣ: "+contact[search(name)].phone);
				System.out.println("�̸���: "+contact[search(name)].email);
			}
			else if(search(name)==-1) {
				System.out.println("ã���ô� "+name+ "�� ����ó�� �������� �ʽ��ϴ�.");
			}
		}
	}
	
	public static void update() {
		System.out.println("-------����ó ����-------");
		System.out.print("�̸�>> ");
		String name = sc.next();
		if(search(name)==-1) {
			System.out.println("ã���ô� "+name+ "�� ����ó�� �������� �ʽ��ϴ�.");
		}
		else {
			System.out.println("�����ϰ� ���� �׸�");
			System.out.println("1)�̸�   2)��ȭ��ȣ   3)�̸���");
			int num = sc.nextInt();
			if(num==1) {
				System.out.print("�̸�>> ");
				String rname = sc.next();
				contact[search(name)].name = rname;
			}
			else if(num==2) {
				System.out.print("��ȭ��ȣ>> ");
				String rphone = sc.next();
				contact[search(name)].phone = rphone;
			}
			else if(num==3) {
				System.out.print("�̸���>> ");
				String remail = sc.next();
				contact[search(name)].email = remail;
			}
		}
	}
	
	public static void delete() {
		System.out.println("-------����ó ����-------");
		System.out.print("�̸�>> ");
		String name = sc.next();
		
		if(search(name)==-1) {
			System.out.println("ã���ô� "+name+ "�� ����ó�� �������� �ʽ��ϴ�.");
		}
		else {
		
			System.out.println("�����Ϸ��� "+name+ "�� ����ó");
			System.out.println("�̸�: "+contact[search(name)].name);
			System.out.println("��ȭ��ȣ: "+contact[search(name)].phone);
			System.out.println("�̸���: "+contact[search(name)].email);
			System.out.println("1)��   2)�ƴϿ�");
			int num = sc.nextInt();
			if(num==1) {
				for(int i=search(name); i<index-1; i++) {
					contact[i].name = contact[i+1].name;
					contact[i].phone = contact[i+1].phone;
					contact[i].email = contact[i+1].email;
				}
				index -= 1;
			}
			else if(num==2) {
				System.out.println(name+ "�� ����ó�� �������� �ʰ� �޴��� �̵��մϴ�.");
			}
		}
	}
	
	public static int search(String name) {
		int ind=-1;
		for(int i=0; i<index; i++)
			if(name.equals(contact[i].name))
				ind = i;
		return ind;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String select = "a";
		while (!select.equals("5")) {
			System.out.println();
			System.out.println("-----------");
			System.out.println("����ó ���� �޴�");
			System.out.println("-----------");
			System.out.println("1)����");
			System.out.println("2)����");
			System.out.println("3)����");
			System.out.println("4)����");
			System.out.println("5)�ڷ� ����");
			System.out.println("-----------");
			System.out.println("����>>");
			
			select = sc.next();
			
			if(select.equals("1"))
				Main_Contacts.create();
			else if(select.equals("2"))
				Main_Contacts.view();
			else if(select.equals("3"))
				Main_Contacts.update();
			else if(select.equals("4"))
				Main_Contacts.delete();
			else if(select.equals("5"))
				System.out.println("���� �޴��� ���ư��ϴ�.");
				
		}
		sc.close();
	}
}
