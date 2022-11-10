
package dateinjavatomysql;

import java.util.Date;


public class Users {
    
    private String Name;
    private Date Birthday;

    public Users(String Name, Date Birthday) {
        this.Name = Name;
        this.Birthday = Birthday;
    }

    public String getName() {
        return Name;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }
    
    
    
}
