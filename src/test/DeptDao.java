package test;

import java.sql.SQLException;
import java.util.List;

public interface DeptDao {
    public List<Dept> finall();
    public int sava(Dept dept);
    public int remove(int id);
    public int update(Dept dept) throws SQLException;
}
