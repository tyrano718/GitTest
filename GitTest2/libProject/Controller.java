package libProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		Osystem osys = new Osystem(); // ȭ����� ��ä����
		int menu;// ȭ�� �޴����ÿ� Ȱ���� �޴�
		Scanner scan = new Scanner(System.in);// �޴� �Է½� ����� ��ĳ��
		BookDB bookDB = new BookDB(); // å DB ��ü����

		// bookDB.insert(new Book("����� ��ȭ1")); //å DB�� å ��ü����
		// bookDB.insert(new Book("����� ��ȭ2"));
		// bookDB.insert(new Book("����� ��ȭ3"));
		List<Book> searchBooks = bookDB.search("����� ��ȭ"); // å DB���� å �˻�

		for (Book b : searchBooks) {
			System.out.println(b.title);
		} // å �˻� ��� ���
		System.out.println("---------------------------------");

		MemberDB memberDB = new MemberDB(); // ȸ�� DB ��ü����

		memberDB.insert(new Member("���ڹ�")); // ȸ�� DB ��ü����
		memberDB.insert(new Member("���ڹ�"));
		memberDB.insert(new Member("���ڹ�"));
		List<Member> searchMembers = memberDB.search("�ڹ�"); // ȸ�� DB ��ü����

		for (Member m : searchMembers) {
			System.out.println(m.name);
		} // ȸ�� DB ��ü����

		// -----------------���ν���-----------------------
		main: while (true) {
			observer: while (true) {//----------------------��ȸ�� while-------------------
				osys.observer_main();//��ȸ�� ����ȭ��
				menu = scan.nextInt();
				scan.nextLine();
				switch (menu) {//1.�����˻� 2.ȸ������ 3.�α��� 4.�����ڷα��� 5.���̵�/��й�ȣ ã��
				case 1://1.�����˻�
					osys.observer_search();//��ȸ�� �����˻� ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch(menu) {//1.���� 2.���� 3.���ǻ� 4.���� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ������
					case 1://����
						//���� �˻� �޼���
						break;
					case 2://����
						//���� �˻� �޼���
						break;
					case 3://���ǻ�
						//���ǻ� �˻� �޼���
						break;
					case 4://����
						//���� �˻� �޼���
						break;
					case 5://�ε���
						//�ε��� �˻� �޼���
						break;
					case 6://ISBN
						//ISBN�˻� �޼���
						break;
					case 7://��ü �������
						//��ü������� ��¸޼���
						break;
					case 0://����ȭ������
						System.out.println("����ȭ������ ���ư��ϴ�.");
						continue observer;
					}
					break;
					
				case 2://ȸ������
					osys.observer_signin();//ȸ������ ȭ��
					//ȸ������ �޼���
					break;
				case 3://�α���
					System.out.println("���̵� �Է��ϼ���.");
					String id = scan.nextLine();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String pass = scan.nextLine();
					//�α��� �޼���
					break observer;//������ ��ȸ���޴� ���� 
				case 4://�����ڷα���
					System.out.println("���̵� �Է��ϼ���.");
					id = scan.nextLine();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					pass = scan.nextLine();
					//�α��� �޼���
					break observer;//������ ��ȸ���޴� ���� 
				case 5://���̵� ��й�ȣã��
					osys.observer_findMember();//����ã�� ȭ��
					menu = scan.nextInt();
					scan.nextLine();
					switch(menu) {//1. ���̵� ã�� 2.��й�ȣ ã�� 0. ����ȭ��
					case 1://���̵� ã��
						osys.observer_findId();//���̵�ã�� ȭ��
						//���̵� ã�� �޼���
					case 2://��й�ȣ ã��
						osys.observer_findPass();//��й�ȣã�� ȭ��
						//��й�ȣ ã�� �޼���
					case 0://����ȭ��
						System.out.println("����ȭ������ ���ư��ϴ�.");
						continue observer;
					}
					break;
				case 0://���α׷� ����
					System.out.println("���α׷��� �����մϴ�...");
					break main;
				}//end switch
				break;
			} //--------------------------��ȸ�� while end-----------------------
			member: while (true) {
				osys.member_main();
				menu = scan.nextInt();
				scan.nextLine();
				switch(menu) {//1.�����˻����� 2.�������� 3.�����ݳ� 4.ȸ������ 5.���ǻ��� 9.�α׾ƿ� 0.����");
					case 1://�����˻�����
						osys.member_search();//ȸ�� �����˻�ȭ��
						menu = scan.nextInt();
						scan.nextLine();
						switch(menu) {//1.���� 2.���� 3.���ǻ� 4.���� 5.�ε��� 6.ISBN 7.��ü ������� 0.����ȭ������
						//�Ʒ��� �����ɵ� �߰�
						case 1://����
							//���� �˻� �޼���
							break;
						case 2://����
							//���� �˻� �޼���
							break;
						case 3://���ǻ�
							//���ǻ� �˻� �޼���
							break;
						case 4://����
							//���� �˻� �޼���
							break;
						case 5://�ε���
							//�ε��� �˻� �޼���
							break;
						case 6://ISBN
							//ISBN�˻� �޼���
							break;
						case 7://��ü �������
							//��ü������� ��¸޼���
							break;
						case 0://����ȭ������
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue member;
						}//end switch
						break;
					case 2://��������
						//�������� ��� �޼���
						break;
					case 3://�����ݳ�
						//�������� ��� �޼���
						//�����ݳ� �޼���
						break;
					case 4://ȸ������
						osys.member_inform();
						menu = scan.nextInt();
						scan.nextLine();
						switch(menu) {//1.ȸ������ ��ȸ 2.ȸ������ ���� 0. ����ȭ��
						case 1://ȸ������ ��ȸ
							osys.member_myinform();//ȸ������ ��ȸ ȭ��
							//ȸ������ ��ȸ �޼���
						case 2://ȸ������ ����
							osys.observer_findPass();//ȸ������ ���� ȭ��
							//ȸ������ ���� �޼���
						case 0://����ȭ��
							System.out.println("����ȭ������ ���ư��ϴ�.");
							continue member;
						}
						break;
					case 5://���ǻ���
						osys.member_request();
						//�ϴ̻��� �޼���
						break;
					case 9://�α׾ƿ�
						break;
					case 0://����
						System.out.println("���α׷��� �����մϴ�...");
						break main;
				}//end switch
				break;
			} //-----------------------------ȸ�� while end-----------------------
			admin: while (true) {
				break;
			} //--------------------------------������ while end-------------------------
		} // end while_main

	}// end main

}// end class