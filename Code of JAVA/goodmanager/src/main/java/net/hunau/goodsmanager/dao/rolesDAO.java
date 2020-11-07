package net.hunau.goodsmanager.dao;

import com.mysql.cj.protocol.Resultset;
import net.hunau.goodsmanager.bean.Roles;
import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.utils.JDBCUtils;

import javax.management.relation.RoleInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rolesDAO extends baseDAO{
    public boolean addRoles(Roles roles){
        String sql = "insert into roles(id,roleName,roleDesc) values (?,?,?)";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, roles.getId());
            pstm.setString(2, roles.getRoleName());
            pstm.setString(3, roles.getRoleDesc());
            int result = pstm.executeUpdate();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String getRolesDesc(String rolesName){
        String result = null;
        try {
            String sql = "select * from roles where roleName=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,rolesName);
            int haveResult = pstm.executeUpdate();
            if(haveResult != 0){
                ResultSet rs = pstm.getResultSet();
                result = rs.getString("roleDesc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }

    public String getRolesDesc(int id){
        String result = null;
        try {
            String sql = "select * from roles where id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, String.valueOf(id));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                result = rs.getString("roleDesc");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    public List<Roles> getAllRoles(){
        List<Roles> rolesList = new ArrayList<>();
        String sql = "select * from roles";
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                Roles roles = new Roles();
                roles.setId(rs.getInt("id"));
                roles.setRoleName(rs.getString("roleName"));
                roles.setRoleDesc(rs.getString("roleDesc"));
                rolesList.add(roles);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return rolesList;
    }

    public boolean deleteRoles(int rolesid){
        try{
            String sql = "delete from roles where id=?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, String.valueOf(rolesid));
            int result = pstm.executeUpdate();
            if(result > 0){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
