package sw_all;

import java.util.Scanner;
//import sw_e.Main_Contacts;
import sw_all.main_memo;
//import sw_e.Main_Appointment;

public class PersonalInformation {
   public static void main(String[] args) {
      int option_choice = 0; // while������ ���� ���� �ʱⰪ �׳� 0���� ��������, 1 ~ 5 ��� �� ������ ������ ��
      Scanner scanner = new Scanner(System.in);
      
      while(option_choice != 5) {
         System.out.println("���ϴ� ����� ���ڷ� �Է��ϼ���.\n1. Contacts 2. To-do list 3. Appointment 4. Memo 5. Exit");
             option_choice = scanner.nextInt();
         switch (option_choice) {
            case 1:
               Main_Contacts.main(args);
               //Contacts
               break;
               
            case 2:
               //To-do list
               break;
               
            case 3:
               //Main_Appointment.main(args);
               //Appointment
               break;
               
            case 4:
               main_memo memo = new main_memo();
               memo.main(args);
               break;
         
            case 5://������ ���
               System.out.println("���α׷��� �����մϴ�.");
               break;
               default:
                  System.out.print("�߸��� �Է��Դϴ�.");
         }
      }   
      scanner.close();
   }

}