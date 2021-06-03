/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class RollBackDB {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void RollBackLoaiSP() throws Exception {
        String query = "Truncate Table loai_sp\n"
                + "INSERT INTO [QL_CHANG].[dbo].[loai_sp] VALUES(N'Tủ Lạnh',N'Tủ lạnh siêu nóng','2021-04-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[loai_sp] VALUES(N'Chảo',N'Chảo chống dính','2021-04-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[loai_sp] VALUES(N'PC',N'Siêu máy tính','2021-04-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[loai_sp] VALUES(N'Máy in',N'Máy in không ra mực','2021-04-04');";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void RollBackNhanVien() throws Exception {
        String query = "Truncate Table nhan_vien\n"
                + "INSERT INTO [QL_CHANG].[dbo].[nhan_vien] VALUES(N'Minh','0969341099','nqm0904@gmail.com',N'Hà Nội','Stu','2021-01-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[nhan_vien] VALUES(N'sun','0969341021','sun@gmail.com',N'TP HCM','Stu','2021-02-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[nhan_vien] VALUES(N'Nam','0932032320','Nam@gmail.com',N'Hà Nội','Te','2021-03-04');\n"
                + "INSERT INTO [QL_CHANG].[dbo].[nhan_vien] VALUES(N'Mạnh','0969341099','Manh@gmail.com',N'Hà Nội','Stu','2021-04-04');";
        try {
            conn = new ConnectDB().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }
}
