package tapplication.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by alexpench on 25.03.17.
 */
@Entity
@Table(name = "role")
public class Role {

    public static final String TYPE = "type";

    public enum UserRoleType implements Serializable {
        USER("USER"),
        DBA("DBA"),
        ADMIN("ADMIN");

        String userProfileType;

        private UserRoleType(String userRoleType){
            this.userProfileType = userRoleType;
        }

        public String getUserRoleType(){
            return userProfileType;
        }

    }

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name= TYPE, length=15, unique=true, nullable=false)
    private String type = UserRoleType.USER.getUserRoleType();

    public Role(){}
    public Role(String type){
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
