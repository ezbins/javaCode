package exec;

import java.util.List;

public interface CallNumberDAO_interface {
	public int insert(CallNumberVO callNumberVO);
	public int update(CallNumberVO callNumberVO);
	public CallNumberVO findByGwMac(String GwMac);
	public List<CallNumberVO> getAll();
}
