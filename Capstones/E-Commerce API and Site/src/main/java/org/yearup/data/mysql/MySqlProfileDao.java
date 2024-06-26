package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.yearup.models.Category;
import org.yearup.models.Product;
import org.yearup.models.Profile;
import org.yearup.data.ProfileDao;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class MySqlProfileDao extends MySqlDaoBase implements ProfileDao {
    public MySqlProfileDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public Profile create(Profile profile) {
        String sql = "INSERT INTO profiles (user_id, first_name, last_name, phone, email, address, city, state, zip) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, profile.getUserId());
            ps.setString(2, profile.getFirstName());
            ps.setString(3, profile.getLastName());
            ps.setString(4, profile.getPhone());
            ps.setString(5, profile.getEmail());
            ps.setString(6, profile.getAddress());
            ps.setString(7, profile.getCity());
            ps.setString(8, profile.getState());
            ps.setString(9, profile.getZip());

            ps.executeUpdate();

            return profile;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile getProfileByUserId(int userId) {
        String query = "{Call getUserProfileById(?)}";
        Profile profile = null;
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, userId);

            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {

                    profile = mapRow(rs);
                }


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            return profile;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile updateProfile(int userId, Profile profile) {
        String query = "{Call updateUserProfile(?,?,?,?,?,?,?,?,?)}";
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, userId);
            cs.setString(2, profile.getFirstName());
            cs.setString(3, profile.getLastName());
            cs.setString(4, profile.getPhone());
            cs.setString(5, profile.getEmail());
            cs.setString(6, profile.getAddress());
            cs.setString(7, profile.getCity());
            cs.setString(8, profile.getState());
            cs.setString(9, profile.getZip());

            cs.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return profile;
    }


        private Profile mapRow (ResultSet row) throws SQLException {
            int userId = row.getInt("user_id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");
            String phone = row.getString("phone");
            String email = row.getString("email");
            String address = row.getString("address");
            String city = row.getString("city");
            String state = row.getString("state");
            String zip = row.getString("zip");


            Profile profile = new Profile() {{
                setUserId(userId);
                setFirstName(firstName);
                setLastName(lastName);
                setPhone(phone);
                setEmail(email);
                setAddress(address);
                setCity(city);
                setState(state);
                setZip(zip);
            }};

            return profile;
        }
    }
