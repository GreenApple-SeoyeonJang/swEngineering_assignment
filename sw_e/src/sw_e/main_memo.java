package sw_e;

import java.io.*;
import java.util.Scanner;

// ���� ������ �����ϱ�
public class main_memo {
	public static void main(String args[]) {
		Select_m();
	}

		static void Select_m(){
			File file = new File("c://Example//File");
			if(!file.exists()){
	            file.mkdirs();
	        }
			Scanner s = new Scanner(System.in);
			System.out.println("1. �޸� ����");
			System.out.println("2. �޸� ����");
			System.out.println("3. �޸� ����");
			System.out.println("4. �޸� ����");
			System.out.println("5. �������� ���ư���");
			int num = s.nextInt();
			while (num !=5) {
				switch (num){
					case 1:
						Create_m();
						break;
					case 2:
						Scanner s1 = new Scanner(System.in);
						if (View2_m()>0) {
							System.out.println("Ư�� �޸��� ������ ���ðڽ��ϱ�?(yes�ΰ��: yes �Է��� ����ġ�� �޸��� ������ �Է��ϼ���, no�� ���:no�� �Է��ϼ���)");
						    String ans = s1.nextLine();
						    if( ans.equals("yes")) {
						    	String title = s1.nextLine();
						    	View_m(title);
						    }
						}
						else {
					    	System.out.println("������ �޸� �������� �ʽ��ϴ�.");
					    }
						break;
					case 3:
						Scanner s2 = new Scanner(System.in);
						System.out.println("������ �޸��� ������ �Է��ϼ���");
						String title = s2.nextLine();
						Update_m(title);
						break;
					case 4:
						Scanner s3 = new Scanner(System.in);
						System.out.println("������ �޸��� ������ �Է��ϼ���");
						String title2 = s3.nextLine();
						Delete_m(title2);
						break;
				}
				System.out.println("1��:�޸� ����");
				System.out.println("2��:�޸� ����");
				System.out.println("3��:�޸� ����");
				System.out.println("4��:�޸� ����");
				System.out.println("5��:�������� ����");
				num = s.nextInt();
			}
			s.close();
			System.exit(0);
	}

	static void Create_m(){
		 Scanner s = new Scanner(System.in);
		 BufferedWriter writer = null;
		        try {
		        	System.out.println("��¥�� �Է��ϼ���(ex,2018�� 11�� 20�� ���� 2�� 20���� ���: 2018 11 20 14 20�� �Է���");
		            String date = s.nextLine();
		            System.out.println("������ �Է��ϼ���");
		            String title = s.nextLine();
		            
		            File file1 = new File("c://Example//File//");
				    File[] files = file1.listFiles();
				    for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
				         String ss = files[fileIntList].toString();
				         if (title.equals(ss.substring(ss.lastIndexOf("\\") + 1, ss.length()-4))) {
				             System.out.println("�ٸ� ������ �Է��ϼ���.");
				         }
				     }
				    title = s.nextLine();
		            writer = new BufferedWriter(new FileWriter("c://Example//File//"+ title + ".txt"));
		        	writer.write("��¥:" + date + "\r\n");
		        	writer.write("����:" + title + "\r\n");
		            System.out.println("������ �Է��ϼ���");
		            String story = s.nextLine();
		            while (!story.equals("store")){
		            	writer.write( story + "\r\n");
		            	story = s.nextLine();
		            }
		            writer.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
	static int View2_m(){
		 Scanner s = new Scanner(System.in);
			File file1 = new File("c://Example//File//");
		    File[] files = file1.listFiles();
		    if (null != files) {
		        for (int fileIntList = 0; fileIntList < files.length; fileIntList++) {
		            String ss = files[fileIntList].toString();
		            if (null != ss && ss.length() > 0) {
		                System.out.println("File" + (fileIntList + 1) + " :" + ss.substring(ss.lastIndexOf("\\") + 1, ss.length()));
		            }
		        }
		        return files.length;
		    }
	    	return 0;
	 }
	static void View_m(String title){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("c://Example//File//"+ title + ".txt"));
			String data = "";
         
			while ((data = reader.readLine()) != null) {
				System.out.println(data);
			}
			reader.close();
         }catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		
        }
	static void Update_m(String title){
		BufferedWriter writer=null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader("c://Example//File//"+ title + ".txt"));
			String data = "";
         
			while ((data = reader.readLine()) != null) {
				System.out.println(data);
			}
			reader.close();
			File file1 = new File("c://Example//File//"+ title+ ".txt");
			file1.delete();
         }catch (FileNotFoundException e) {
	            e.printStackTrace();
	     } catch (IOException e) {
	            e.printStackTrace();
	       }
		try {
        	Scanner s = new Scanner(System.in);
        	System.out.println("��¥�� �Է��ϼ���(ex,2018�� 11�� 20�� ���� 2�� 20���� ���: 2018 11 20 14 20�� �Է���");
            String date = s.nextLine();
            System.out.println("������ �Է��ϼ���");
            String title1 = s.nextLine();
            writer = new BufferedWriter(new FileWriter("c://Example//File//"+ title1 + ".txt"));
        	writer.write("��¥:" + date + "\r\n");
        	writer.write("����:" + title1 + "\r\n");
            System.out.println("������ �Է��ϼ���");
            String story = s.nextLine();
            while (!story.equals("store")){
            	writer.write( story + "\r\n");
            	story = s.nextLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	static void Delete_m(String title) {
		File file1 = new File("c://Example//File//"+ title+ ".txt");
        if( file1.exists() ){
            if(file1.delete()){
                System.out.println("���ϻ����� �����Ͽ����ϴ�.");
            }else{
                System.out.println("���ϻ����� �����Ͽ����ϴ�.");
            }
        }else{
            System.out.println("������ �������� �ʽ��ϴ�.");
        }
	}
}