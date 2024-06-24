package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        // get all categories
        String query = "{Call getAllCategories()}";
        List<Category> categories = new ArrayList<>();

        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {

                Category category = mapRow(rs);
                categories.add(category);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        // get category by id
        String query = "{CALL getCategoryById(?)}";
        Category category = null;
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                category = mapRow(rs);
            }
        } catch (SQLException e) {

            throw new RuntimeException();
        }
        return category;
    }

    @Override
    public Category create(Category category) {
        // create a new category
        String query = "{Call addCategory(?,?)}";
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setString(1, category.getName());
            cs.setString(2, category.getDescription());

            cs.executeUpdate();

            // Retrieve the generated ID from the stored procedure result set
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    int generatedId = rs.getInt("generated_id");
                    category.setCategoryId(generatedId); // Set the generated ID to the Category object
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing stored procedure", e);
        }
        return category;
    }

    @Override
    public Category update(int categoryId, Category category) {
        // update category
        String query = "{Call updateCategory(?,?,?)}";
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);
            cs.setString(2, category.getName());
            cs.setString(3, category.getDescription());

            cs.executeUpdate();

            // Retrieve the generated ID from the stored procedure result set
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    int generatedId = rs.getInt("generated_id");
                    category.setCategoryId(generatedId); // Set the generated ID to the Category object
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing stored procedure", e);
        }
        return category;
    }

    @Override
    public void delete(int categoryId) {
        // delete category
        String query = "{Call deleteCategory(?)}";
        try (Connection conn = getConnection(); CallableStatement cs = conn.prepareCall(query)) {
            cs.setInt(1, categoryId);

            cs.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category() {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
