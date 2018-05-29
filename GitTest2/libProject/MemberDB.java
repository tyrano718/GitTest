package com.javalec.ex0529;

import java.util.*;

public class MemberDB extends DB {
	List<Member> memberList;
	// ���� ����
	Scanner scanner = new Scanner(System.in);
	String id = "";
	String password = "";
	String name = "";
	String ssn = "";
	String tel = "";

	public MemberDB() {
		memberList = new ArrayList<>();
	}

	@Override
	List<Member> search(String str) { // ȸ�� ��ü�˻�
		List<Member> searchList = new ArrayList<Member>();
		for (Member m : memberList) {
			if (m.getName().contains(str))
				searchList.add(m);
		}
		return searchList;
	}

	Data input() { // ȸ������ �޼���
		System.out.println("���̵� �Է����ּ���"); // ���̵� �Է�
		id = scanner.nextLine();
		while (true) { // ��й�ȣ Ȯ�� ������ ���� �ݺ�
			System.out.println("��й�ȣ�� �Է����ּ���"); // ��й�ȣ �Է�
			password = scanner.nextLine();
			System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
			String passright = scanner.nextLine();
			if (passright.equals(password)) {
				System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
				break; // ��й�ȣ Ȯ���� ������ ���� �ܰ��
			} else {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
				continue; // ��й�ȣ Ȯ���� Ʋ���� �ٽ� ��й�ȣ �Է� �ܰ��
			}
		}
		System.out.println("�̸��� �Է����ּ���.");
		name = scanner.nextLine();
		System.out.println("��������� �Է����ּ���.");
		ssn = scanner.nextLine();
		System.out.println("��ȭ��ȣ�� �Է����ּ���.");
		tel = scanner.nextLine();

		Member m = new Member(id, password, name, ssn, tel);
		return m;
	}

	@Override
	void insert(Data data) {
		memberList.add((Member) data);
	}

	@Override
	void delete(Data data) {
		Member m = (Member) data;
		memberList.remove(m);
	}

	@Override
	void update(Data data) { // ȸ�� ���� ���� �޼���
		Member m = (Member) data;
		System.out.println("������ ���Ͻô� �׸��� �Է����ּ���.");// 1.���̵� 2.��й�ȣ 3.�̸� 4.������� 5.��ȭ��ȣ
		int menu = scanner.nextInt();
		scanner.nextLine();
		switch (menu) {
		case 1: // ���̵� ����
			System.out.println("�����Ͻ� ���̵� �Է����ּ���.");
			System.out.println("���̵� : " + m.getId());
			m.setId(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ���̵� : " + m.getId());
			break;
		case 2: // ��й�ȣ ����
			while (true) {
				System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ���.");
				m.setPassword(m.getPassword());
				System.out.println("��й�ȣ�� �ѹ� �� �Է����ּ���");
				String passright = scanner.nextLine();
				if (passright.equals(m.getPassword())) {
					System.out.println("��й�ȣ�� Ȯ���Ͽ����ϴ�.");
					break;
				} else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է����ּ���.");
					continue;
				}
			}
			break;
		case 3: // �̸� ����
			System.out.println("�����Ͻ� �̸��� �Է����ּ���.");
			System.out.println("�̸� : " + m.getName());
			m.setName(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. �̸� : " + m.getName());
			break;

		case 4: // ������� ����
			System.out.println("�����Ͻ� ������ϸ� �Է����ּ���.");
			System.out.println("������� : " + m.getSsn());
			m.setSsn(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ������� : " + m.getSsn());
			break;
		case 5: // ��ȭ��ȣ ����
			System.out.println("�����Ͻ� ��ȭ��ȣ�� �Է����ּ���.");
			System.out.println("��ȭ��ȣ : " + m.getTel());
			m.setTel(scanner.nextLine());
			System.out.println("�����Ǽ̽��ϴ�. ��ȭ��ȣ : " + m.getTel());
			break;
		case 0:
			System.out.println("�����޴��� �̵��մϴ�.");
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �޴��� �������ּ���.");
			break;
		}
	}

	int Login(String id, String password) { // �α��� �޼���
		Member m = new Member(id, password, name, ssn, tel);
		int login = 0;
		login1: while (true) {

			System.out.println("���̵� �Է��ϼ���. �����޴��� �̵�(0)");// ���̵� �Է�
			String idInput = scanner.nextLine();
			int premenu = Integer.parseInt(idInput);
			if (premenu == 0) {
				login = 0;
				break login1;

			}
			for (int i = 0; i < memberList.size(); i++) {
				if (m.getId().equals(idInput)) {
					System.out.println("��й�ȣ�� �Է��ϼ���."); // ��й�ȣ �Է�
					String passInput = scanner.nextLine();
					if (m.getPassword().equals(passInput)) { // ���̵�� ��й�ȣ�� ��ġ�Ҷ�
						System.out.println(m.getName() + "���� �α��� �ϼ̽��ϴ�.");
						System.out.println("ȸ�� �޴��� �̵��մϴ�.");
						login = 2;
						break login1;
					} else {
						System.out.println("��й�ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						continue; // ��й�ȣ�� ��ġ���� ������ �ٽ� ��й�ȣ �Է�
					}
				} else {
					System.out.println("�������� �ʴ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
					continue login1; // ���̵� ��ġ���� ������ �ٽ� ���̵��Էº���
				}
			}
		}
		return login;
	}

	void Logout() {
		while (true) {
			System.out.println("�α׾ƿ� �Ͻðڽ��ϱ�? y/n");
			String out = scanner.nextLine();
			if (out.equals("y")) {
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				break;
			} else if (out.equals("n")) {
				System.out.println("�α׾ƿ��� ����ϼ̽��ϴ�.");
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. y/n���� �Է����ּ���.");
				continue;
			}
		}
	}

	@Override
	List<Member> searchAll() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.println((Member) memberList.get(i));
		}
		return null;
	}

	@Override
	List align() {
		// TODO Auto-generated method stub
		return null;
	}
}
