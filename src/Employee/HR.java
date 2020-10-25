package Employee;

import java.sql.Connection;
import java.sql.SQLException;

import DatabaseCode.UserAccountDAO;

public class HR extends Employee {

    private UserAccountDAO dao;

    public HR(Connection db, int id) {
        super(db, id);
    }
    
    public void updateHI(String hi, int ID) throws SQLException { 
        dao.modifyInsurance(hi,ID);
    }
    
    public void updateSalary(int sal, int ID) throws SQLException { 
        dao.modifySalary(sal,ID);
    }
    
    public void updatePosition(String pos, int ID) throws SQLException { 
        
        dao.modifyPosition(pos,ID);
    }
    
    public void updateRetirement(Boolean retire, int ID) throws SQLException { 
        dao.modifyRetirement(retire,ID);
    }
    
}