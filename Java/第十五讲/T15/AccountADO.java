package T15;

import java.util.Vector;

public interface AccountADO {

	public void add(AccountInfo account);
	public void update(AccountInfo account);
	public void delete(AccountInfo account);
	public Vector<AccountInfo> find();
	
}
