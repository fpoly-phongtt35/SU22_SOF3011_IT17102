package repository;

import model.Account;
import model.AccountRole;

public class AccountRepository {

	private static Account[] accounts = new Account[] {
		new Account("PhongTT35", "1234", AccountRole.USER),
		new Account("admin", "admin", AccountRole.ADMIN)
	};
	
	public Account getByUsername(String username) {
		// Duyệt danh sách tài khoản
		for(Account account : accounts) {
			// Nếu tên tài khoản bằng giá trị tìm kiếm
			if (account.getUsername()
					.equalsIgnoreCase(username)) {
				// thì trả về tài khoản
				return account;
			}
		}
		
		// Không tìm thấy, trả về NULL
		return null;
	}
}
